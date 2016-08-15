package org.apache.batik.swing.gvt;
public class AbstractImageZoomInteractor extends org.apache.batik.swing.gvt.InteractorAdapter {
    protected boolean finished = true;
    protected int xStart;
    protected int yStart;
    protected int xCurrent;
    protected int yCurrent;
    public boolean endInteraction() { return finished; }
    public void mousePressed(java.awt.event.MouseEvent e) { if (!finished) {
                                                                org.apache.batik.swing.gvt.JGVTComponent c =
                                                                  (org.apache.batik.swing.gvt.JGVTComponent)
                                                                    e.
                                                                    getSource(
                                                                      );
                                                                c.
                                                                  setPaintingTransform(
                                                                    null);
                                                                return;
                                                            }
                                                            finished =
                                                              false;
                                                            xStart =
                                                              e.
                                                                getX(
                                                                  );
                                                            yStart =
                                                              e.
                                                                getY(
                                                                  );
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        java.awt.geom.AffineTransform pt =
          c.
          getPaintingTransform(
            );
        if (pt !=
              null) {
            java.awt.geom.AffineTransform rt =
              (java.awt.geom.AffineTransform)
                c.
                getRenderingTransform(
                  ).
                clone(
                  );
            rt.
              preConcatenate(
                pt);
            c.
              setRenderingTransform(
                rt);
        }
    }
    public void mouseDragged(java.awt.event.MouseEvent e) {
        java.awt.geom.AffineTransform at;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        xCurrent =
          e.
            getX(
              );
        yCurrent =
          e.
            getY(
              );
        at =
          java.awt.geom.AffineTransform.
            getTranslateInstance(
              xStart,
              yStart);
        int dy =
          yCurrent -
          yStart;
        double s;
        if (dy <
              0) {
            dy -=
              10;
            s =
              dy >
                -15
                ? 1.0
                : -15.0 /
                dy;
        }
        else {
            dy +=
              10;
            s =
              dy <
                15
                ? 1.0
                : dy /
                15.0;
        }
        at.
          scale(
            s,
            s);
        at.
          translate(
            -xStart,
            -yStart);
        c.
          setPaintingTransform(
            at);
    }
    public AbstractImageZoomInteractor() { super(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KzL6g1nfW3P6xFUOS9UcYy7XZ6X/PA/D8pre2eRnLt3zy9NfPTJsVgWtuZnN" +
       "pzf7n5ul6L7f/SNrXTinTVKx+PQjobPHGjvWXuf6Drkw7ZZ0dt4CgnZ07zyT" +
       "+lugueQnAVQaQbWCVUNvw5LB9nUE6kbdLqyhzva899aAZsHTliHPeX5ic03r" +
       "pzUnX8Izk2bPVT4MVrMlXGp97GcPBgsQf9jIVZbytpU1K2x2maZqCgUrSSyd" +
       "GZYjoyrPsBSVxUVZ1JMk5k2xLI31G5DA+zQxBRQ5ZBWQd/btFg609P3BhMGc" +
       "SRRMufqnQ1/edmXPa5yAy1jC3Wq77kqnkJhdxF7LmiDbbXng5bMnNFb37uCx" +
       "a8+Y9vix5BMmB8a/+GHw4LhJjOYRYXFWle7WMY8JPusW5ZuFa3T98fzYc0+P" +
       "7TetqvMWvJ1wnnvmrX+/Fjz624uTVFSlUUWRCJYzG7wgUwLN9IbbdGrDF2qe" +
       "P1RX2AXZtweVGbK41yA9MS/uSnUj6oq/c/xwsGi5x5IQRQXLgB3MBMvaT7Lm" +
       "QRNWa3Ky0wYvmufAZ7kFu+U50Bw10cya3mzQ5tKGTJqGek4zT8OfttaFfW11" +
       "PW+nqFC0TsyuMLKfu/y+CR/Bt5WWdStz+Cbn9S2XNvg2wn1jvxI+M5UpmjkX" +
       "PqutiVbnMNPIa2YubeCNdIehQS03qaFDH8HQ+6yp7sth6KN5Dc2lDYaO5DF0" +
       "LI+h6RxUyx7vcDiW/5Wg3OWDK8siRh/zc53rOXWc3Dd+Irb51KqAVQU9DMxO" +
       "FfUOiQwRyTVUERvJk7B7+U2Gk/3eqT78+x+2JNZP5TTE+ppuc95hvxcArS3L" +
       "TdJ+U17e917j1rXJ3VM42CzwRck/5Ld7z158YKlwOMCvbcy0nHXd41Vq85Ji" +
       "uUaoocleGlycWdcZ9lqus9Z1nR+YDpY4Kp/worI8j2qeqnc8z7sjrPkKRdVE" +
       "jtlnaevw0u9g+tDtNl/+MpJ1rFd5/5cyHlWwd8vg02151D31YORS9Tlspzv2" +
       "ezZFc3hJi4cBZUMM7r2KoZNO9sin/GaecJ1izTHK0Aw67CZaJ7HJ8kTRkCLG" +
       "nAAe/7gCyBLZdisK26cewFyqkweQ/fwWH/W7eWJ0gTXnKKriMdpCoPKAILHO" +
       "005Azn+ciJItr+SpBySX6u0CMpEnID9mzXM2aDZoOJHIisfz/4t4pCmam+eG" +
       "jB3nZmfd05t3y8K5EzVls048dIVTe+b+txJIOm5IkvvA4XouUTUSF7mTlebx" +
       "w6zxfkZRY+5bPKiioOVOXDTlX6eoYXJ5CsdI9u2W/gVFtX5pkOPfbrlLFJU7" +
       "clAGmQ9ukbfAFhBhj1dUmx9W5LmAdKLZHsMqPKcLvMk4s6L1t1tRV/5e7Ml7" +
       "/D8udo4yzP+5DAjnT2zc9MjNu0+Z90+ChEdH2SgVUIqbt1yZPLco52j2WCXd" +
       "rbeqn522xK4IPPdfbts4rgDo/K6o0Xcho7dk7mXePrnmxdcPlLwJh48dqABT" +
       "NGNH9lk3rRpQYOwIZx85oCbgN0Vtrd8YWbsi/pff8NsEZB5R5uWWHxAun955" +
       "6fDsk00BVNGDiqHYIWl+CN8wIm8hwpAWQVWi3pkGE2EUEUue80w1gzlm/4vh" +
       "cbHCWZXpZReTFDVnH+eyr3PLJWWYaOsVQ+Y7G05EFU6P519B1tYpN1TVp+D0" +
       "uE6wO828wlYDsDoQ7lVV+1avIq7yjb8r94HkPf7Imuv/BQt6eN6NHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Gnz3Wy/+jTf+ytNfKg/h/xcMJUzz8CcAAA==");
}
