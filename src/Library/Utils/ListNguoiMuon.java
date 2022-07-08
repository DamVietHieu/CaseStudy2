package Library.Utils;


import Library.Entities.NguoiMuon;


public class ListNguoiMuon {
    private NodeNguoiMuon head, tail;

    public ListNguoiMuon() {
        this.head = null;
        this.tail = null;
    }

    public NodeNguoiMuon getHead() {
        return head;
    }

    public NodeNguoiMuon getTail() {
        return tail;
    }

    public void insertHead(NguoiMuon nguoiMuon) {
        NodeNguoiMuon newNode = new NodeNguoiMuon(nguoiMuon);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head); // Gán newNode vào đầu danh sách.
            head = newNode;           // cập nhật lại vị trí đầu của danh sách.
        }
    }

    public void insertTail(NguoiMuon nguoiMuon) {
        NodeNguoiMuon newNode = new NodeNguoiMuon(nguoiMuon);
        if (head == null) head = tail = newNode;
        else {
            tail.setNext(newNode);      // Gán newNode vào cuối danh sách.
            tail = newNode;               // Cập nhật lại vị trí cuối của danh sách.
        }
    }

    public void deleteNode(NodeNguoiMuon nodeNguoiMuon) {
        NodeNguoiMuon nb = head;
        NodeNguoiMuon NodeCuOisAch = nb;
        while (nb != null) {
            if (nb == nodeNguoiMuon) break;
            else {
                NodeCuOisAch = nb;
                nb = nb.getNext();
            }
        }

        if (nb == null) return; // Không tồn tại nodeMayAnh.
        if (NodeCuOisAch != null)          // Tồn tại
        {
            NodeCuOisAch.setNext(nb.getNext());
            nb = null;
        } else // nếu là đầu danh sách.
        {
            head = nb.getNext();
        }
    }

    public void removeNode(NodeNguoiMuon nodeNguoiMuon) {
        NodeNguoiMuon nb = head;
        NodeNguoiMuon NodeCuOisAch = nb;
        while (nb != null) {
            if (nb == nodeNguoiMuon) {
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
        NguoiMuon tmp;
        String loai1;
        String loai2;
        if (head == null) return;
        NodeNguoiMuon nb = head, NodeTiEpTheo;
        while (nb.getNext() != null) {
            NodeTiEpTheo = nb.getNext();
            loai1 = nb.getInfo().getTenNguoiMuon().split(" ")[nb.getInfo().getTenNguoiMuon().split(" ").length - 1];
            while (NodeTiEpTheo != null) {
                loai2 = NodeTiEpTheo.getInfo().getTenNguoiMuon().split(" ")[NodeTiEpTheo.getInfo().getTenNguoiMuon().split(" ").length - 1];
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



    public class NodeNguoiMuon {
        private NguoiMuon info;
        private NodeNguoiMuon next;

        public NodeNguoiMuon() {
            this.info = new NguoiMuon();
            next = null;
        }

        public NodeNguoiMuon(NguoiMuon info) {
            this.info = info;
        }

        public NguoiMuon getInfo() {
            return info;
        }

        public void setInfo(NguoiMuon info) {
            this.info = info;
        }

        public NodeNguoiMuon getNext() {
            return next;
        }

        public void setNext(NodeNguoiMuon next) {
            this.next = next;
        }
    }
}
