package org.apache.batik.transcoder.wmf.tosvg;
public abstract class AbstractWMFReader {
    public static final float PIXEL_PER_INCH = java.awt.Toolkit.getDefaultToolkit(
                                                                  ).
      getScreenResolution(
        );
    public static final float MM_PER_PIXEL = 25.4F / java.awt.Toolkit.
      getDefaultToolkit(
        ).
      getScreenResolution(
        );
    protected int left;
    protected int right;
    protected int top;
    protected int bottom;
    protected int width;
    protected int height;
    protected int inch;
    protected float scaleX;
    protected float scaleY;
    protected float scaleXY;
    protected int vpW;
    protected int vpH;
    protected int vpX;
    protected int vpY;
    protected int xSign = 1;
    protected int ySign = 1;
    protected volatile boolean bReading = false;
    protected boolean isAldus = false;
    protected boolean isotropic = true;
    protected int mtType;
    protected int mtHeaderSize;
    protected int mtVersion;
    protected int mtSize;
    protected int mtNoObjects;
    protected int mtMaxRecord;
    protected int mtNoParameters;
    protected int windowWidth;
    protected int windowHeight;
    protected int numObjects;
    protected java.util.List objectVector;
    public int lastObjectIdx;
    public AbstractWMFReader() { super();
                                 scaleX = 1;
                                 scaleY = 1;
                                 scaleXY = 1.0F;
                                 left = -1;
                                 top = -1;
                                 width = -1;
                                 height = -1;
                                 right = left + width;
                                 bottom = top + height;
                                 numObjects = 0;
                                 objectVector = new java.util.ArrayList(
                                                  ); }
    public AbstractWMFReader(int width, int height) { this();
                                                      this.width =
                                                        width;
                                                      this.height =
                                                        height; }
    protected short readShort(java.io.DataInputStream is) throws java.io.IOException {
        byte[] js =
          new byte[2];
        is.
          readFully(
            js);
        int iTemp =
          (255 &
             js[1]) <<
          8;
        short i =
          (short)
            (65535 &
               iTemp);
        i |=
          255 &
            js[0];
        return i;
    }
    protected int readInt(java.io.DataInputStream is) throws java.io.IOException {
        byte[] js =
          new byte[4];
        is.
          readFully(
            js);
        int i =
          (255 &
             js[3]) <<
          24;
        i |=
          (255 &
             js[2]) <<
            16;
        i |=
          (255 &
             js[1]) <<
            8;
        i |=
          255 &
            js[0];
        return i;
    }
    public float getViewportWidthUnits() { return vpW;
    }
    public float getViewportHeightUnits() { return vpH;
    }
    public float getViewportWidthInch() { return (float)
                                                   vpW /
                                            (float)
                                              inch;
    }
    public float getViewportHeightInch() { return (float)
                                                    vpH /
                                             (float)
                                               inch;
    }
    public float getPixelsPerUnit() { return PIXEL_PER_INCH /
                                        (float)
                                          inch; }
    public int getVpW() { return (int) (PIXEL_PER_INCH *
                                          (float)
                                            vpW /
                                          (float)
                                            inch);
    }
    public int getVpH() { return (int) (PIXEL_PER_INCH *
                                          (float)
                                            vpH /
                                          (float)
                                            inch);
    }
    public int getLeftUnits() { return left; }
    public int getRightUnits() { return right; }
    public int getTopUnits() { return top; }
    public int getWidthUnits() { return width; }
    public int getHeightUnits() { return height; }
    public int getBottomUnits() { return bottom; }
    public int getMetaFileUnitsPerInch() { return inch;
    }
    public java.awt.Rectangle getRectangleUnits() {
        java.awt.Rectangle rec =
          new java.awt.Rectangle(
          left,
          top,
          width,
          height);
        return rec;
    }
    public java.awt.geom.Rectangle2D getRectanglePixel() {
        float _left =
          PIXEL_PER_INCH *
          (float)
            left /
          (float)
            inch;
        float _right =
          PIXEL_PER_INCH *
          (float)
            right /
          (float)
            inch;
        float _top =
          PIXEL_PER_INCH *
          (float)
            top /
          (float)
            inch;
        float _bottom =
          PIXEL_PER_INCH *
          (float)
            bottom /
          (float)
            inch;
        java.awt.geom.Rectangle2D.Float rec =
          new java.awt.geom.Rectangle2D.Float(
          _left,
          _top,
          _right -
            _left,
          _bottom -
            _top);
        return rec;
    }
    public java.awt.geom.Rectangle2D getRectangleInch() {
        float _left =
          (float)
            left /
          (float)
            inch;
        float _right =
          (float)
            right /
          (float)
            inch;
        float _top =
          (float)
            top /
          (float)
            inch;
        float _bottom =
          (float)
            bottom /
          (float)
            inch;
        java.awt.geom.Rectangle2D.Float rec =
          new java.awt.geom.Rectangle2D.Float(
          _left,
          _top,
          _right -
            _left,
          _bottom -
            _top);
        return rec;
    }
    public int getWidthPixels() { return (int) (PIXEL_PER_INCH *
                                                  (float)
                                                    width /
                                                  (float)
                                                    inch);
    }
    public float getUnitsToPixels() { return PIXEL_PER_INCH /
                                        (float)
                                          inch; }
    public float getVpWFactor() { return PIXEL_PER_INCH *
                                    (float)
                                      width /
                                    (float)
                                      inch /
                                    (float)
                                      vpW; }
    public float getVpHFactor() { return PIXEL_PER_INCH *
                                    (float)
                                      height /
                                    (float)
                                      inch /
                                    (float)
                                      vpH; }
    public int getHeightPixels() { return (int) (PIXEL_PER_INCH *
                                                   (float)
                                                     height /
                                                   (float)
                                                     inch);
    }
    public int getXSign() { return xSign; }
    public int getYSign() { return ySign; }
    protected synchronized void setReading(boolean state) {
        bReading =
          state;
    }
    public synchronized boolean isReading() { return bReading;
    }
    public abstract void reset();
    protected abstract boolean readRecords(java.io.DataInputStream is)
          throws java.io.IOException;
    public void read(java.io.DataInputStream is) throws java.io.IOException {
        reset(
          );
        setReading(
          true);
        int dwIsAldus =
          readInt(
            is);
        if (dwIsAldus ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                META_ALDUS_APM) {
            int key =
              dwIsAldus;
            isAldus =
              true;
            readShort(
              is);
            left =
              readShort(
                is);
            top =
              readShort(
                is);
            right =
              readShort(
                is);
            bottom =
              readShort(
                is);
            inch =
              readShort(
                is);
            int reserved =
              readInt(
                is);
            short checksum =
              readShort(
                is);
            if (left >
                  right) {
                int _i =
                  right;
                right =
                  left;
                left =
                  _i;
                xSign =
                  -1;
            }
            if (top >
                  bottom) {
                int _i =
                  bottom;
                bottom =
                  top;
                top =
                  _i;
                ySign =
                  -1;
            }
            width =
              right -
                left;
            height =
              bottom -
                top;
            mtType =
              readShort(
                is);
            mtHeaderSize =
              readShort(
                is);
        }
        else {
            mtType =
              dwIsAldus <<
                16 >>
                16;
            mtHeaderSize =
              dwIsAldus >>
                16;
        }
        mtVersion =
          readShort(
            is);
        mtSize =
          readInt(
            is);
        mtNoObjects =
          readShort(
            is);
        mtMaxRecord =
          readInt(
            is);
        mtNoParameters =
          readShort(
            is);
        numObjects =
          mtNoObjects;
        java.util.List tempList =
          new java.util.ArrayList(
          numObjects);
        for (int i =
               0;
             i <
               numObjects;
             i++) {
            tempList.
              add(
                new org.apache.batik.transcoder.wmf.tosvg.GdiObject(
                  i,
                  false));
        }
        objectVector.
          addAll(
            tempList);
        boolean ret =
          readRecords(
            is);
        is.
          close(
            );
        if (!ret)
            throw new java.io.IOException(
              "Unhandled exception while reading records");
    }
    public int addObject(int type, java.lang.Object obj) {
        int startIdx =
          0;
        for (int i =
               startIdx;
             i <
               numObjects;
             i++) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdi =
              (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                objectVector.
                get(
                  i);
            if (!gdi.
                   used) {
                gdi.
                  Setup(
                    type,
                    obj);
                lastObjectIdx =
                  i;
                break;
            }
        }
        return lastObjectIdx;
    }
    public int addObjectAt(int type, java.lang.Object obj,
                           int idx) { if (idx == 0 ||
                                            idx >
                                            numObjects) {
                                          addObject(
                                            type,
                                            obj);
                                          return lastObjectIdx;
                                      }
                                      lastObjectIdx =
                                        idx;
                                      for (int i =
                                             0; i <
                                                  numObjects;
                                           i++) {
                                          org.apache.batik.transcoder.wmf.tosvg.GdiObject gdi =
                                            (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                                              objectVector.
                                              get(
                                                i);
                                          if (i ==
                                                idx) {
                                              gdi.
                                                Setup(
                                                  type,
                                                  obj);
                                              break;
                                          }
                                      }
                                      return idx;
    }
    public org.apache.batik.transcoder.wmf.tosvg.GdiObject getObject(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                 objectVector.
                 get(
                   idx);
    }
    public int getNumObjects() { return numObjects;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "oXf2UgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL19CbDs2Fle3zv74tnsscdjz2LP2MxM20/dUqul9hiw1JvU" +
       "q9SbusUyVmtv7VtLajBgF2RcgXIoPCaGMoYUJhBjMFAhOIUNpkjALEWw4wJM" +
       "EtsFFJshhSGAwRDnSN333fvuu/fOfbz78qp0rlpn0ff9/3/+s+mc96G/LNwS" +
       "+IWi65ipajrhJTkJL61M9FKYunJwqdNDGcEPZKluCkEwAc+eE1/7U/f+3Ze/" +
       "W7tvv3ArX3ipYNtOKIS6YwcjOXDMtSz1CvcePm2ashWEhft6K2EtQFGom1BP" +
       "D8Jne4W7jmQNC0/2DiBAAAIEIEA5BIg4TAUyvUS2I6ue5RDsMPAK31LY6xVu" +
       "dcUMXlh4zZWFuIIvWLtimJwBKOH27PcMkMozJ37h8cvct5yvIvyeIvTCv/3G" +
       "+37mpsK9fOFe3R5ncEQAIgQv4Qt3W7K1lP2AkCRZ4gv327IsjWVfF0x9k+Pm" +
       "Cw8EumoLYeTLl4WUPYxc2c/feSi5u8WMmx+JoeNfpqfosikd/LpFMQUVcH35" +
       "Idctw1b2HBC8UwfAfEUQ5YMsNxu6LYWFx47nuMzxyS5IALLeZsmh5lx+1c22" +
       "AB4UHtjqzhRsFRqHvm6rIOktTgTeEhYePrXQTNauIBqCKj8XFh46no7ZRoFU" +
       "d+SCyLKEhQePJ8tLAlp6+JiWjujnLwdvftc32ZS9n2OWZNHM8N8OMj16LNNI" +
       "VmRftkV5m/HuZ3rfK7z8Y+/cLxRA4gePJd6m+blv/uJb3vDoxz+xTfOqE9IM" +
       "lytZDJ8TP7C855Ovrj9duymDcbvrBHqm/CuY5+bP7GKeTVxQ815+ucQs8tJB" +
       "5MdHv7L4tg/KX9gv3EkXbhUdM7KAHd0vOparm7Lflm3ZF0JZogt3yLZUz+Pp" +
       "wm3gvqfb8vbpUFECOaQLN5v5o1ud/DcQkQKKyER0G7jXbcU5uHeFUMvvE7dQ" +
       "KNwHrsKD4HqysP2X/w0LK0hzLBkSRMHWbQdifCfjH0CyHS6BbDVoCazegAIn" +
       "8oEJQo6vQgKwA03eRYS+YAeiI8k+FFsKFDrBWoWIJbB6QQy5fmskCyDuUmZz" +
       "7v/XtyUZ9/vivT2gllcfdwomqE+UY4K0z4kvRGTziz/53G/sX64kO6mFBQwA" +
       "uLQFcCkHcOkQwCUA4FIO4NJVAAp7e/l7X5YB2ZoCUKQBXAJwlnc/Pf6Gzlvf" +
       "+dqbgA268c1AC/sgKXS6z64fOhE6d5UisOTCx98bv332raX9wv6VzjcDDx7d" +
       "mWVnMpd52TU+ebzSnVTuvc//6d99+Hvf5hxWvyu8+c4rXJ0zq9WvPS5m3xFl" +
       "CfjJw+KfeVz42ec+9rYn9ws3A1cB3GMoAHMGnufR4++4onY/e+ApMy63AMKK" +
       "41uCmUUduLc7Q8134sMnuf7vye/vBzK+KzP3V4PrzTv7z/9msS91s/BlW3vJ" +
       "lHaMRe6Jv3rs/sDv/dafIbm4D5z2vUeawbEcPnvEUWSF3Zu7hPsPbWDiyzJI" +
       "97/ey7z7PX/5/NflBgBSPHHSC5/MwjpwEECFQMzf8QnvM5/77Ac+vX/ZaPZC" +
       "0FJGS1MXk8sks+eFO88gCd72+kM8wNGYoPplVvPk1LYcSVd0YWnKmZX+072v" +
       "K//sX7zrvq0dmODJgRm94cULOHz+SrLwbb/xjX//aF7Mnpg1dIcyO0y29Z4v" +
       "PSyZ8H0hzXAkb//UI9/3q8IPAD8MfF+gb+TcnRVyGRRypUE5/2fy8NKxuHIW" +
       "PBYcNf4r69eRDslz4nd/+q9eMvurX/hijvbKHs1RXfcF99mteWXB4wko/hXH" +
       "azolBBpIV/n44OvvMz/+ZVAiD0oUgVcLhj5wEckVlrFLfcttv/9Lv/zyt37y" +
       "psJ+q3Cn6QhSS8grWeEOYN1yoAGXlbhf+5atcuPbD/x6UriKfP7g4avNv7Oz" +
       "jM7J5p+Fr8mC111tVKdlPSb+/cs+7ekz+qG+boGKst613dDbHvic8b4//Ylt" +
       "u3y8oT+WWH7nC//6K5fe9cL+kd7QE1d1SI7m2faIcoov2fL6Cvi3B67/m10Z" +
       "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" +
       "dbeKW93O2IIFQxhI5c7Y7DW6/eVImUx0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "5kcobz7yiv/45h99/2fzLfP/D6NLsrojYgAA");
}
