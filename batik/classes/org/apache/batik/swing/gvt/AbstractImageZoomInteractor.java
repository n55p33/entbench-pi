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
      1471109864000L;
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
       "uE6wO828wlYDsDoQ7lVV+1avYoPKN/6u3AeS9/gja67/F05qvDGNHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Db79kxd+4jV/+OQ3ikP4/wVMa6mk8CcAAA==");
}
