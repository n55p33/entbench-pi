package org.apache.batik.anim.timing;
public abstract class TimeContainer extends org.apache.batik.anim.timing.TimedElement {
    protected java.util.List children = new java.util.LinkedList();
    public void addChild(org.apache.batik.anim.timing.TimedElement e) { if (e ==
                                                                              this) {
                                                                            throw new java.lang.IllegalArgumentException(
                                                                              "recursive datastructure not allowed here!");
                                                                        }
                                                                        children.
                                                                          add(
                                                                            e);
                                                                        e.
                                                                          parent =
                                                                          this;
                                                                        setRoot(
                                                                          e,
                                                                          root);
                                                                        root.
                                                                          fireElementAdded(
                                                                            e);
                                                                        root.
                                                                          currentIntervalWillUpdate(
                                                                            );
    }
    protected void setRoot(org.apache.batik.anim.timing.TimedElement e,
                           org.apache.batik.anim.timing.TimedDocumentRoot root) {
        e.
          root =
          root;
        if (e instanceof org.apache.batik.anim.timing.TimeContainer) {
            org.apache.batik.anim.timing.TimeContainer c =
              (org.apache.batik.anim.timing.TimeContainer)
                e;
            java.util.Iterator it =
              c.
                children.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                org.apache.batik.anim.timing.TimedElement te =
                  (org.apache.batik.anim.timing.TimedElement)
                    it.
                    next(
                      );
                setRoot(
                  te,
                  root);
            }
        }
    }
    public void removeChild(org.apache.batik.anim.timing.TimedElement e) {
        children.
          remove(
            e);
        e.
          parent =
          null;
        setRoot(
          e,
          null);
        root.
          fireElementRemoved(
            e);
        root.
          currentIntervalWillUpdate(
            );
    }
    public org.apache.batik.anim.timing.TimedElement[] getChildren() {
        return (org.apache.batik.anim.timing.TimedElement[])
                 children.
                 toArray(
                   new org.apache.batik.anim.timing.TimedElement[0]);
    }
    protected float sampleAt(float parentSimpleTime,
                             boolean hyperlinking) {
        super.
          sampleAt(
            parentSimpleTime,
            hyperlinking);
        return sampleChildren(
                 parentSimpleTime,
                 hyperlinking);
    }
    protected float sampleChildren(float parentSimpleTime,
                                   boolean hyperlinking) {
        float mint =
          java.lang.Float.
            POSITIVE_INFINITY;
        java.util.Iterator i =
          children.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimedElement e =
              (org.apache.batik.anim.timing.TimedElement)
                i.
                next(
                  );
            float t =
              e.
              sampleAt(
                parentSimpleTime,
                hyperlinking);
            if (t <
                  mint) {
                mint =
                  t;
            }
        }
        return mint;
    }
    protected void reset(boolean clearCurrentBegin) {
        super.
          reset(
            clearCurrentBegin);
        java.util.Iterator i =
          children.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimedElement e =
              (org.apache.batik.anim.timing.TimedElement)
                i.
                next(
                  );
            e.
              reset(
                clearCurrentBegin);
        }
    }
    protected boolean isConstantAnimation() {
        return false;
    }
    public abstract float getDefaultBegin(org.apache.batik.anim.timing.TimedElement child);
    public TimeContainer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaCXAcxRXtXcmy7pVlSzbGko0sQ2SbXc5gR+aQ5EtmZSuS" +
       "UVXkQ56d7ZXGmp0ZZnqltYi4kpQdkrgcxxwhoFQqBhtibIoKlRACcQIBXBBS" +
       "3AHCEaAChFDYRSCpACH/98zsHHsIVyFVTWvU3b+P/99//3ePDr1Pphk6aaQK" +
       "C7MdGjXCqxTWLegGjXfIgmFshLoB8cYi4cOt76xfHiQl/aR6SDC6RMGgqyUq" +
       "x41+0iApBhMUkRrrKY2jRLdODaqPCExSlX5SJxmdSU2WRIl1qXGKHfoEPUpm" +
       "CIzpUizFaKc1ACMNUVhJhK8k0uZvbo2SSlHVdjjd57i6d7hasGfSmctgpCa6" +
       "XRgRIikmyZGoZLDWtE6WaKq8Y1BWWZimWXi7fL6lgnXR87NU0HR36ONP9gzV" +
       "cBXMFBRFZXx7Rg81VHmExqMk5NSukmnSuJxcSYqipMLVmZHmqD1pBCaNwKT2" +
       "bp1esPoqqqSSHSrfDrNHKtFEXBAjp3kH0QRdSFrDdPM1wwilzNo7F4bdLsjs" +
       "1txl1havXxLZd+PWmnuKSKifhCSlF5cjwiIYTNIPCqXJGNWNtnicxvvJDAWM" +
       "3Ut1SZClMcvStYY0qAgsBea31YKVKY3qfE5HV2BH2JueEpmqZ7aX4ICy/pqW" +
       "kIVB2Gu9s1dzh6uxHjZYLsHC9IQAuLNEioclJc7IfL9EZo/Nl0IHEJ2epGxI" +
       "zUxVrAhQQWpNiMiCMhjpBegpg9B1mgoA1BmZm3dQ1LUmiMPCIB1ARPr6dZtN" +
       "0KuMKwJFGKnzd+MjgZXm+qzkss/761fsvkJZqwRJANYcp6KM668AoUafUA9N" +
       "UJ2CH5iClYujNwj1D+wKEgKd63ydzT6/+uaJS5Y2Hn3M7HNqjj4bYtupyAbE" +
       "/bHqp+Z1tCwvwmWUaqohofE9O+de1m21tKY1YJj6zIjYGLYbj/Y88o2r76Tv" +
       "BUl5JykRVTmVBBzNENWkJslUX0MVqguMxjtJGVXiHby9k0yH96ikULN2QyJh" +
       "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" +
       "vi35P0Ga9jYOJAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mYrpP60aXYAS6JFbNgKBVvlzmvaOBLp6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nhb4QfV7mu7uBLr3hA4Me8icJrmcQHcAkjJ7b3iYrQtnA/0b6n/49dR/6tvg" +
       "mTPLZ3Vb+Dj6ThdHtym+8PKE/sB3Oz93uO2luFJRlL1cAivd4eLZ0Up3/mbG" +
       "6d6O+7qbfO77D37x8rPHXxsPHhg+MeBTvD116+tUQy9MqgtQxb947Bd/+J+8" +
       "/LXqGsD/A+HH4NPGLQAA");
}
