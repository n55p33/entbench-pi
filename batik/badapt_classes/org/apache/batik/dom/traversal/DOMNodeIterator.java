package org.apache.batik.dom.traversal;
public class DOMNodeIterator implements org.w3c.dom.traversal.NodeIterator {
    protected static final short INITIAL = 0;
    protected static final short INVALID = 1;
    protected static final short FORWARD = 2;
    protected static final short BACKWARD = 3;
    protected org.apache.batik.dom.AbstractDocument document;
    protected org.w3c.dom.Node root;
    protected int whatToShow;
    protected org.w3c.dom.traversal.NodeFilter filter;
    protected boolean expandEntityReferences;
    protected short state;
    protected org.w3c.dom.Node referenceNode;
    public DOMNodeIterator(org.apache.batik.dom.AbstractDocument doc, org.w3c.dom.Node n,
                           int what,
                           org.w3c.dom.traversal.NodeFilter nf,
                           boolean exp) { super();
                                          document = doc;
                                          root = n;
                                          whatToShow = what;
                                          filter = nf;
                                          expandEntityReferences =
                                            exp;
                                          referenceNode = root; }
    public org.w3c.dom.Node getRoot() { return root; }
    public int getWhatToShow() { return whatToShow; }
    public org.w3c.dom.traversal.NodeFilter getFilter() { return filter;
    }
    public boolean getExpandEntityReferences() { return expandEntityReferences;
    }
    public org.w3c.dom.Node nextNode() { switch (state) { case INVALID:
                                                              throw document.
                                                                createDOMException(
                                                                  org.w3c.dom.DOMException.
                                                                    INVALID_STATE_ERR,
                                                                  "detached.iterator",
                                                                  null);
                                                          case BACKWARD:
                                                          case INITIAL:
                                                              state =
                                                                FORWARD;
                                                              return referenceNode;
                                                          case FORWARD:
                                         }
                                         for (;
                                              ;
                                              ) {
                                             unfilteredNextNode(
                                               );
                                             if (referenceNode ==
                                                   null) {
                                                 return null;
                                             }
                                             if ((whatToShow &
                                                    1 <<
                                                    referenceNode.
                                                    getNodeType(
                                                      ) -
                                                    1) !=
                                                   0) {
                                                 if (filter ==
                                                       null ||
                                                       filter.
                                                       acceptNode(
                                                         referenceNode) ==
                                                       org.w3c.dom.traversal.NodeFilter.
                                                         FILTER_ACCEPT) {
                                                     return referenceNode;
                                                 }
                                             }
                                         }
    }
    public org.w3c.dom.Node previousNode() {
        switch (state) {
            case INVALID:
                throw document.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      INVALID_STATE_ERR,
                    "detached.iterator",
                    null);
            case FORWARD:
            case INITIAL:
                state =
                  BACKWARD;
                return referenceNode;
            case BACKWARD:
        }
        for (;
             ;
             ) {
            unfilteredPreviousNode(
              );
            if (referenceNode ==
                  null) {
                return referenceNode;
            }
            if ((whatToShow &
                   1 <<
                   referenceNode.
                   getNodeType(
                     ) -
                   1) !=
                  0) {
                if (filter ==
                      null ||
                      filter.
                      acceptNode(
                        referenceNode) ==
                      org.w3c.dom.traversal.NodeFilter.
                        FILTER_ACCEPT) {
                    return referenceNode;
                }
            }
        }
    }
    public void detach() { state = INVALID;
                           document.detachNodeIterator(
                                      this);
    }
    public void nodeToBeRemoved(org.w3c.dom.Node removedNode) {
        if (state ==
              INVALID) {
            return;
        }
        org.w3c.dom.Node node;
        for (node =
               referenceNode;
             node !=
               null &&
               node !=
               root;
             node =
               node.
                 getParentNode(
                   )) {
            if (node ==
                  removedNode) {
                break;
            }
        }
        if (node ==
              null ||
              node ==
              root) {
            return;
        }
        if (state ==
              BACKWARD) {
            if (node.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ENTITY_REFERENCE_NODE ||
                  expandEntityReferences) {
                org.w3c.dom.Node n =
                  node.
                  getFirstChild(
                    );
                if (n !=
                      null) {
                    referenceNode =
                      n;
                    return;
                }
            }
            org.w3c.dom.Node n =
              node.
              getNextSibling(
                );
            if (n !=
                  null) {
                referenceNode =
                  n;
                return;
            }
            n =
              node;
            while ((n =
                      n.
                        getParentNode(
                          )) !=
                     null &&
                     n !=
                     root) {
                org.w3c.dom.Node t =
                  n.
                  getNextSibling(
                    );
                if (t !=
                      null) {
                    referenceNode =
                      t;
                    return;
                }
            }
            referenceNode =
              null;
        }
        else {
            org.w3c.dom.Node n =
              node.
              getPreviousSibling(
                );
            if (n ==
                  null) {
                referenceNode =
                  node.
                    getParentNode(
                      );
                return;
            }
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ENTITY_REFERENCE_NODE ||
                  expandEntityReferences) {
                org.w3c.dom.Node t;
                while ((t =
                          n.
                            getLastChild(
                              )) !=
                         null) {
                    n =
                      t;
                }
            }
            referenceNode =
              n;
        }
    }
    protected void unfilteredNextNode() {
        if (referenceNode ==
              null) {
            return;
        }
        if (referenceNode.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ENTITY_REFERENCE_NODE ||
              expandEntityReferences) {
            org.w3c.dom.Node n =
              referenceNode.
              getFirstChild(
                );
            if (n !=
                  null) {
                referenceNode =
                  n;
                return;
            }
        }
        org.w3c.dom.Node n =
          referenceNode.
          getNextSibling(
            );
        if (n !=
              null) {
            referenceNode =
              n;
            return;
        }
        n =
          referenceNode;
        while ((n =
                  n.
                    getParentNode(
                      )) !=
                 null &&
                 n !=
                 root) {
            org.w3c.dom.Node t =
              n.
              getNextSibling(
                );
            if (t !=
                  null) {
                referenceNode =
                  t;
                return;
            }
        }
        referenceNode =
          null;
    }
    protected void unfilteredPreviousNode() {
        if (referenceNode ==
              null) {
            return;
        }
        if (referenceNode ==
              root) {
            referenceNode =
              null;
            return;
        }
        org.w3c.dom.Node n =
          referenceNode.
          getPreviousSibling(
            );
        if (n ==
              null) {
            referenceNode =
              referenceNode.
                getParentNode(
                  );
            return;
        }
        if (n.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ENTITY_REFERENCE_NODE ||
              expandEntityReferences) {
            org.w3c.dom.Node t;
            while ((t =
                      n.
                        getLastChild(
                          )) !=
                     null) {
                n =
                  t;
            }
        }
        referenceNode =
          n;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zM0tqmpIViH8ep8MaYdaCSGOc72aW5mOSY1vK3FDlyl71UG5wJT0wbZOT1GX" +
       "HbU7NkHqXiu0NG+pyMmoh9ZxlGpYfrdpOz1+ttT1hR5y/qoPZl/EgBeBmlwz" +
       "gFIuwbGO0G8STVDcMcONSw2F0NTllZZKYC2L5T4fkcaSatFKNxNdvwJDaZK1" +
       "trS1qasBVVZUOPG2WWWd6WVn0U3s1sCa01nAzlM4bJSZGZ6O+AY83ZKQbLWh" +
       "rM81+53JsiOQDRMisH4mpvRWW6kOwaAr31AX5HA2VdPpyvR0egVXm/Uexgqs" +
       "uakzoxGBjakOCR7bg407dRLwdJe1WuyiHFVrMhqFmK+R9WnWdeeaI0zckQbN" +
       "Rhl4Eo9szJ/x5YXmD/Q+XuerHbbRUJVWpzHfZtQmHOOZPVDJydyBpjOdGMQq" +
       "KTYzUVus4dayXU+d0ZSIJWocuY6RycMahg6gkYRMpMQT+WqMNaZLUQ5dzQsm" +
       "nUW5LMbdBtfucTOkhY0tJmPXmt7GdMgmx+KsOWrYZXs86w9k2JZtuAPrbG2d" +
       "spWK07XJbnmiufTSNNvcvB+ZadlrNSbpuut3fWy77lr+zC63W6g5HzpufW2U" +
       "uZ638jKGpZlBuLK6LsyO2PGAmbUHHX6OlWdDJ94mupkg2yUOgl6vXSkveW4W" +
       "LKBJIkAMpblauynFNa29FRR1RlM8lA1UowOwWnGnx/iBIS0GnW511mC3ncwQ" +
       "3KbXnlVVasKpZZYoL8htpR4luL4hoHGUapy1QhDkIx/JX+v889t73XR/8frs" +
       "+PTW0i5eFX/zNt4o7YqeypNnj181Fp+LpVMnfk68ajyx+Xju6FXd07fe6D06" +
       "95LvpD52q/Nbxa7za5955VV1+FXo/OH+7rWodHfk+T9la4lmn+j1Mmjp+Vtv" +
       "eTLF8bX9vuPvfObPH51+1PzkbZyGeeIUztNN/jLztd/r/aTy986X7jjehbzh" +
       "YN31la5dv/d4OdCiOHCn1+1APnY8CcUEPQyu8HASwtPve/fTfPOXvR/cqckZ" +
       "2+d/dEbZH+fJH0SlS4YWTY52SPZK9Z03");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("e015sr0i498eU7uSZ74PXNkhteydp/afzij7L3ny3ah0L6A2u36rZU/we2+D" +
       "4EN55hPgeumQ4EvvPMG/OKPsjTz5c7B2AEFiv2ezJ/f9t0HuwTwz3wB++ZDc" +
       "y+88uR+fUfZXefLDqPQTgBx+682fPdkfvQ2yhVi+1fj5Q7Kff8fJnrt0Rtnd" +
       "eXI+Kt3lAiN3vFVzzO3cHW+XW74Mv37I7evvPLcHzyh7T57cF5Xu8QMtsbw4" +
       "vAm/K2+D37uO5u5bh/y+9c7ze+KMstyrnns0Kl1UtUhSzJtuACWepe7Zvvft" +
       "ss3PO3znkO133hm25/YCtYLWwRmU8z3Ac89FpSsumMqph2oTzfESTc2z37/n" +
       "+fzb4Fnsg34AIHp0V3f3fTs8F286qz99RtmH86QRlR6I3d12uKay+7V5kmXz" +
       "7bIsA8AfO2T5sXeeJXFGWT9PkKj00J7l6PpVepIpejtMU6Aepw5E56c7H7nh" +
       "7xe7vwwov/bqlbsefpX/o+JM8PGx/rvp0l16bNsnD3OduL8IbIpuFUNw9+5o" +
       "l1/wGkalx88+rJ1HnEf3OfZz7K7mJCq9+2Y1o9IdID0pyR8eIT0pGZUuFN8n" +
       "5eZR6fJeDtiJ3c1JkU+A1oFIfvsz/lGkfWJTfHcOLj13IjQ+VKXC8z3wZvNy" +
       "XOXkMeM8nC7+MnMU+sa7P828oHzjVZL91BvNr+6OOSu2lGV5K3fRpUu7E9fH" +
       "4fNTt2ztqK2L/ed+fN837372KNS/bwd4r9YnsD1x8zPFuONHxSng7J88/Bsf" +
       "/kevfrc4Tfd/AZrYgSfLNAAA");
}
