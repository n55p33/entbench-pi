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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZZj2UgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "EutzA0SdCumEp0rGWIq5XrefDcU6jt2i");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
