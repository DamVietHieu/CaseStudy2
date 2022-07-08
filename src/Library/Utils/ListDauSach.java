package Library.Utils;


import Library.Entities.DauSach;


public class ListDauSach {
    private NodeDauSach head;
    private NodeDauSach tail;

    public ListDauSach() {
        this.head = null;
        this.tail = null;
    }

    public NodeDauSach getHead() {
        return head;
    }

    public NodeDauSach getTail() {
        return tail;
    }

    public void insertHead(DauSach dauSach) {
        NodeDauSach newNode = new NodeDauSach(dauSach);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head); // Gán newNode vào đầu danh sách.
            head = newNode;           // cập nhật lại vị trí đầu của danh sách.
        }
    }

    public void insertTail(DauSach dauSach) {
        NodeDauSach newNode = new NodeDauSach(dauSach);
        if (head == null) head = tail = newNode;
        else {
            tail.setNext(newNode);      // Gán newNode vào cuối danh sách.
            tail = newNode;               // Cập nhật lại vị trí cuối của danh sách.
        }
    }

    public void deleteNode(NodeDauSach nodeDauSach) {
        NodeDauSach nb = head;
        NodeDauSach NodeCuOisAch = nb;
        while (nb != null) {
            if (nb == nodeDauSach) break;
            else {
                NodeCuOisAch = nb;
                nb = nb.getNext();
            }
        }

        if (nb == null) return; // Không tồn tại node.
        if (NodeCuOisAch != null)          // Tồn tại
        {
            NodeCuOisAch.setNext(nb.getNext());
            nb = null;
        } else // nếu là đầu danh sách.
        {
            head = nb.getNext();
        }
    }

    public void removeNode(NodeDauSach nodeDauSach) {
        NodeDauSach nb = head;
        NodeDauSach NodeCuOisAch = nb;
        while (nb != null) {
            if (nb == nodeDauSach) {
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
        DauSach tmp;
        String loai1;
        String loai2;
        if (head == null) return;
        NodeDauSach nb = head;
        NodeDauSach NodeTiEpTheo;
        while (nb.getNext() != null) {
            NodeTiEpTheo = nb.getNext();
            loai1 = nb.getInfo().getTenSach().split(" ")[nb.getInfo().getTenSach().split(" ").length - 1];
            while (NodeTiEpTheo != null) {
                loai2 = NodeTiEpTheo.getInfo().getTenSach().split(" ")[NodeTiEpTheo.getInfo().getTenSach().split(" ").length - 1];
                if (loai1.compareToIgnoreCase(loai2) > 0) {
                    loai1 = loai2;
                    tmp = nb.getInfo();
                    nb.setInfo(NodeTiEpTheo.getInfo());
                    NodeTiEpTheo.setInfo(tmp);
                }
                NodeTiEpTheo = NodeTiEpTheo.getNext();
            }
            nb = nb.getNext();
        }

    }


    public class NodeDauSach {
        private DauSach info;
        private NodeDauSach next;

        public NodeDauSach() {
            this.info = new DauSach();
            next = null;
        }

        public NodeDauSach(DauSach info) {
            this.info = info;
        }

        public DauSach getInfo() {
            return info;
        }

        public void setInfo(DauSach info) {
            this.info = info;
        }

        public NodeDauSach getNext() {
            return next;
        }

        public void setNext(NodeDauSach next) {
            this.next = next;
        }
    }
}
