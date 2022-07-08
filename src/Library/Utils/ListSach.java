package Library.Utils;


import Library.Entities.Sach;


public class ListSach {

    NodeSach head, tail;

    public ListSach() {
        this.head = null;
        this.tail = null;
    }

    public NodeSach getHead() {
        return head;
    }

    public NodeSach getTail() {
        return tail;
    }

    public void insertHead(Sach sach) {
        NodeSach newNode = new NodeSach(sach);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head); // Gán newNode vào đầu danh sách.
            head = newNode;           // cập nhật lại vị trí đầu của danh sách.
        }
    }

    public void insertTail(Sach sach) {
        NodeSach newNode = new NodeSach(sach);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);      // Gán newNode vào cuối danh sách.
            tail = newNode;               // Cập nhật lại vị trí cuối của danh sách.
        }
    }


    public void removeNode(NodeSach nodeSach) {
        NodeSach nb = head;
        NodeSach NodeCuOisAch = nb;
        while (nb != null) {
            if (nb == nodeSach) {
                break;
            } else {
                NodeCuOisAch = nb;
                nb = nb.getNext();
            }
        }
        if (nb == head) head = head.getNext(); // Nếu node ở đầu danh sách.
        else {
            if (nb.getNext() == null) {
                NodeCuOisAch = null; // Nếu node ở cuối danh sách.
            } else {
                NodeCuOisAch.setNext(nb.getNext());
            }
        }


    }

    public void sapXepTheoTen() {
        Sach tmp;
        String TenKHongHAy;
        String TenHay;
        if (head == null) return;
        NodeSach nb = head, NodeTiEpTheo;
        while (nb.getNext() != null) {
            NodeTiEpTheo = nb.getNext();
            TenKHongHAy = nb.getInfo().getTenSach().split(" ")[nb.getInfo().getTenSach().split(" ").length - 1];
            while (NodeTiEpTheo != null) {
                TenHay = NodeTiEpTheo.getInfo().getTenSach().split(" ")[NodeTiEpTheo.getInfo().getTenSach().split(" ").length - 1];
                if (TenKHongHAy.compareToIgnoreCase(TenHay) > 0) {
                    TenKHongHAy = TenHay;
                    tmp = nb.getInfo();
                    nb.setInfo(NodeTiEpTheo.getInfo());
                    NodeTiEpTheo.setInfo(tmp);
                }
                NodeTiEpTheo = NodeTiEpTheo.getNext();
            }
            nb = nb.getNext();
        }
    }

    public class NodeSach {

        private Sach info;
        private NodeSach next;

        public NodeSach() {
            this.info = new Sach();
            next = null;
        }

        public NodeSach(Sach info) {
            this.info = info;
        }

        public Sach getInfo() {
            return info;
        }

        public void setInfo(Sach info) {
            this.info = info;
        }

        public NodeSach getNext() {
            return next;
        }

        public void setNext(NodeSach next) {
            this.next = next;
        }
    }

}
