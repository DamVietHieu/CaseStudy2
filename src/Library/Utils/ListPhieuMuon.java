package Library.Utils;


import Library.Entities.PhieuMuon;


public class ListPhieuMuon {
    private NodePhieuMuon head, tail;

    public ListPhieuMuon() {
        this.head = null;
        this.tail = null;
    }

    public NodePhieuMuon getHead() {
        return head;
    }

    public NodePhieuMuon getTail() {
        return tail;
    }

    public void insertHead(PhieuMuon phieuMuon) {
        NodePhieuMuon newNode = new NodePhieuMuon(phieuMuon);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head); // Gán newNode vào đầu danh sách.
            head = newNode;           // cập nhật lại vị trí đầu của danh sách.
        }
    }

    public void insertTail(PhieuMuon phieuMuon) {
        NodePhieuMuon newNode = new NodePhieuMuon(phieuMuon);
        if (head == null) head = tail = newNode;
        else {
            tail.setNext(newNode);      // Gán newNode vào cuối danh sách.
            tail = newNode;               // Cập nhật lại vị trí cuối của danh sách.
        }
    }

    public void deleteNode(NodePhieuMuon nodePhieuMuon) {
        NodePhieuMuon nb = head;
        NodePhieuMuon NodeCuOisAch = nb;
        while (nb != null) {
            if (nb == nodePhieuMuon) break;
            else {
                 NodeCuOisAch= nb;
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

    public void removeNode(NodePhieuMuon nodePhieuMuon) {
        NodePhieuMuon nb = head;
        NodePhieuMuon NodeCuOisAch = nb;
        while (nb != null) {
            if (nb == nodePhieuMuon) {
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
        PhieuMuon tmp;
        String loai1;
        String loai2;
        if (head == null) return;
        NodePhieuMuon nb = head, NodeTiEpTheo;
        while (nb.getNext() != null) {
            NodeTiEpTheo = nb.getNext();
            loai1 = nb.getInfo().getmaNguoiMuon().split(" ")[nb.getInfo().getmaNguoiMuon().split(" ").length - 1];
            while (NodeTiEpTheo != null) {
                loai2 = NodeTiEpTheo.getInfo().getmaNguoiMuon().split(" ")[NodeTiEpTheo.getInfo().getmaNguoiMuon().split(" ").length - 1];
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



    public class NodePhieuMuon {
        private PhieuMuon info;
        private NodePhieuMuon next;

        public NodePhieuMuon() {
            this.info = new PhieuMuon();
            next = null;
        }

        public NodePhieuMuon(PhieuMuon info) {
            this.info = info;
        }

        public PhieuMuon getInfo() {
            return info;
        }

        public void setInfo(PhieuMuon info) {
            this.info = info;
        }

        public NodePhieuMuon getNext() {
            return next;
        }

        public void setNext(NodePhieuMuon next) {
            this.next = next;
        }
    }
}