package org.apache.batik.util;
public class DoublyLinkedList {
    public static class Node {
        private org.apache.batik.util.DoublyLinkedList.Node next = null;
        private org.apache.batik.util.DoublyLinkedList.Node prev = null;
        public final org.apache.batik.util.DoublyLinkedList.Node getNext() {
            return next;
        }
        public final org.apache.batik.util.DoublyLinkedList.Node getPrev() {
            return prev;
        }
        protected final void setNext(org.apache.batik.util.DoublyLinkedList.Node newNext) {
            next =
              newNext;
        }
        protected final void setPrev(org.apache.batik.util.DoublyLinkedList.Node newPrev) {
            prev =
              newPrev;
        }
        protected final void unlink() { if (getNext() != null)
                                            getNext(
                                              ).
                                              setPrev(
                                                getPrev(
                                                  ));
                                        if (getPrev() != null)
                                            getPrev(
                                              ).
                                              setNext(
                                                getNext(
                                                  ));
                                        setNext(null);
                                        setPrev(null); }
        protected final void insertBefore(org.apache.batik.util.DoublyLinkedList.Node nde) {
            if (this ==
                  nde)
                return;
            if (getPrev(
                  ) !=
                  null)
                unlink(
                  );
            if (nde ==
                  null) {
                setNext(
                  this);
                setPrev(
                  this);
            }
            else {
                setNext(
                  nde);
                setPrev(
                  nde.
                    getPrev(
                      ));
                nde.
                  setPrev(
                    this);
                if (getPrev(
                      ) !=
                      null)
                    getPrev(
                      ).
                      setNext(
                        this);
            }
        }
        public Node() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVZe2wUxxmfO+MnNjYGG5eHwQ+sGMhdaEPT1ECDjR1MzsbF" +
           "gJSj4Zjbm/Mt3ttddufss1OagFRBWwlRCoRGwf8UREtJSB9Rm7ZJiaI2SWkj" +
           "kZC2aRVStX+EPFCDqqZVaZt+M7N7u7f3cC2BpZ1bz3zzzXyv3/fN7PnrqNQ0" +
           "UDNRaYBO6MQM9Kp0CBsmifUo2DS3QV9EeqwE/23XtcF7/agsjOYksDkgYZP0" +
           "yUSJmWG0RFZNilWJmIOExNiMIYOYxBjDVNbUMGqQzf6krsiSTAe0GGEEO7AR" +
           "QnMxpYYcTVHSbzGgaEkIdhLkOwlu8A53hVC1pOkTDnmTi7zHNcIok85aJkV1" +
           "oT14DAdTVFaCIdmkXWkDrdQ1ZWJE0WiApGlgj7LGUsHm0JocFbQ+XfvRzSOJ" +
           "Oq6CeVhVNcrFM7cSU1PGSCyEap3eXoUkzb3oS6gkhGa7iClqD9mLBmHRICxq" +
           "S+tQwe5riJpK9mhcHGpzKtMltiGKWrKZ6NjASYvNEN8zcKiglux8Mki7LCOt" +
           "kDJHxOMrg8ce21X3/RJUG0a1sjrMtiPBJigsEgaFkmSUGOaGWIzEwmiuCsYe" +
           "JoaMFXnSsnS9KY+omKbA/LZaWGdKJwZf09EV2BFkM1IS1YyMeHHuUNZ/pXEF" +
           "j4CsjY6sQsI+1g8CVsmwMSOOwe+sKbNGZTVG0VLvjIyM7Q8AAUwtTxKa0DJL" +
           "zVIxdKB64SIKVkeCw+B66giQlmrggAZFCwsyZbrWsTSKR0iEeaSHbkgMAVUl" +
           "VwSbQlGDl4xzAist9FjJZZ/rg2sPP6xuUv3IB3uOEUlh+58Nk5o9k7aSODEI" +
           "xIGYWL0idAI3PnfIjxAQN3iIBc2PvnjjvlXNF18WNIvy0GyJ7iESjUino3Mu" +
           "L+7pvLeEbaNC10yZGT9Lch5lQ9ZIV1oHhGnMcGSDAXvw4tZfPvjoOfK+H1X1" +
           "ozJJU1JJ8KO5kpbUZYUY9xOVGJiSWD+qJGqsh4/3o3J4D8kqEb1b4nGT0H40" +
           "S+FdZRr/H1QUBxZMRVXwLqtxzX7XMU3w97SOEGqEBy2CpwWJP/5L0YPBhJYk" +
           "QSxhVVa14JChMfnNICBOFHSbCEbB60eDppYywAWDmjESxOAHCWINcCVs1FJR" +
           "ZQL2OgpeD7ATYC6m307maSbZvHGfD5S+2BvyCkTLJk2JESMiHUt19954KnJJ" +
           "uBMLAUsnFK2E9QJivQBfTxjNu177IEAs8vn4WvPZ4oLOoajuHH5o8+5DrSXg" +
           "Vfr4LNArI23NyjY9DhLY8B2RLtTXTLZcXf2iH80KoXos0RRWWPLYYIwALEmj" +
           "VuRWRyEPOelgmSsdsDxmaBKJARoVSgsWlwptjBisn6L5Lg52smJhGSycKvLu" +
           "H108Ob5/xyN3+ZE/OwOwJUsBvNj0IYbbGXxu90Z+Pr61B699dOHEPs3BgKyU" +
           "YmfCnJlMhlavN3jVE5FWLMPPRJ7b187VXgkYTTHEFMBfs3eNLIjpsuGayVIB" +
           "Asc1I4kVNmTruIomDG3c6eFuOpc1DcJjmQt5NsiRft2wfur3r777Ka5JOynU" +
           "urL5MKFdLiBizOo55Mx1PHKbQQjQvXVy6BvHrx/cyd0RKNryLdjO2h4AILAO" +
           "aPDLL+998+2rp6/4HRemkIkhEmQpzWWZ/zH8+eD5L3sYeLAOASL1PRaSLctA" +
           "mc5W7nD2BqCmQOwz52jfroIbynEZRxXC4ufftctXP/PB4TphbgV6bG9ZNT0D" +
           "p/8T3ejRS7v+0czZ+CSWVB39OWQCqec5nDcYBp5g+0jvf23JN1/CpwDzAWdN" +
           "eZJw6ERcH4gbcA3XxV28vdszdg9rlptuH88OI1fxE5GOXPmwZseHz9/gu82u" +
           "ntx2H8B6l/AiYQUbuVu8UM5GG3XWLkjDHhZ4gWoTNhPA7O6Lg1+oUy7ehGXD" +
           "sKwEuGtuMQAq01muZFGXlv/hhRcbd18uQf4+VKVoONaHecChSvB0YiYAZdP6" +
           "5+4T+xivgKaO6wPlaCing1lhaX779iZ1yi0y+eMFP1x7duoqd0td8FjE5/sZ" +
           "8GchLC/UnSA/9/o9b5z9+olxkeo7CyObZ17Tv7Yo0QN//meOXTim5SlDPPPD" +
           "wfNPLOxZ/z6f74ALm92ezk1WANDO3E+eS/7d31r2Cz8qD6M6ySqMd2AlxeI6" +
           "DMWgaVfLUDxnjWcXdqKK6cqA52IvsLmW9cKakyThnVGz9xqPDzYxE3bC02r5" +
           "YKvXB32Iv2zmUzp428maVTa6lOuGDIcnks4w5a6zoAhTCpsD+/EJTTNL4AJ9" +
           "WfsZ1jwgVl1b0HU35oraZu2qrYCo24WorBnIlanQbJBJN8gYe/+8Z5M7imwy" +
           "nV+vfvZ6J0C3yY81jm7ZVNRQBDRcsYUYgCwpVKLz48XpA8emYlvOrBbRVZ9d" +
           "9vbCqe7J3/7n14GTf3olT91VZh2xnAXL2HpZwTzAjy5OZLw15+hfnm0f6Z5J" +
           "pcT6mqephdj/S0GCFYXxwbuVlw68t3Db+sTuGRQ9Sz269LL8zsD5V+7vkI76" +
           "+TlNhGzO+S57Uld2oFYZBA6k6rascG3LWL/V9uHllvWXe33Ycb2CPlUal1Ws" +
           "eMJ1cRGmRXLl3iJjvHMPAMQIoYNgDh4aTlSMThe6xbMO6+jWeX88Vz8dligd" +
           "M9YPa9Q8yinEsYgCHikytp81E0I5QzZuOMqZvA3KWcbGPgvPHZYod8xEORRV" +
           "6oZGIR2RWD4dLS3C2KMHn0gdXGS+5uEiijrCmoOgKFN4kVm0CBgy5CQU1mPW" +
           "XUJwX/3bo09ce1LAmzfje4jJoWNf/Thw+JiAOnE705ZzQeKeI25o+DbrWBNg" +
           "gNtSbBU+o++dC/t++u19B/2WiFHIHWOaHHPMf+h2mr/TslLnTGPja4XsXojj" +
           "dHb/VhG7n2HNKWF3O0COOxqaul0auhOegCVP4JZpqBDHIgr4XpGxH7Dmu5CC" +
           "U6oC9ZFHN+dvl2664FlnSbLulummEMfpvOfnRRT0AmuepahaVk1i0G4CZ3zi" +
           "UdNPboWa0hC7rC61a9mO/6+WBZxoyrnhFrey0lNTtRULprb/jtdImZvTaqh2" +
           "4ilFcVf1rvcyKD7jMpe9WtT4Ov+5RFFD3i3BvtkP3/evBO2rFNV5aaFc4L9u" +
           "ussUVTl04IXixU1yhaISIGGvb+i2bur4KZEdbALiYJP2ZVerGdM0TGcaV4Hb" +
           "lpUN+NcFuzxLie8LEenC1ObBh298+oy4lpEUPDnJuMwOoXJx+ZMp8VoKcrN5" +
           "lW3qvDnn6crlNnpnXQu598YdBDyWX6Es9NxTmO2Z64o3T699/jeHyl6DvLMT" +
           "+TBF83bmHgHTegpq650hp7p2fZ3iFyhdnY9PrF8V/+sf+SEbicvLxYXpI9KV" +
           "sw+9frTpdLMfze5HpZCYSJqfTTdOqFuJNGaEUY1s9qZhi8BFxko/qkip8t4U" +
           "6Y+F0BzmmJh9d+B6sdRZk+ll93UUtebmz9xbzipFGydGt5ZSeWVRA+W405P1" +
           "2cNy9qqUrnsmOD0ZU87PlT0ibfxK7c+O1Jf0QXBlieNmX26mopkK3P0lhHe4" +
           "0z2zM3h6JDSg6/Y1mv9xXXj8O4KG9VPkW2H1eqDsPc7uXf7Kmg/+B4C4sqTk" +
           "HAAA");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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");
    }
    private org.apache.batik.util.DoublyLinkedList.Node
      head =
      null;
    private int size = 0;
    public DoublyLinkedList() { super(); }
    public synchronized int getSize() { return size;
    }
    public synchronized void empty() { while (size >
                                                0)
                                           pop(
                                             ); }
    public org.apache.batik.util.DoublyLinkedList.Node getHead() {
        return head;
    }
    public org.apache.batik.util.DoublyLinkedList.Node getTail() {
        return head.
          getPrev(
            );
    }
    public void touch(org.apache.batik.util.DoublyLinkedList.Node nde) {
        if (nde ==
              null)
            return;
        nde.
          insertBefore(
            head);
        head =
          nde;
    }
    public void add(int index, org.apache.batik.util.DoublyLinkedList.Node nde) {
        if (nde ==
              null)
            return;
        if (index ==
              0) {
            nde.
              insertBefore(
                head);
            head =
              nde;
        }
        else
            if (index ==
                  size) {
                nde.
                  insertBefore(
                    head);
            }
            else {
                org.apache.batik.util.DoublyLinkedList.Node after =
                  head;
                while (index !=
                         0) {
                    after =
                      after.
                        getNext(
                          );
                    index--;
                }
                nde.
                  insertBefore(
                    after);
            }
        size++;
    }
    public void add(org.apache.batik.util.DoublyLinkedList.Node nde) {
        if (nde ==
              null)
            return;
        nde.
          insertBefore(
            head);
        head =
          nde;
        size++;
    }
    public void remove(org.apache.batik.util.DoublyLinkedList.Node nde) {
        if (nde ==
              null)
            return;
        if (nde ==
              head) {
            if (head.
                  getNext(
                    ) ==
                  head)
                head =
                  null;
            else
                head =
                  head.
                    getNext(
                      );
        }
        nde.
          unlink(
            );
        size--;
    }
    public org.apache.batik.util.DoublyLinkedList.Node pop() {
        if (head ==
              null)
            return null;
        org.apache.batik.util.DoublyLinkedList.Node nde =
          head;
        remove(
          nde);
        return nde;
    }
    public org.apache.batik.util.DoublyLinkedList.Node unpush() {
        if (head ==
              null)
            return null;
        org.apache.batik.util.DoublyLinkedList.Node nde =
          getTail(
            );
        remove(
          nde);
        return nde;
    }
    public void push(org.apache.batik.util.DoublyLinkedList.Node nde) {
        nde.
          insertBefore(
            head);
        if (head ==
              null)
            head =
              nde;
        size++;
    }
    public void unpop(org.apache.batik.util.DoublyLinkedList.Node nde) {
        nde.
          insertBefore(
            head);
        head =
          nde;
        size++;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mRkvbGSEDQtLxNgYufK/b63KUz0jAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
