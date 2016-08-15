package org.apache.batik.parser;
public class AWTPathProducer implements org.apache.batik.parser.PathHandler, org.apache.batik.parser.ShapeProducer {
    protected org.apache.batik.ext.awt.geom.ExtendedGeneralPath path;
    protected float currentX;
    protected float currentY;
    protected float xCenter;
    protected float yCenter;
    protected int windingRule;
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PathParser p =
                                                   new org.apache.batik.parser.PathParser(
                                                   );
                                                 org.apache.batik.parser.AWTPathProducer ph =
                                                   new org.apache.batik.parser.AWTPathProducer(
                                                   );
                                                 ph.
                                                   setWindingRule(
                                                     wr);
                                                 p.
                                                   setPathHandler(
                                                     ph);
                                                 p.
                                                   parse(
                                                     r);
                                                 return ph.
                                                   getShape(
                                                     );
    }
    public void setWindingRule(int i) { windingRule =
                                          i;
    }
    public int getWindingRule() { return windingRule;
    }
    public java.awt.Shape getShape() { return path;
    }
    public void startPath() throws org.apache.batik.parser.ParseException {
        currentX =
          0;
        currentY =
          0;
        xCenter =
          0;
        yCenter =
          0;
        path =
          new org.apache.batik.ext.awt.geom.ExtendedGeneralPath(
            windingRule);
    }
    public void endPath() throws org.apache.batik.parser.ParseException {
        
    }
    public void movetoRel(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          moveTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void movetoAbs(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          moveTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public void closePath() throws org.apache.batik.parser.ParseException {
        path.
          closePath(
            );
        java.awt.geom.Point2D pt =
          path.
          getCurrentPoint(
            );
        currentX =
          (float)
            pt.
            getX(
              );
        currentY =
          (float)
            pt.
            getY(
              );
    }
    public void linetoRel(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void linetoAbs(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public void linetoHorizontalRel(float x)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              currentY);
    }
    public void linetoHorizontalAbs(float x)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              currentY);
    }
    public void linetoVerticalRel(float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              currentX,
            yCenter =
              (currentY +=
                 y));
    }
    public void linetoVerticalAbs(float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              currentX,
            yCenter =
              (currentY =
                 y));
    }
    public void curvetoCubicRel(float x1,
                                float y1,
                                float x2,
                                float y2,
                                float x,
                                float y) throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX +
              x1,
            currentY +
              y1,
            xCenter =
              currentX +
                x2,
            yCenter =
              currentY +
                y2,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoCubicAbs(float x1,
                                float y1,
                                float x2,
                                float y2,
                                float x,
                                float y) throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            x1,
            y1,
            xCenter =
              x2,
            yCenter =
              y2,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoCubicSmoothRel(float x2,
                                      float y2,
                                      float x,
                                      float y)
          throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX *
              2 -
              xCenter,
            currentY *
              2 -
              yCenter,
            xCenter =
              currentX +
                x2,
            yCenter =
              currentY +
                y2,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoCubicSmoothAbs(float x2,
                                      float y2,
                                      float x,
                                      float y)
          throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX *
              2 -
              xCenter,
            currentY *
              2 -
              yCenter,
            xCenter =
              x2,
            yCenter =
              y2,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoQuadraticRel(float x1,
                                    float y1,
                                    float x,
                                    float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX +
                x1,
            yCenter =
              currentY +
                y1,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoQuadraticAbs(float x1,
                                    float y1,
                                    float x,
                                    float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              x1,
            yCenter =
              y1,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoQuadraticSmoothRel(float x,
                                          float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX *
                2 -
                xCenter,
            yCenter =
              currentY *
                2 -
                yCenter,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoQuadraticSmoothAbs(float x,
                                          float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX *
                2 -
                xCenter,
            yCenter =
              currentY *
                2 -
                yCenter,
            currentX =
              x,
            currentY =
              y);
    }
    public void arcRel(float rx, float ry,
                       float xAxisRotation,
                       boolean largeArcFlag,
                       boolean sweepFlag,
                       float x,
                       float y) throws org.apache.batik.parser.ParseException {
        path.
          arcTo(
            rx,
            ry,
            xAxisRotation,
            largeArcFlag,
            sweepFlag,
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void arcAbs(float rx, float ry,
                       float xAxisRotation,
                       boolean largeArcFlag,
                       boolean sweepFlag,
                       float x,
                       float y) throws org.apache.batik.parser.ParseException {
        path.
          arcTo(
            rx,
            ry,
            xAxisRotation,
            largeArcFlag,
            sweepFlag,
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public AWTPathProducer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "P4H1FPWKNgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5M/9bk/KrB20qFCYIp1VYC0G3alLT4czxK3D81FieBSPST2J6IcDWV4sxjFG" +
       "gGC0nrRpNfOlMYrYY5wgqxzVmNW65LSmlnHQXi60IYitNCbo6QriZgN/pdZH" +
       "iQk3RGKJDBY918SAcR2nJFvZLCSNnknl4dhttAEcwu1F2JItTbUqKtVM2zgz" +
       "I1WoY/EYY1u2hfer5QrVWYQAIJArWRZ9OqyO1yiixFOxN0xkF8OmDkQDTckn" +
       "gWpzZkkAKNawngpH9NxULIWe99stp6Y7XZKNLS2aGzVkJg3KC7Y9xgx+iJGA" +
       "3gXt1moiRoNWbYT5repCn6lqs9tOjQrnUo0oqAmVigLAmNdcLyAuAFZ1ekpy" +
       "w7GU+KoiCVzga7VyhssLGiJIyaIsOSgTAjiNoKa0HvGDPtfHB/BKEWYbvBHF" +
       "nizjIOi503adnfGegM6WVWfN1upLf1rpx5FM15aq0vKxLjamltOFmvCGoq5H" +
       "drNdB9jpzLEx3a6Mqkuo1jVZu0MbkFdN5zLYci10GSXLTuimiMU0OTJEl1ja" +
       "afWWFBCPRKvdtmtyjZiGMpQFC7UqizqWUoHMEZTshDqECf48lJYNJK21adiG" +
       "xv0azKwHrN0HkkGzCjd7EGgyw3Tcohk81BbjlWpNpg7oztemQzU7zbgDE4hn" +
       "l6Vys2qkbE2sulIHYKCaqXJrao1iQyX1aRUZYzLXnnskRI1mLDtOaZRGYqVX" +
       "FQO4txDFZTKTicjrixgSjWeiyHo0zuoIw64DpuXiFNtuyiMvDcgZkaLkyvSh" +
       "EDa6ltDEFNu35nZ/MBrq9Y0QTss0iygLMpYHCmrPhR6loHSHIPhqMGAb8Wju" +
       "tDgfrjig04DDheGu1IolyIDWJ2xnsOKsFs9RYMPQk1UIyg2eWKPWLK2McL7b" +
       "Koebsm9YwaYi9dAamEbmhDWhJRyJkSBvlh2yXactnG+LywkEjqWV5EK9bh1M" +
       "0M56Vu5klpD9IUF6zsRgNCNe1CF4wFRAe0VXx7qVON2W0yEtx1qY/QBnoUmL" +
       "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" +
       "XzG85oScJ6v8FeyjXxy9Ufhnl0q3Haz4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nfr26XihR4+v893lSUHoWdSx1b5XH9jsvn07wTubwSff5B96xSn/unToX1vX" +
       "OrFefem4qbfvtjX7xlzixO0ahF+U+5VnL3fvfrkxPogFyTnQafbsjWe7T/Zz" +
       "wF4087GcfCgovUDwJC6QCqc5Llu+Bnl4u4iCD5/3Pvvo2nRx418eKPcF+c03" +
       "ZMdyp9zlc1BusUby8E31unfIsFXgZ57lQ4H/kJNPZQh9KWCefaHl9o2tiYfQ" +
       "/90tQL+W38xX+B7fQX/8YqAfRfalZ3n2ezn5fIZaOYa6UNkhwi/cAsIi470i" +
       "O9QdQvXiEf7Rszz7ak7+IChdzRAWPptf/9tDbF+5Vcd9ZXbYO2z2xWP707Od" +
       "+hMFw5/l5GtZas7ymhfsfwbw24cIv36rCHPrpTuE6cUj/M55CP93Tr4VFN86" +
       "3gTfX9wqvnJ2vHuH790Xg+/SYeIv1o/nBddfnYf0r3Py/cyWpr2RAnsuGSew" +
       "/uVFYH1yh/XJ5xHr3tVzsO7dlZPbDrB2ef841r3bLyIyn9phferC/XbvJech" +
       "fFlOrmUIBcP2pdOeu3f9Iqz5zA7hM8+nNV97HtYHc/LKDGv+5fFNPHfvVReB" +
       "9YM7rB98PrG+5TysN3LypgOspz334VvF+pbs+MgO60cuBusRFFuY7fNg/p2c" +
       "NLJx5RYmbHtamn/MZ5w2bvMiAH9sB/hjzxPg/nmAhzn58ZsAPm3hx24V8Juz" +
       "45M7wJ98ngAT5wHOnX4PySa6W8ALyQs04Wb2RS8C7qd3cD/9PMH9ifPgvj0n" +
       "zCm4p627vFW4tez4nR3cz10M3MsFw+XDXHUzUsBUz9ODnhMhKF0TQi/veqGQ" +
       "14TTRhcvQgtf3mnhv/yotRCcp4VNTuwTWjjtC86taiH/OvK/7bTw1YvRwu0F" +
       "w+1nYn/3edjfk5N3BqWXHsVOmrYdqKf94F0XoYFv7jTwjR+NBv7peRp4KidP" +
       "3lQDp33gvbeqASA7vr/TwPd+NBp45jwN/POc/FzW2+00MAs50cs/7DztAU9f" +
       "AP69vW3Z7c/zj/9D5+H/SE4+eBP8p+3/L24V/6NZy1d3+K9eDP6bj10/cR7q" +
       "X8/JvwlKrziJ+qzo/+hFYL93h/3e5xP7vz8P+2/l5DfPxH7a7p+6VewPZ+0/" +
       "uMP+movBfqVguHLC5YvHJ15TXuFt25C4fFva3hdP6OoL5+nqP+fkc0HpMufd" +
       "JCH8x4tQzI2dYsrPp2L2wZ/SwB+ep4E/zsnvbzVw2jX+4LloIM5GGSd2i+bb" +
       "3e47tQ19u3Va+LUPXLv68g/Qf1hsmDzY3nwnWroqh4ZxdHfSkfPLjifJWqGa" +
       "O7d7lZwCx9eD0svPePuf7yYsTnKJ97625f+fQen6Sf6gdEfxe5Tvz4LSXYd8" +
       "uZ6Kk6Ms3wxKt2Us+emfO4VWju8D2G7SiveKR/cddZdcx6V7ztPxQZGj+ynz" +
       "9afi3wDsrxWF238E8Ljw8Q9Mpu/8buvD2/2cgsGlaV7LVbR0Zbu1tKg0X296" +
       "3Zm17dd1GX7kB3d/4s437K+N3b0V+NB1j8j2mptvmByYTlBscUw/9fJPvu1f" +
       "feBPim0J/x9QE3eGn0EAAA==");
}
