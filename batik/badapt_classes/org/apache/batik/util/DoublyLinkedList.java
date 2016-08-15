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
          1471028785000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "HAAA");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "wN2z3velV8ZikJod9MU+6P7HzkOn/mwHOq1C5/TdvE/RnCRzIhXkOtFeMghy" +
           "wyPtR/OW7SJ9aT+cvfJ4qDk07PFAc7AGgPeMOns/cyy23J3N8gXwPLQbWx46" +
           "HltOQPnL6/MuD+bl+az40T1XPh2E9hL4Zc75QgzGBarJI9I2LGUlnhW1rTJL" +
           "11T8pSvFenhXrIevIVbjGmJlr/S+REFoLq8mUfMFJco5pCcAzJPYxfLFQvZb" +
           "vPqYN2SvrwKhLcoTbdDDsj3N2RPirpmjn98LZgpIvIEtnp855ZzNHWCrkbtR" +
           "pvWL22z1mKwXvmdZgZvcesCM90Hi+85/evLzv/zwV4Etc9DJZWZnwIQPjSgk" +
           "2V7gF599+t6XPPW1d+aRGkyi8pZH/j3PrNTrIc4KOSt6e1DvyaDKea7Da1Hc" +
           "zgOqaeRor+vCUmi7YA1a7ia6yGO3f3X+3q9/aJvEHvfXY8Tm2596x3cvPvHU" +
           "zqGtw8NXZO+H+2y3D7nQL92d4RB68Hqj5D3q//yRx/7wtx9721aq248mwgzY" +
           "533oS//7+Yvv/tpnr5KJ3ej434di41tf3ihGzdreh1dUE1v109S1RLjtCbMR" +
           "yxJmY9WBI7Y9NTRG6qEMRc+6aHsTjesTTp4V1dnYRdoxHseGkVhRhIrapN4l" +
           "ByunS/ndwcqq9LtMzMlkteuWVc7Wmpg8mNtzlcK0riLHQ5iR6hS9WKiKpsZw" +
           "uyyUk7KF6xRGBio63uCbzWa4XuKIJZQlL1wInUKfFrraiBRL7U672goKFBm5" +
           "ttX3MVrGO0qVMRcrBsHwYazXywiIXzNxNI/o+WSkSoV1X+bcAVvo1lXBdgac" +
           "2xSZVLDbzZE4SskZrQjjfptddDZWaQ5cSu7VzALLMoxYrnU7XjsNRiO9pzTk" +
           "8YadaMy8aUz5ubhykkqNwKcKhQbivEd7bs8ubxqC3vTnFULj5grq99AiXTN6" +
           "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");
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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mRkvbGSEDQtLxNgYueK/jP3/sj0jAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MFaeV3vZaoqpvZLfG1BtJ2Divi077TJVr6zWMmX1hZ5rUaOlRCxEd2vWxk5b" +
       "72ytuZP1OVWwtuKO3yXuEjKp4yY/WrdnOOVPlyUKd+FeE1urzJpZruBVquIS" +
       "y2miulhO1aXOl5GKXKtHGreWMSzS4DRYDfoKMhpWYE7l0CDjI8viSQOrbmtr" +
       "V16zo4wR1hXUK0+ldrVUG7gmKgwQrMKLHsat00FJk/SOo0xritofNZvCuEMN" +
       "XYyQarElShM8pMkKq6kVZzlAUE+eYtmoxQ7dca+3mIIQM4s52ggbWW0V1eE4" +
       "87ZdeL1q+n0+DZHq0iyVYY2abdTBNNS6847XWkUzKkh1sM+ra2R9wVmewiVL" +
       "tD5tDTVb4staq5+sJwmS9dSYLhEhvh6WZUmTMFjzFT/dJBrqN9lYK0U22MuM" +
       "pp3IYiiPnXWViEYzLvNsZlpSwpm3lEN5xC9JuK5s0WZLjRZ+i2yBVafBGGBv" +
       "aHOqqll4vamgwRI1InSp96zRrLomPG6GduW4R7QEa6ZtvKku1rCyn0hij9hM" +
       "vYE+H6ABZvONLqv1pFhuk7rEpGUq1BxTF5Y9r8ppYGe6rmVTz6ikDl6ei1S5" +
       "vzZale2o2ncwstbX7dWwF8iSzC7QCcwQmiG5WKtt8IhtSyXRaDVSfVayp+tE" +
       "6rKd9iSi09GKj9UBbI6rcGiWTbAT/758i+6/saODh4tTktPbUhOEFqBCfAOn" +
       "A7uqZ/PsPaenacXvInRww3b2vH5/iAvlR1FP3ukStDiG+uzHXnpVYT5XOTo+" +
       "/J5H0AOR6/1FS01U60xXD4KePnDnI7dhcQe8P5T98sf+yxOz79c/8gaump4+" +
       "4POwy789/MJXuu+V/8YRdP70iPaW2+mbG71w88Hs5UCN4sCZ3XQ8++SpZAtB" +
       "Pg/Sh44l+6HDc8r93N2iBUfHR2YPhltH1gPXMTJV2anCXa4aPnGXuh/Ls49F" +
       "0KWVGrGgt/yV3SvOj7zesdLZ/oqCHzpF+nheeA0k8Rip+IaR5tmPvi6+l+5S" +
       "9+k8+4kIuqDaXrS97Wla4hrKHvGn7gFxQfYYSMYxYuMNIC4OoN/3umA/c5e6" +
       "z+XZq7vJ7Kmikr9299B+5s2A5hxDc958aF+8S90v5dnnd9BmomEdQPs79wCt" +
       "uIB9GsqvM3a/6M2Bdm5P0C0Ifu0u+L6UZ38f6GnkxnJxhvzKHt2v3iu694GU" +
       "HaPL3hx0R3szZfcQv3wXiF/Js38cQedFRTkA+Bv3CjC/73r5GODLb9H0/Yu7" +
       "YPtanv32bbH9s3vF9gxInznG9pm3CNvX74Lt3+fZ70XQxUC13UQ9gPdv79Wp" +
       "vAOkXz6G98tvDryz3H/jLnXfzLP/BGbNc70Dh/KH9wrrUZB+/RjWr7/5sP70" +
       "LnX/O8/+O5iw2PHiUD9A9j/uVR+fAumrx8i++tbo47nzd4Z37kJe+Gdg4T4B" +
       "d0Ybv/NmrANfOwb3tbcI3JW7gHs4zy6DdQDM3U4p9+jOve2NoEsj6OrhHXv+" +
       "Lcvjt3xUuvsQUv6FV6/c/9ir839VfAF1+rHiAzR0vxZb1tlPD848X/QCVTMK" +
       "3A/sPkTwChyPR9A7b3vvD+Yt/8vZPffYjvZdgNNDWiCB4v8s3VMRdHlPB/R7" +
       "93CW5FlgzIAkf3zOK0Ry803x7uuL9FxR9fhZPSjU55HXE/CZHc/zN+1Tig96" +
       "T/YU8e6T3hvyF1/tj37wW43P7T7Oki0xy/Je7qehS7vvxIpO833Js3fs7aSv" +
       "i733f/uhX3zgPSd7qId2DO918gxvT9/+S6hOHgPnepD9g8f+3vf+7Ku/X1xc" +
       "/39clPbCaS0AAA==");
}
