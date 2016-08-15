package org.apache.batik.transcoder.wmf.tosvg;
public class WMFPainter extends org.apache.batik.transcoder.wmf.tosvg.AbstractWMFPainter {
    private static final int INPUT_BUFFER_SIZE = 30720;
    private static final java.lang.Integer INTEGER_0 = new java.lang.Integer(
      0);
    private float scale;
    private float scaleX;
    private float scaleY;
    private float conv;
    private float xOffset;
    private float yOffset;
    private float vpX;
    private float vpY;
    private float vpW;
    private float vpH;
    private java.awt.Color frgdColor;
    private java.awt.Color bkgdColor;
    private boolean opaque = false;
    private transient boolean firstEffectivePaint = true;
    private static java.awt.BasicStroke solid = new java.awt.BasicStroke(
      1.0F,
      java.awt.BasicStroke.
        CAP_BUTT,
      java.awt.BasicStroke.
        JOIN_ROUND);
    private static java.awt.BasicStroke textSolid = new java.awt.BasicStroke(
      1.0F,
      java.awt.BasicStroke.
        CAP_BUTT,
      java.awt.BasicStroke.
        JOIN_ROUND);
    private transient java.awt.image.ImageObserver observer = new java.awt.image.ImageObserver(
      ) {
        public boolean imageUpdate(java.awt.Image img,
                                   int flags,
                                   int x,
                                   int y,
                                   int width,
                                   int height) {
            return false;
        }
    };
    public WMFPainter(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                      float scale) { this(currentStore, 0,
                                          0,
                                          scale); }
    public WMFPainter(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                      int xOffset,
                      int yOffset,
                      float scale) { super();
                                     setRecordStore(
                                       currentStore);
                                     org.apache.batik.transcoder.wmf.tosvg.TextureFactory.
                                       getInstance(
                                         ).
                                       reset(
                                         );
                                     this.
                                       conv =
                                       scale;
                                     this.
                                       xOffset =
                                       -xOffset;
                                     this.
                                       yOffset =
                                       -yOffset;
                                     this.
                                       scale =
                                       (float)
                                         currentStore.
                                         getWidthPixels(
                                           ) /
                                         (float)
                                           currentStore.
                                           getWidthUnits(
                                             ) *
                                         scale;
                                     this.
                                       scale =
                                       this.
                                         scale *
                                         (float)
                                           currentStore.
                                           getWidthPixels(
                                             ) /
                                         (float)
                                           currentStore.
                                           getVpW(
                                             );
                                     float xfactor =
                                       (float)
                                         currentStore.
                                         getVpW(
                                           ) /
                                       (float)
                                         currentStore.
                                         getWidthPixels(
                                           ) *
                                       (float)
                                         currentStore.
                                         getWidthUnits(
                                           ) /
                                       (float)
                                         currentStore.
                                         getWidthPixels(
                                           );
                                     float yfactor =
                                       (float)
                                         currentStore.
                                         getVpH(
                                           ) /
                                       (float)
                                         currentStore.
                                         getHeightPixels(
                                           ) *
                                       (float)
                                         currentStore.
                                         getHeightUnits(
                                           ) /
                                       (float)
                                         currentStore.
                                         getHeightPixels(
                                           );
                                     this.
                                       xOffset =
                                       this.
                                         xOffset *
                                         xfactor;
                                     this.
                                       yOffset =
                                       this.
                                         yOffset *
                                         yfactor;
                                     scaleX =
                                       this.
                                         scale;
                                     scaleY =
                                       this.
                                         scale;
    }
    public void paint(java.awt.Graphics g) {
        float fontHeight =
          10;
        float fontAngle =
          0;
        float penWidth =
          0;
        float startX =
          0;
        float startY =
          0;
        int brushObject =
          -1;
        int penObject =
          -1;
        int fontObject =
          -1;
        java.awt.Font font =
          null;
        int lastObjectIdx;
        java.util.Stack dcStack =
          new java.util.Stack(
          );
        int numRecords =
          currentStore.
          getNumRecords(
            );
        int numObjects =
          currentStore.
          getNumObjects(
            );
        vpX =
          currentStore.
            getVpX(
              ) *
            scale;
        vpY =
          currentStore.
            getVpY(
              ) *
            scale;
        vpW =
          currentStore.
            getVpW(
              ) *
            scale;
        vpH =
          currentStore.
            getVpH(
              ) *
            scale;
        if (!currentStore.
              isReading(
                )) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj;
            int gdiIndex;
            g.
              setPaintMode(
                );
            java.awt.Graphics2D g2d =
              (java.awt.Graphics2D)
                g;
            g2d.
              setStroke(
                solid);
            brushObject =
              -1;
            penObject =
              -1;
            fontObject =
              -1;
            frgdColor =
              null;
            bkgdColor =
              java.awt.Color.
                white;
            for (int i =
                   0;
                 i <
                   numObjects;
                 i++) {
                gdiObj =
                  currentStore.
                    getObject(
                      i);
                gdiObj.
                  clear(
                    );
            }
            float w =
              vpW;
            float h =
              vpH;
            g2d.
              setColor(
                java.awt.Color.
                  black);
            for (int iRec =
                   0;
                 iRec <
                   numRecords;
                 iRec++) {
                org.apache.batik.transcoder.wmf.tosvg.MetaRecord mr =
                  currentStore.
                  getRecord(
                    iRec);
                switch (mr.
                          functionId) {
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETWINDOWORG:
                        currentStore.
                          setVpX(
                            vpX =
                              -((float)
                                  mr.
                                  elementAt(
                                    0)));
                        currentStore.
                          setVpY(
                            vpY =
                              -((float)
                                  mr.
                                  elementAt(
                                    1)));
                        vpX =
                          vpX *
                            scale;
                        vpY =
                          vpY *
                            scale;
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETWINDOWORG_EX:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETWINDOWEXT:
                        vpW =
                          (float)
                            mr.
                            elementAt(
                              0);
                        vpH =
                          (float)
                            mr.
                            elementAt(
                              1);
                        scaleX =
                          scale;
                        scaleY =
                          scale;
                        solid =
                          new java.awt.BasicStroke(
                            scaleX *
                              2,
                            java.awt.BasicStroke.
                              CAP_BUTT,
                            java.awt.BasicStroke.
                              JOIN_ROUND);
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETVIEWPORTORG:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETVIEWPORTEXT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_OFFSETWINDOWORG:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SCALEWINDOWEXT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_OFFSETVIEWPORTORG:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SCALEVIEWPORTEXT:
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETPOLYFILLMODE:
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEPENINDIRECT:
                        {
                            int objIndex =
                              0;
                            int penStyle =
                              mr.
                              elementAt(
                                0);
                            java.awt.Color newClr;
                            if (penStyle ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    META_PS_NULL) {
                                newClr =
                                  java.awt.Color.
                                    white;
                                objIndex =
                                  addObjectAt(
                                    currentStore,
                                    NULL_PEN,
                                    newClr,
                                    objIndex);
                            }
                            else {
                                penWidth =
                                  mr.
                                    elementAt(
                                      4);
                                setStroke(
                                  g2d,
                                  penStyle,
                                  penWidth,
                                  scaleX);
                                newClr =
                                  new java.awt.Color(
                                    mr.
                                      elementAt(
                                        1),
                                    mr.
                                      elementAt(
                                        2),
                                    mr.
                                      elementAt(
                                        3));
                                objIndex =
                                  addObjectAt(
                                    currentStore,
                                    PEN,
                                    newClr,
                                    objIndex);
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEBRUSHINDIRECT:
                        {
                            int objIndex =
                              0;
                            int brushStyle =
                              mr.
                              elementAt(
                                0);
                            java.awt.Color clr =
                              new java.awt.Color(
                              mr.
                                elementAt(
                                  1),
                              mr.
                                elementAt(
                                  2),
                              mr.
                                elementAt(
                                  3));
                            if (brushStyle ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    BS_SOLID) {
                                objIndex =
                                  addObjectAt(
                                    currentStore,
                                    BRUSH,
                                    clr,
                                    objIndex);
                            }
                            else
                                if (brushStyle ==
                                      org.apache.batik.transcoder.wmf.WMFConstants.
                                        BS_HATCHED) {
                                    int hatch =
                                      mr.
                                      elementAt(
                                        4);
                                    java.awt.Paint paint;
                                    if (!opaque)
                                        paint =
                                          org.apache.batik.transcoder.wmf.tosvg.TextureFactory.
                                            getInstance(
                                              ).
                                            getTexture(
                                              hatch,
                                              clr);
                                    else
                                        paint =
                                          org.apache.batik.transcoder.wmf.tosvg.TextureFactory.
                                            getInstance(
                                              ).
                                            getTexture(
                                              hatch,
                                              clr,
                                              bkgdColor);
                                    if (paint !=
                                          null)
                                        objIndex =
                                          addObjectAt(
                                            currentStore,
                                            BRUSH,
                                            paint,
                                            objIndex);
                                    else {
                                        clr =
                                          java.awt.Color.
                                            black;
                                        objIndex =
                                          addObjectAt(
                                            currentStore,
                                            NULL_BRUSH,
                                            clr,
                                            objIndex);
                                    }
                                }
                                else {
                                    clr =
                                      java.awt.Color.
                                        black;
                                    objIndex =
                                      addObjectAt(
                                        currentStore,
                                        NULL_BRUSH,
                                        clr,
                                        objIndex);
                                }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEFONTINDIRECT:
                        {
                            float size =
                              (int)
                                (scaleY *
                                   mr.
                                   elementAt(
                                     0));
                            int charset =
                              mr.
                              elementAt(
                                3);
                            int italic =
                              mr.
                              elementAt(
                                1);
                            int weight =
                              mr.
                              elementAt(
                                2);
                            int style =
                              italic >
                              0
                              ? java.awt.Font.
                                  ITALIC
                              : java.awt.Font.
                                  PLAIN;
                            style |=
                              weight >
                                400
                                ? java.awt.Font.
                                    BOLD
                                : java.awt.Font.
                                    PLAIN;
                            java.lang.String face =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.StringRecord)
                                 mr).
                                text;
                            int d =
                              0;
                            while (d <
                                     face.
                                     length(
                                       ) &&
                                     (java.lang.Character.
                                        isLetterOrDigit(
                                          face.
                                            charAt(
                                              d)) ||
                                        java.lang.Character.
                                        isWhitespace(
                                          face.
                                            charAt(
                                              d))))
                                d++;
                            if (d >
                                  0)
                                face =
                                  face.
                                    substring(
                                      0,
                                      d);
                            else
                                face =
                                  "System";
                            if (size <
                                  0)
                                size =
                                  -size;
                            int objIndex =
                              0;
                            fontHeight =
                              size;
                            java.awt.Font f =
                              new java.awt.Font(
                              face,
                              style,
                              (int)
                                size);
                            f =
                              f.
                                deriveFont(
                                  size);
                            int underline =
                              mr.
                              elementAt(
                                4);
                            int strikeOut =
                              mr.
                              elementAt(
                                5);
                            int orient =
                              mr.
                              elementAt(
                                6);
                            int escape =
                              mr.
                              elementAt(
                                7);
                            org.apache.batik.transcoder.wmf.tosvg.WMFFont wf =
                              new org.apache.batik.transcoder.wmf.tosvg.WMFFont(
                              f,
                              charset,
                              underline,
                              strikeOut,
                              italic,
                              weight,
                              orient,
                              escape);
                            objIndex =
                              addObjectAt(
                                currentStore,
                                FONT,
                                wf,
                                objIndex);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEBRUSH:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEPATTERNBRUSH:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEBITMAPINDIRECT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEBITMAP:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEREGION:
                        {
                            int objIndex =
                              addObjectAt(
                                currentStore,
                                PALETTE,
                                INTEGER_0,
                                0);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEPALETTE:
                        {
                            int objIndex =
                              addObjectAt(
                                currentStore,
                                OBJ_REGION,
                                INTEGER_0,
                                0);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SELECTPALETTE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_REALIZEPALETTE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ANIMATEPALETTE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETPALENTRIES:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_RESIZEPALETTE:
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SELECTOBJECT:
                        gdiIndex =
                          mr.
                            elementAt(
                              0);
                        if ((gdiIndex &
                               -2147483648) !=
                              0)
                            break;
                        if (gdiIndex >=
                              numObjects) {
                            gdiIndex -=
                              numObjects;
                            switch (gdiIndex) {
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_NULL_BRUSH:
                                    brushObject =
                                      -1;
                                    break;
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_NULL_PEN:
                                    penObject =
                                      -1;
                                    break;
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_WHITE_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_LTGRAY_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_GRAY_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_DKGRAY_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_BLACK_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_WHITE_PEN:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_BLACK_PEN:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_OEM_FIXED_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_ANSI_FIXED_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_ANSI_VAR_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_SYSTEM_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_DEVICE_DEFAULT_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_DEFAULT_PALETTE:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_SYSTEM_FIXED_FONT:
                                    break;
                            }
                            break;
                        }
                        gdiObj =
                          currentStore.
                            getObject(
                              gdiIndex);
                        if (!gdiObj.
                               used)
                            break;
                        switch (gdiObj.
                                  type) {
                            case PEN:
                                g2d.
                                  setColor(
                                    (java.awt.Color)
                                      gdiObj.
                                        obj);
                                penObject =
                                  gdiIndex;
                                break;
                            case BRUSH:
                                if (gdiObj.
                                      obj instanceof java.awt.Color)
                                    g2d.
                                      setColor(
                                        (java.awt.Color)
                                          gdiObj.
                                            obj);
                                else
                                    if (gdiObj.
                                          obj instanceof java.awt.Paint) {
                                        g2d.
                                          setPaint(
                                            (java.awt.Paint)
                                              gdiObj.
                                                obj);
                                    }
                                    else
                                        g2d.
                                          setPaint(
                                            getPaint(
                                              (byte[])
                                                gdiObj.
                                                  obj));
                                brushObject =
                                  gdiIndex;
                                break;
                            case FONT:
                                {
                                    this.
                                      wmfFont =
                                      (org.apache.batik.transcoder.wmf.tosvg.WMFFont)
                                        gdiObj.
                                          obj;
                                    java.awt.Font f =
                                      this.
                                        wmfFont.
                                        font;
                                    g2d.
                                      setFont(
                                        f);
                                    fontObject =
                                      gdiIndex;
                                }
                                break;
                            case NULL_PEN:
                                penObject =
                                  -1;
                                break;
                            case NULL_BRUSH:
                                brushObject =
                                  -1;
                                break;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DELETEOBJECT:
                        gdiIndex =
                          mr.
                            elementAt(
                              0);
                        gdiObj =
                          currentStore.
                            getObject(
                              gdiIndex);
                        if (gdiIndex ==
                              brushObject)
                            brushObject =
                              -1;
                        else
                            if (gdiIndex ==
                                  penObject)
                                penObject =
                                  -1;
                            else
                                if (gdiIndex ==
                                      fontObject)
                                    fontObject =
                                      -1;
                        gdiObj.
                          clear(
                            );
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_POLYPOLYGON:
                        {
                            int numPolygons =
                              mr.
                              elementAt(
                                0);
                            int[] pts =
                              new int[numPolygons];
                            for (int ip =
                                   0;
                                 ip <
                                   numPolygons;
                                 ip++)
                                pts[ip] =
                                  mr.
                                    elementAt(
                                      ip +
                                        1);
                            int offset =
                              numPolygons +
                              1;
                            java.util.List v =
                              new java.util.ArrayList(
                              numPolygons);
                            for (int j =
                                   0;
                                 j <
                                   numPolygons;
                                 j++) {
                                int count =
                                  pts[j];
                                float[] xpts =
                                  new float[count];
                                float[] ypts =
                                  new float[count];
                                for (int k =
                                       0;
                                     k <
                                       count;
                                     k++) {
                                    xpts[k] =
                                      scaleX *
                                        (vpX +
                                           xOffset +
                                           mr.
                                           elementAt(
                                             offset +
                                               k *
                                               2));
                                    ypts[k] =
                                      scaleY *
                                        (vpY +
                                           yOffset +
                                           mr.
                                           elementAt(
                                             offset +
                                               k *
                                               2 +
                                               1));
                                }
                                offset +=
                                  count *
                                    2;
                                org.apache.batik.ext.awt.geom.Polygon2D pol =
                                  new org.apache.batik.ext.awt.geom.Polygon2D(
                                  xpts,
                                  ypts,
                                  count);
                                v.
                                  add(
                                    pol);
                            }
                            if (brushObject >=
                                  0) {
                                setBrushPaint(
                                  currentStore,
                                  g2d,
                                  brushObject);
                                fillPolyPolygon(
                                  g2d,
                                  v);
                                firstEffectivePaint =
                                  false;
                            }
                            if (penObject >=
                                  0) {
                                setPenColor(
                                  currentStore,
                                  g2d,
                                  penObject);
                                drawPolyPolygon(
                                  g2d,
                                  v);
                                firstEffectivePaint =
                                  false;
                            }
                            break;
                        }
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_POLYGON:
                        {
                            int count =
                              mr.
                              elementAt(
                                0);
                            float[] _xpts =
                              new float[count];
                            float[] _ypts =
                              new float[count];
                            for (int k =
                                   0;
                                 k <
                                   count;
                                 k++) {
                                _xpts[k] =
                                  scaleX *
                                    (vpX +
                                       xOffset +
                                       mr.
                                       elementAt(
                                         k *
                                           2 +
                                           1));
                                _ypts[k] =
                                  scaleY *
                                    (vpY +
                                       yOffset +
                                       mr.
                                       elementAt(
                                         k *
                                           2 +
                                           2));
                            }
                            org.apache.batik.ext.awt.geom.Polygon2D pol =
                              new org.apache.batik.ext.awt.geom.Polygon2D(
                              _xpts,
                              _ypts,
                              count);
                            paint(
                              brushObject,
                              penObject,
                              pol,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_MOVETO:
                        startX =
                          scaleX *
                            (vpX +
                               xOffset +
                               mr.
                               elementAt(
                                 0));
                        startY =
                          scaleY *
                            (vpY +
                               yOffset +
                               mr.
                               elementAt(
                                 1));
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_LINETO:
                        {
                            float endX =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   0));
                            float endY =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   1));
                            java.awt.geom.Line2D.Float line =
                              new java.awt.geom.Line2D.Float(
                              startX,
                              startY,
                              endX,
                              endY);
                            paintWithPen(
                              penObject,
                              line,
                              g2d);
                            startX =
                              endX;
                            startY =
                              endY;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_POLYLINE:
                        {
                            int count =
                              mr.
                              elementAt(
                                0);
                            float[] _xpts =
                              new float[count];
                            float[] _ypts =
                              new float[count];
                            for (int k =
                                   0;
                                 k <
                                   count;
                                 k++) {
                                _xpts[k] =
                                  scaleX *
                                    (vpX +
                                       xOffset +
                                       mr.
                                       elementAt(
                                         k *
                                           2 +
                                           1));
                                _ypts[k] =
                                  scaleY *
                                    (vpY +
                                       yOffset +
                                       mr.
                                       elementAt(
                                         k *
                                           2 +
                                           2));
                            }
                            org.apache.batik.ext.awt.geom.Polyline2D pol =
                              new org.apache.batik.ext.awt.geom.Polyline2D(
                              _xpts,
                              _ypts,
                              count);
                            paintWithPen(
                              penObject,
                              pol,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_RECTANGLE:
                        {
                            float x1;
                            float y1;
                            float x2;
                            float y2;
                            x1 =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     0));
                            x2 =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     2));
                            y1 =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     1));
                            y2 =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     3));
                            java.awt.geom.Rectangle2D.Float rec =
                              new java.awt.geom.Rectangle2D.Float(
                              x1,
                              y1,
                              x2 -
                                x1,
                              y2 -
                                y1);
                            paint(
                              brushObject,
                              penObject,
                              rec,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ROUNDRECT:
                        {
                            float x1;
                            float y1;
                            float x2;
                            float y2;
                            float x3;
                            float y3;
                            x1 =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     0));
                            x2 =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     2));
                            x3 =
                              scaleX *
                                (float)
                                  mr.
                                  elementAt(
                                    4);
                            y1 =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     1));
                            y2 =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     3));
                            y3 =
                              scaleY *
                                (float)
                                  mr.
                                  elementAt(
                                    5);
                            java.awt.geom.RoundRectangle2D rec =
                              new java.awt.geom.RoundRectangle2D.Float(
                              x1,
                              y1,
                              x2 -
                                x1,
                              y2 -
                                y1,
                              x3,
                              y3);
                            paint(
                              brushObject,
                              penObject,
                              rec,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ELLIPSE:
                        {
                            float x1 =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   0));
                            float x2 =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   2));
                            float y1 =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   1));
                            float y2 =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   3));
                            java.awt.geom.Ellipse2D.Float el =
                              new java.awt.geom.Ellipse2D.Float(
                              x1,
                              y1,
                              x2 -
                                x1,
                              y2 -
                                y1);
                            paint(
                              brushObject,
                              penObject,
                              el,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETTEXTALIGN:
                        currentHorizAlign =
                          org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                            getHorizontalAlignment(
                              mr.
                                elementAt(
                                  0));
                        currentVertAlign =
                          org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                            getVerticalAlignment(
                              mr.
                                elementAt(
                                  0));
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETTEXTCOLOR:
                        frgdColor =
                          new java.awt.Color(
                            mr.
                              elementAt(
                                0),
                            mr.
                              elementAt(
                                1),
                            mr.
                              elementAt(
                                2));
                        g2d.
                          setColor(
                            frgdColor);
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETBKCOLOR:
                        bkgdColor =
                          new java.awt.Color(
                            mr.
                              elementAt(
                                0),
                            mr.
                              elementAt(
                                1),
                            mr.
                              elementAt(
                                2));
                        g2d.
                          setColor(
                            bkgdColor);
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_EXTTEXTOUT:
                        try {
                            byte[] bstr =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            java.lang.String sr =
                              org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                              decodeString(
                                wmfFont,
                                bstr);
                            float x =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   0));
                            float y =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   1));
                            if (frgdColor !=
                                  null)
                                g2d.
                                  setColor(
                                    frgdColor);
                            else
                                g2d.
                                  setColor(
                                    java.awt.Color.
                                      black);
                            java.awt.font.FontRenderContext frc =
                              g2d.
                              getFontRenderContext(
                                );
                            java.awt.geom.Point2D.Double pen =
                              new java.awt.geom.Point2D.Double(
                              0,
                              0);
                            java.awt.geom.GeneralPath gp =
                              new java.awt.geom.GeneralPath(
                              java.awt.geom.GeneralPath.
                                WIND_NON_ZERO);
                            java.awt.font.TextLayout layout =
                              new java.awt.font.TextLayout(
                              sr,
                              g2d.
                                getFont(
                                  ),
                              frc);
                            int flag =
                              mr.
                              elementAt(
                                2);
                            int x1 =
                              0;
                            int y1 =
                              0;
                            int x2 =
                              0;
                            int y2 =
                              0;
                            boolean clipped =
                              false;
                            java.awt.Shape clip =
                              null;
                            if ((flag &
                                   org.apache.batik.transcoder.wmf.WMFConstants.
                                     ETO_CLIPPED) !=
                                  0) {
                                clipped =
                                  true;
                                x1 =
                                  mr.
                                    elementAt(
                                      3);
                                y1 =
                                  mr.
                                    elementAt(
                                      4);
                                x2 =
                                  mr.
                                    elementAt(
                                      5);
                                y2 =
                                  mr.
                                    elementAt(
                                      6);
                                clip =
                                  g2d.
                                    getClip(
                                      );
                                g2d.
                                  setClip(
                                    x1,
                                    y1,
                                    x2,
                                    y2);
                            }
                            firstEffectivePaint =
                              false;
                            y +=
                              getVerticalAlignmentValue(
                                layout,
                                currentVertAlign);
                            drawString(
                              flag,
                              g2d,
                              getCharacterIterator(
                                g2d,
                                sr,
                                wmfFont,
                                currentHorizAlign),
                              x,
                              y,
                              layout,
                              wmfFont,
                              currentHorizAlign);
                            if (clipped)
                                g2d.
                                  setClip(
                                    clip);
                        }
                        catch (java.lang.Exception e) {
                            
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_TEXTOUT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DRAWTEXT:
                        try {
                            byte[] bstr =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            java.lang.String sr =
                              org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                              decodeString(
                                wmfFont,
                                bstr);
                            float x =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   0));
                            float y =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   1));
                            if (frgdColor !=
                                  null)
                                g2d.
                                  setColor(
                                    frgdColor);
                            else
                                g2d.
                                  setColor(
                                    java.awt.Color.
                                      black);
                            java.awt.font.FontRenderContext frc =
                              g2d.
                              getFontRenderContext(
                                );
                            java.awt.geom.Point2D.Double pen =
                              new java.awt.geom.Point2D.Double(
                              0,
                              0);
                            java.awt.geom.GeneralPath gp =
                              new java.awt.geom.GeneralPath(
                              java.awt.geom.GeneralPath.
                                WIND_NON_ZERO);
                            java.awt.font.TextLayout layout =
                              new java.awt.font.TextLayout(
                              sr,
                              g2d.
                                getFont(
                                  ),
                              frc);
                            firstEffectivePaint =
                              false;
                            y +=
                              getVerticalAlignmentValue(
                                layout,
                                currentVertAlign);
                            drawString(
                              -1,
                              g2d,
                              getCharacterIterator(
                                g2d,
                                sr,
                                wmfFont),
                              x,
                              y,
                              layout,
                              wmfFont,
                              currentHorizAlign);
                        }
                        catch (java.lang.Exception e) {
                            
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ARC:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_PIE:
                        {
                            double left;
                            double top;
                            double right;
                            double bottom;
                            double xstart;
                            double ystart;
                            double xend;
                            double yend;
                            left =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     0));
                            top =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     1));
                            right =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     2));
                            bottom =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     3));
                            xstart =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     4));
                            ystart =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     5));
                            xend =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     6));
                            yend =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     7));
                            setBrushPaint(
                              currentStore,
                              g2d,
                              brushObject);
                            double cx =
                              left +
                              (right -
                                 left) /
                              2;
                            double cy =
                              top +
                              (bottom -
                                 top) /
                              2;
                            double startAngle =
                              -java.lang.Math.
                              toDegrees(
                                java.lang.Math.
                                  atan2(
                                    ystart -
                                      cy,
                                    xstart -
                                      cx));
                            double endAngle =
                              -java.lang.Math.
                              toDegrees(
                                java.lang.Math.
                                  atan2(
                                    yend -
                                      cy,
                                    xend -
                                      cx));
                            double extentAngle =
                              endAngle -
                              startAngle;
                            if (extentAngle <
                                  0)
                                extentAngle +=
                                  360;
                            if (startAngle <
                                  0)
                                startAngle +=
                                  360;
                            java.awt.geom.Arc2D.Double arc =
                              new java.awt.geom.Arc2D.Double(
                              left,
                              top,
                              right -
                                left,
                              bottom -
                                top,
                              startAngle,
                              extentAngle,
                              java.awt.geom.Arc2D.
                                OPEN);
                            if (mr.
                                  functionId ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    META_ARC)
                                g2d.
                                  draw(
                                    arc);
                            else
                                g2d.
                                  fill(
                                    arc);
                            firstEffectivePaint =
                              false;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CHORD:
                        {
                            double left;
                            double top;
                            double right;
                            double bottom;
                            double xstart;
                            double ystart;
                            double xend;
                            double yend;
                            left =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     0));
                            top =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     1));
                            right =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     2));
                            bottom =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     3));
                            xstart =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     4));
                            ystart =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     5));
                            xend =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     6));
                            yend =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     7));
                            setBrushPaint(
                              currentStore,
                              g2d,
                              brushObject);
                            double cx =
                              left +
                              (right -
                                 left) /
                              2;
                            double cy =
                              top +
                              (bottom -
                                 top) /
                              2;
                            double startAngle =
                              -java.lang.Math.
                              toDegrees(
                                java.lang.Math.
                                  atan2(
                                    ystart -
                                      cy,
                                    xstart -
                                      cx));
                            double endAngle =
                              -java.lang.Math.
                              toDegrees(
                                java.lang.Math.
                                  atan2(
                                    yend -
                                      cy,
                                    xend -
                                      cx));
                            double extentAngle =
                              endAngle -
                              startAngle;
                            if (extentAngle <
                                  0)
                                extentAngle +=
                                  360;
                            if (startAngle <
                                  0)
                                startAngle +=
                                  360;
                            java.awt.geom.Arc2D.Double arc =
                              new java.awt.geom.Arc2D.Double(
                              left,
                              top,
                              right -
                                left,
                              bottom -
                                top,
                              startAngle,
                              extentAngle,
                              java.awt.geom.Arc2D.
                                CHORD);
                            paint(
                              brushObject,
                              penObject,
                              arc,
                              g2d);
                            firstEffectivePaint =
                              false;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SAVEDC:
                        dcStack.
                          push(
                            new java.lang.Float(
                              penWidth));
                        dcStack.
                          push(
                            new java.lang.Float(
                              startX));
                        dcStack.
                          push(
                            new java.lang.Float(
                              startY));
                        dcStack.
                          push(
                            new java.lang.Integer(
                              brushObject));
                        dcStack.
                          push(
                            new java.lang.Integer(
                              penObject));
                        dcStack.
                          push(
                            new java.lang.Integer(
                              fontObject));
                        dcStack.
                          push(
                            frgdColor);
                        dcStack.
                          push(
                            bkgdColor);
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_RESTOREDC:
                        bkgdColor =
                          (java.awt.Color)
                            dcStack.
                            pop(
                              );
                        frgdColor =
                          (java.awt.Color)
                            dcStack.
                            pop(
                              );
                        fontObject =
                          ((java.lang.Integer)
                             dcStack.
                             pop(
                               )).
                            intValue(
                              );
                        penObject =
                          ((java.lang.Integer)
                             dcStack.
                             pop(
                               )).
                            intValue(
                              );
                        brushObject =
                          ((java.lang.Integer)
                             dcStack.
                             pop(
                               )).
                            intValue(
                              );
                        startY =
                          ((java.lang.Float)
                             dcStack.
                             pop(
                               )).
                            floatValue(
                              );
                        startX =
                          ((java.lang.Float)
                             dcStack.
                             pop(
                               )).
                            floatValue(
                              );
                        penWidth =
                          ((java.lang.Float)
                             dcStack.
                             pop(
                               )).
                            floatValue(
                              );
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_POLYBEZIER16:
                        try {
                            setPenColor(
                              currentStore,
                              g2d,
                              penObject);
                            int pointCount =
                              mr.
                              elementAt(
                                0);
                            int bezierCount =
                              (pointCount -
                                 1) /
                              3;
                            float _startX =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   1));
                            float _startY =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   2));
                            java.awt.geom.GeneralPath gp =
                              new java.awt.geom.GeneralPath(
                              java.awt.geom.GeneralPath.
                                WIND_NON_ZERO);
                            gp.
                              moveTo(
                                _startX,
                                _startY);
                            for (int j =
                                   0;
                                 j <
                                   bezierCount;
                                 j++) {
                                int j6 =
                                  j *
                                  6;
                                float cp1X =
                                  scaleX *
                                  (vpX +
                                     xOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         3));
                                float cp1Y =
                                  scaleY *
                                  (vpY +
                                     yOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         4));
                                float cp2X =
                                  scaleX *
                                  (vpX +
                                     xOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         5));
                                float cp2Y =
                                  scaleY *
                                  (vpY +
                                     yOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         6));
                                float endX =
                                  scaleX *
                                  (vpX +
                                     xOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         7));
                                float endY =
                                  scaleY *
                                  (vpY +
                                     yOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         8));
                                gp.
                                  curveTo(
                                    cp1X,
                                    cp1Y,
                                    cp2X,
                                    cp2Y,
                                    endX,
                                    endY);
                                _startX =
                                  endX;
                                _startY =
                                  endY;
                            }
                            g2d.
                              setStroke(
                                solid);
                            g2d.
                              draw(
                                gp);
                            firstEffectivePaint =
                              false;
                        }
                        catch (java.lang.Exception e) {
                            
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_EXCLUDECLIPRECT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_INTERSECTCLIPRECT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_OFFSETCLIPRGN:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SELECTCLIPREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETMAPMODE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETRELABS:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETSTRETCHBLTMODE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETTEXTCHAREXTRA:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETTEXTJUSTIFICATION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_FLOODFILL:
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETBKMODE:
                        {
                            int mode =
                              mr.
                              elementAt(
                                0);
                            opaque =
                              mode ==
                                org.apache.batik.transcoder.wmf.WMFConstants.
                                  OPAQUE;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETROP2:
                        {
                            float rop =
                              (float)
                                mr.
                                ElementAt(
                                  0).
                                intValue(
                                  );
                            java.awt.Paint paint =
                              null;
                            boolean ok =
                              false;
                            if (rop ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    META_BLACKNESS) {
                                paint =
                                  java.awt.Color.
                                    black;
                                ok =
                                  true;
                            }
                            else
                                if (rop ==
                                      org.apache.batik.transcoder.wmf.WMFConstants.
                                        META_WHITENESS) {
                                    paint =
                                      java.awt.Color.
                                        white;
                                    ok =
                                      true;
                                }
                                else
                                    if (rop ==
                                          org.apache.batik.transcoder.wmf.WMFConstants.
                                            META_PATCOPY) {
                                        if (brushObject >=
                                              0) {
                                            paint =
                                              getStoredPaint(
                                                currentStore,
                                                brushObject);
                                            ok =
                                              true;
                                        }
                                    }
                            if (ok) {
                                if (paint !=
                                      null) {
                                    g2d.
                                      setPaint(
                                        paint);
                                }
                                else {
                                    setBrushPaint(
                                      currentStore,
                                      g2d,
                                      brushObject);
                                }
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_PATBLT:
                        {
                            float rop =
                              (float)
                                mr.
                                elementAt(
                                  0);
                            float height =
                              scaleY *
                              (float)
                                mr.
                                elementAt(
                                  1);
                            float width =
                              scaleX *
                              (float)
                                mr.
                                elementAt(
                                  2);
                            float left =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   3));
                            float top =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   4));
                            java.awt.Paint paint =
                              null;
                            boolean ok =
                              false;
                            if (rop ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    META_BLACKNESS) {
                                paint =
                                  java.awt.Color.
                                    black;
                                ok =
                                  true;
                            }
                            else
                                if (rop ==
                                      org.apache.batik.transcoder.wmf.WMFConstants.
                                        META_WHITENESS) {
                                    paint =
                                      java.awt.Color.
                                        white;
                                    ok =
                                      true;
                                }
                                else
                                    if (rop ==
                                          org.apache.batik.transcoder.wmf.WMFConstants.
                                            META_PATCOPY) {
                                        if (brushObject >=
                                              0) {
                                            paint =
                                              getStoredPaint(
                                                currentStore,
                                                brushObject);
                                            ok =
                                              true;
                                        }
                                    }
                            if (ok) {
                                java.awt.Color oldClr =
                                  g2d.
                                  getColor(
                                    );
                                if (paint !=
                                      null) {
                                    g2d.
                                      setPaint(
                                        paint);
                                }
                                else {
                                    setBrushPaint(
                                      currentStore,
                                      g2d,
                                      brushObject);
                                }
                                java.awt.geom.Rectangle2D.Float rec =
                                  new java.awt.geom.Rectangle2D.Float(
                                  left,
                                  top,
                                  width,
                                  height);
                                g2d.
                                  fill(
                                    rec);
                                g2d.
                                  setColor(
                                    oldClr);
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DIBSTRETCHBLT:
                        {
                            int height =
                              mr.
                              elementAt(
                                1);
                            int width =
                              mr.
                              elementAt(
                                2);
                            int sy =
                              mr.
                              elementAt(
                                3);
                            int sx =
                              mr.
                              elementAt(
                                4);
                            float dy =
                              conv *
                              currentStore.
                              getVpWFactor(
                                ) *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   7));
                            float dx =
                              conv *
                              currentStore.
                              getVpHFactor(
                                ) *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   8));
                            float heightDst =
                              (float)
                                mr.
                                elementAt(
                                  5);
                            float widthDst =
                              (float)
                                mr.
                                elementAt(
                                  6);
                            widthDst =
                              widthDst *
                                conv *
                                currentStore.
                                getVpWFactor(
                                  );
                            heightDst =
                              heightDst *
                                conv *
                                currentStore.
                                getVpHFactor(
                                  );
                            byte[] bitmap =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            java.awt.image.BufferedImage img =
                              getImage(
                                bitmap,
                                width,
                                height);
                            if (img !=
                                  null) {
                                g2d.
                                  drawImage(
                                    img,
                                    (int)
                                      dx,
                                    (int)
                                      dy,
                                    (int)
                                      (dx +
                                         widthDst),
                                    (int)
                                      (dy +
                                         heightDst),
                                    sx,
                                    sy,
                                    sx +
                                      width,
                                    sy +
                                      height,
                                    bkgdColor,
                                    observer);
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_STRETCHDIB:
                        {
                            int height =
                              mr.
                              elementAt(
                                1);
                            int width =
                              mr.
                              elementAt(
                                2);
                            int sy =
                              mr.
                              elementAt(
                                3);
                            int sx =
                              mr.
                              elementAt(
                                4);
                            float dy =
                              conv *
                              currentStore.
                              getVpWFactor(
                                ) *
                              (vpY +
                                 yOffset +
                                 (float)
                                   mr.
                                   elementAt(
                                     7));
                            float dx =
                              conv *
                              currentStore.
                              getVpHFactor(
                                ) *
                              (vpX +
                                 xOffset +
                                 (float)
                                   mr.
                                   elementAt(
                                     8));
                            float heightDst =
                              (float)
                                mr.
                                elementAt(
                                  5);
                            float widthDst =
                              (float)
                                mr.
                                elementAt(
                                  6);
                            widthDst =
                              widthDst *
                                conv *
                                currentStore.
                                getVpWFactor(
                                  );
                            heightDst =
                              heightDst *
                                conv *
                                currentStore.
                                getVpHFactor(
                                  );
                            byte[] bitmap =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            java.awt.image.BufferedImage img =
                              getImage(
                                bitmap,
                                width,
                                height);
                            if (img !=
                                  null) {
                                if (opaque) {
                                    g2d.
                                      drawImage(
                                        img,
                                        (int)
                                          dx,
                                        (int)
                                          dy,
                                        (int)
                                          (dx +
                                             widthDst),
                                        (int)
                                          (dy +
                                             heightDst),
                                        sx,
                                        sy,
                                        sx +
                                          width,
                                        sy +
                                          height,
                                        bkgdColor,
                                        observer);
                                }
                                else {
                                    g2d.
                                      drawImage(
                                        img,
                                        (int)
                                          dx,
                                        (int)
                                          dy,
                                        (int)
                                          (dx +
                                             widthDst),
                                        (int)
                                          (dy +
                                             heightDst),
                                        sx,
                                        sy,
                                        sx +
                                          width,
                                        sy +
                                          height,
                                        observer);
                                }
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DIBBITBLT:
                        {
                            int rop =
                              mr.
                              ElementAt(
                                0).
                              intValue(
                                );
                            float height =
                              mr.
                              ElementAt(
                                1).
                              intValue(
                                ) *
                              conv *
                              currentStore.
                              getVpWFactor(
                                );
                            float width =
                              mr.
                              ElementAt(
                                2).
                              intValue(
                                ) *
                              conv *
                              currentStore.
                              getVpHFactor(
                                );
                            int sy =
                              mr.
                              ElementAt(
                                3).
                              intValue(
                                );
                            int sx =
                              mr.
                              ElementAt(
                                4).
                              intValue(
                                );
                            float dy =
                              conv *
                              currentStore.
                              getVpWFactor(
                                ) *
                              (vpY +
                                 yOffset +
                                 (float)
                                   mr.
                                   ElementAt(
                                     5).
                                   intValue(
                                     ));
                            float dx =
                              conv *
                              currentStore.
                              getVpHFactor(
                                ) *
                              (vpX +
                                 xOffset +
                                 (float)
                                   mr.
                                   ElementAt(
                                     6).
                                   intValue(
                                     ));
                            if (mr instanceof org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord) {
                                byte[] bitmap =
                                  ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                     mr).
                                    bstr;
                                java.awt.image.BufferedImage img =
                                  getImage(
                                    bitmap);
                                if (img !=
                                      null) {
                                    int withSrc =
                                      img.
                                      getWidth(
                                        );
                                    int heightSrc =
                                      img.
                                      getHeight(
                                        );
                                    if (opaque) {
                                        g2d.
                                          drawImage(
                                            img,
                                            (int)
                                              dx,
                                            (int)
                                              dy,
                                            (int)
                                              (dx +
                                                 width),
                                            (int)
                                              (dy +
                                                 height),
                                            sx,
                                            sy,
                                            sx +
                                              withSrc,
                                            sy +
                                              heightSrc,
                                            bkgdColor,
                                            observer);
                                    }
                                    else {
                                        g2d.
                                          drawImage(
                                            img,
                                            (int)
                                              dx,
                                            (int)
                                              dy,
                                            (int)
                                              (dx +
                                                 width),
                                            (int)
                                              (dy +
                                                 height),
                                            sx,
                                            sy,
                                            sx +
                                              withSrc,
                                            sy +
                                              heightSrc,
                                            observer);
                                    }
                                }
                            }
                            else {
                                if (opaque) {
                                    java.awt.Color col =
                                      g2d.
                                      getColor(
                                        );
                                    g2d.
                                      setColor(
                                        bkgdColor);
                                    g2d.
                                      fill(
                                        new java.awt.geom.Rectangle2D.Float(
                                          dx,
                                          dy,
                                          width,
                                          height));
                                    g2d.
                                      setColor(
                                        col);
                                }
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DIBCREATEPATTERNBRUSH:
                        {
                            int objIndex =
                              0;
                            byte[] bitmap =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            objIndex =
                              addObjectAt(
                                currentStore,
                                BRUSH,
                                bitmap,
                                objIndex);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETPIXEL:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_BITBLT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_STRETCHBLT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ESCAPE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_FILLREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_FRAMEREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_INVERTREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_PAINTREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETMAPPERFLAGS:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETDIBTODEV:
                    default:
                        {
                            
                        }
                        break;
                }
            }
        }
    }
    private java.awt.Paint getPaint(byte[] bit) {
        java.awt.Dimension d =
          getImageDimension(
            bit);
        java.awt.image.BufferedImage img =
          getImage(
            bit);
        java.awt.geom.Rectangle2D rec =
          new java.awt.geom.Rectangle2D.Float(
          0,
          0,
          (float)
            d.
              width,
          (float)
            d.
              height);
        java.awt.TexturePaint paint =
          new java.awt.TexturePaint(
          img,
          rec);
        return paint;
    }
    private void drawString(int flag, java.awt.Graphics2D g2d,
                            java.text.AttributedCharacterIterator ati,
                            float x,
                            float y,
                            java.awt.font.TextLayout layout,
                            org.apache.batik.transcoder.wmf.tosvg.WMFFont wmfFont,
                            int align) { if (wmfFont.
                                               escape ==
                                               0) {
                                             if (flag !=
                                                   -1)
                                                 fillTextBackground(
                                                   -1,
                                                   flag,
                                                   g2d,
                                                   x,
                                                   y,
                                                   0,
                                                   layout);
                                             float width =
                                               (float)
                                                 layout.
                                                 getBounds(
                                                   ).
                                                 getWidth(
                                                   );
                                             if (align ==
                                                   org.apache.batik.transcoder.wmf.WMFConstants.
                                                     TA_CENTER) {
                                                 g2d.
                                                   drawString(
                                                     ati,
                                                     x -
                                                       width /
                                                       2,
                                                     y);
                                             }
                                             else
                                                 if (align ==
                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                         TA_RIGHT) {
                                                     g2d.
                                                       drawString(
                                                         ati,
                                                         x -
                                                           width,
                                                         y);
                                                 }
                                                 else {
                                                     g2d.
                                                       drawString(
                                                         ati,
                                                         x,
                                                         y);
                                                 }
                                         }
                                         else {
                                             java.awt.geom.AffineTransform tr =
                                               g2d.
                                               getTransform(
                                                 );
                                             float angle =
                                               -((float)
                                                   (wmfFont.
                                                      escape *
                                                      java.lang.Math.
                                                        PI /
                                                      1800.0F));
                                             float width =
                                               (float)
                                                 layout.
                                                 getBounds(
                                                   ).
                                                 getWidth(
                                                   );
                                             float height =
                                               (float)
                                                 layout.
                                                 getBounds(
                                                   ).
                                                 getHeight(
                                                   );
                                             if (align ==
                                                   org.apache.batik.transcoder.wmf.WMFConstants.
                                                     TA_CENTER) {
                                                 g2d.
                                                   translate(
                                                     -width /
                                                       2,
                                                     height /
                                                       2);
                                                 g2d.
                                                   rotate(
                                                     angle,
                                                     x -
                                                       width /
                                                       2,
                                                     y);
                                             }
                                             else
                                                 if (align ==
                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                         TA_RIGHT) {
                                                     g2d.
                                                       translate(
                                                         -width /
                                                           2,
                                                         height /
                                                           2);
                                                     g2d.
                                                       rotate(
                                                         angle,
                                                         x -
                                                           width,
                                                         y);
                                                 }
                                                 else {
                                                     g2d.
                                                       translate(
                                                         0,
                                                         height /
                                                           2);
                                                     g2d.
                                                       rotate(
                                                         angle,
                                                         x,
                                                         y);
                                                 }
                                             if (flag !=
                                                   -1)
                                                 fillTextBackground(
                                                   align,
                                                   flag,
                                                   g2d,
                                                   x,
                                                   y,
                                                   width,
                                                   layout);
                                             java.awt.Stroke _st =
                                               g2d.
                                               getStroke(
                                                 );
                                             g2d.
                                               setStroke(
                                                 textSolid);
                                             g2d.
                                               drawString(
                                                 ati,
                                                 x,
                                                 y);
                                             g2d.
                                               setStroke(
                                                 _st);
                                             g2d.
                                               setTransform(
                                                 tr);
                                         }
    }
    private void fillTextBackground(int align,
                                    int flag,
                                    java.awt.Graphics2D g2d,
                                    float x,
                                    float y,
                                    float width,
                                    java.awt.font.TextLayout layout) {
        float _x =
          x;
        if (align ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_CENTER)
            _x =
              x -
                width /
                2;
        else
            if (align ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    TA_RIGHT)
                _x =
                  x -
                    width;
        if ((flag &
               org.apache.batik.transcoder.wmf.WMFConstants.
                 ETO_OPAQUE) !=
              0) {
            java.awt.Color c =
              g2d.
              getColor(
                );
            java.awt.geom.AffineTransform tr =
              g2d.
              getTransform(
                );
            g2d.
              setColor(
                bkgdColor);
            g2d.
              translate(
                _x,
                y);
            g2d.
              fill(
                layout.
                  getBounds(
                    ));
            g2d.
              setColor(
                c);
            g2d.
              setTransform(
                tr);
        }
        else
            if (opaque) {
                java.awt.Color c =
                  g2d.
                  getColor(
                    );
                java.awt.geom.AffineTransform tr =
                  g2d.
                  getTransform(
                    );
                g2d.
                  setColor(
                    bkgdColor);
                g2d.
                  translate(
                    _x,
                    y);
                g2d.
                  fill(
                    layout.
                      getBounds(
                        ));
                g2d.
                  setColor(
                    c);
                g2d.
                  setTransform(
                    tr);
            }
    }
    private void drawPolyPolygon(java.awt.Graphics2D g2d,
                                 java.util.List pols) {
        java.util.Iterator it =
          pols.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.geom.Polygon2D pol =
              (org.apache.batik.ext.awt.geom.Polygon2D)
                it.
                next(
                  );
            g2d.
              draw(
                pol);
        }
    }
    private void fillPolyPolygon(java.awt.Graphics2D g2d,
                                 java.util.List pols) {
        if (pols.
              size(
                ) ==
              1)
            g2d.
              fill(
                (org.apache.batik.ext.awt.geom.Polygon2D)
                  pols.
                  get(
                    0));
        else {
            java.awt.geom.GeneralPath path =
              new java.awt.geom.GeneralPath(
              java.awt.geom.GeneralPath.
                WIND_EVEN_ODD);
            for (int i =
                   0;
                 i <
                   pols.
                   size(
                     );
                 i++) {
                org.apache.batik.ext.awt.geom.Polygon2D pol =
                  (org.apache.batik.ext.awt.geom.Polygon2D)
                    pols.
                    get(
                      i);
                path.
                  append(
                    pol,
                    false);
            }
            g2d.
              fill(
                path);
        }
    }
    private void setStroke(java.awt.Graphics2D g2d,
                           int penStyle,
                           float penWidth,
                           float scale) {
        float _width;
        if (penWidth ==
              0)
            _width =
              1;
        else
            _width =
              penWidth;
        float _scale =
          (float)
            java.awt.Toolkit.
            getDefaultToolkit(
              ).
            getScreenResolution(
              ) /
          currentStore.
          getMetaFileUnitsPerInch(
            );
        float factor =
          scale /
          _scale;
        _width =
          _width *
            _scale *
            factor;
        _scale =
          currentStore.
            getWidthPixels(
              ) *
            1.0F /
            350.0F;
        java.awt.BasicStroke stroke;
        if (penStyle ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                META_PS_SOLID) {
            stroke =
              new java.awt.BasicStroke(
                _width,
                java.awt.BasicStroke.
                  CAP_BUTT,
                java.awt.BasicStroke.
                  JOIN_ROUND);
            g2d.
              setStroke(
                stroke);
        }
        else
            if (penStyle ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    META_PS_DOT) {
                float[] dash =
                  { 1.0F *
                  _scale,
                5.0F *
                  _scale };
                stroke =
                  new java.awt.BasicStroke(
                    _width,
                    java.awt.BasicStroke.
                      CAP_BUTT,
                    java.awt.BasicStroke.
                      JOIN_ROUND,
                    10.0F *
                      _scale,
                    dash,
                    0.0F);
                g2d.
                  setStroke(
                    stroke);
            }
            else
                if (penStyle ==
                      org.apache.batik.transcoder.wmf.WMFConstants.
                        META_PS_DASH) {
                    float[] dash =
                      { 5.0F *
                      _scale,
                    2.0F *
                      _scale };
                    stroke =
                      new java.awt.BasicStroke(
                        _width,
                        java.awt.BasicStroke.
                          CAP_BUTT,
                        java.awt.BasicStroke.
                          JOIN_ROUND,
                        10.0F *
                          _scale,
                        dash,
                        0.0F);
                    g2d.
                      setStroke(
                        stroke);
                }
                else
                    if (penStyle ==
                          org.apache.batik.transcoder.wmf.WMFConstants.
                            META_PS_DASHDOT) {
                        float[] dash =
                          { 5.0F *
                          _scale,
                        2.0F *
                          _scale,
                        1.0F *
                          _scale,
                        2.0F *
                          _scale };
                        stroke =
                          new java.awt.BasicStroke(
                            _width,
                            java.awt.BasicStroke.
                              CAP_BUTT,
                            java.awt.BasicStroke.
                              JOIN_ROUND,
                            10.0F *
                              _scale,
                            dash,
                            0.0F);
                        g2d.
                          setStroke(
                            stroke);
                    }
                    else
                        if (penStyle ==
                              org.apache.batik.transcoder.wmf.WMFConstants.
                                META_PS_DASHDOTDOT) {
                            float[] dash =
                              { 5.0F *
                              _scale,
                            2.0F *
                              _scale,
                            1.0F *
                              _scale,
                            2.0F *
                              _scale,
                            1.0F *
                              _scale,
                            2.0F *
                              _scale };
                            stroke =
                              new java.awt.BasicStroke(
                                _width,
                                java.awt.BasicStroke.
                                  CAP_BUTT,
                                java.awt.BasicStroke.
                                  JOIN_ROUND,
                                15.0F *
                                  _scale,
                                dash,
                                0.0F);
                            g2d.
                              setStroke(
                                stroke);
                        }
                        else {
                            stroke =
                              new java.awt.BasicStroke(
                                _width,
                                java.awt.BasicStroke.
                                  CAP_BUTT,
                                java.awt.BasicStroke.
                                  JOIN_ROUND);
                            g2d.
                              setStroke(
                                stroke);
                        }
    }
    private void setPenColor(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                             java.awt.Graphics2D g2d,
                             int penObject) {
        if (penObject >=
              0) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj =
              currentStore.
              getObject(
                penObject);
            g2d.
              setColor(
                (java.awt.Color)
                  gdiObj.
                    obj);
            penObject =
              -1;
        }
    }
    private int getHorizontalAlignement(int align) {
        int v =
          align;
        v =
          v %
            24;
        v =
          v %
            8;
        if (v >=
              6)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_CENTER;
        else
            if (v >=
                  2)
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_RIGHT;
            else
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_LEFT;
    }
    private void setBrushPaint(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                               java.awt.Graphics2D g2d,
                               int brushObject) {
        if (brushObject >=
              0) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj =
              currentStore.
              getObject(
                brushObject);
            if (gdiObj.
                  obj instanceof java.awt.Color)
                g2d.
                  setColor(
                    (java.awt.Color)
                      gdiObj.
                        obj);
            else
                if (gdiObj.
                      obj instanceof java.awt.Paint)
                    g2d.
                      setPaint(
                        (java.awt.Paint)
                          gdiObj.
                            obj);
                else
                    g2d.
                      setPaint(
                        getPaint(
                          (byte[])
                            gdiObj.
                              obj));
            brushObject =
              -1;
        }
    }
    private java.awt.Paint getStoredPaint(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                                          int object) {
        if (object >=
              0) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj =
              currentStore.
              getObject(
                object);
            if (gdiObj.
                  obj instanceof java.awt.Paint)
                return (java.awt.Paint)
                         gdiObj.
                           obj;
            else
                return getPaint(
                         (byte[])
                           gdiObj.
                             obj);
        }
        else
            return null;
    }
    private void paint(int brushObject, int penObject,
                       java.awt.Shape shape,
                       java.awt.Graphics2D g2d) {
        if (brushObject >=
              0) {
            java.awt.Paint paint =
              getStoredPaint(
                currentStore,
                brushObject);
            if (!(firstEffectivePaint &&
                    paint.
                    equals(
                      java.awt.Color.
                        white))) {
                setBrushPaint(
                  currentStore,
                  g2d,
                  brushObject);
                g2d.
                  fill(
                    shape);
                firstEffectivePaint =
                  false;
            }
        }
        if (penObject >=
              0) {
            java.awt.Paint paint =
              getStoredPaint(
                currentStore,
                penObject);
            if (!(firstEffectivePaint &&
                    paint.
                    equals(
                      java.awt.Color.
                        white))) {
                setPenColor(
                  currentStore,
                  g2d,
                  penObject);
                g2d.
                  draw(
                    shape);
                firstEffectivePaint =
                  false;
            }
        }
    }
    private void paintWithPen(int penObject,
                              java.awt.Shape shape,
                              java.awt.Graphics2D g2d) {
        if (penObject >=
              0) {
            java.awt.Paint paint =
              getStoredPaint(
                currentStore,
                penObject);
            if (!(firstEffectivePaint &&
                    paint.
                    equals(
                      java.awt.Color.
                        white))) {
                setPenColor(
                  currentStore,
                  g2d,
                  penObject);
                g2d.
                  draw(
                    shape);
                firstEffectivePaint =
                  false;
            }
        }
    }
    private float getVerticalAlignmentValue(java.awt.font.TextLayout layout,
                                            int vertAlign) {
        if (vertAlign ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BOTTOM)
            return -layout.
              getDescent(
                );
        else
            if (vertAlign ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    TA_TOP)
                return layout.
                  getAscent(
                    );
            else
                return 0;
    }
    public org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore getRecordStore() {
        return currentStore;
    }
    private transient java.io.BufferedInputStream
      bufStream =
      null;
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OcJX8Ed8uvL/AD5tZRU+PAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nYoo1lpN8CRlFQibipuuOTeiBiPqOpUu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("bV5ohSK/pZQmzg2qxCwZzrXqKA7G1ia0WvSINJU50lK3cktYcWFjIUTdRtpb" +
       "r3t6ddrEs1mNJKrJiO8MNbpLNKHRGkzKZ3mfxGrYRFBbcAbbITZgQ07mtVo8" +
       "Q00IqVuRqkhxyiNNPiPXjcwJu1Wju94OFlU1gevDfk9rb6eqYmcsuR5WN1Q/" +
       "pZvBOF5J+RQW8WU8SHE9NVHHZcNAauh4fTdYxRiP46G9g0NaTE2MzCSUXtfd" +
       "nYbv2PVghyY7QjXsSMJgpttrI4lgBkscn08WGJSbsgHFbkhZC38t5TsXm/OB" +
       "6XN2i9OIjTGR24zR7DbiBUV5RL3DtVOh6+3GsJqwtWDrCMoE6vMkgszkntXg" +
       "YZcgvOWEd2ArivGZ3zc6CJ/xRtRr15vQzGhuHAepLmtEsEg6stTEp2KNFHJt" +
       "O0/raVfo540dO8r6VZ4YLYAOjyZ6fShT9HaDLAZzfL1zhmgtpyKrLrf7swSe" +
       "QinVaQ3XKvCHMO3m/radQBuOUFNb4H08qy5XG0olVHOVKqFiwRu/bwmdNacn" +
       "yJDVa8PGPMzbWwQO6MkUX2hEM11iC6LhKZ3mdBMizY2xI7fZetN3pL66yylt" +
       "uxXUoOk7ERoRrIMgKRuHvawG4q232HFwx+mMydYab295ft4RdCWeqzu55SRN" +
       "1EXkIB4NsnaiDxBT8AaSwdHNVUImchCFZr5b9hRhnnIDhY2qxGqtB5xLyss5" +
       "CAJbW17Nd9u2sLYF1N3GM4uA/MXSQNWEHgb8brnB5wha7RCzbSsiBuukt1PS" +
       "BjpGikAXxpOh1M5oBBHYZCPlE3PTgdJoOuuyraoksgvASLwTpCileH1pNogz" +
       "e74aeFEVr8GStkFrDK9AMrZrOXLB6zGcBF02XMlGYwNNuQHWy5yOwmaTGWI3" +
       "+CBaIRNOHe6E1pbRJ9TSX5D+OPBVgoKgDGQ18Ljh1SbqYFVFW8sZ3+0gsU+A" +
       "oEYEXYumdVVQiG2NpjQEUC2RstjGRHzRthoZO/bq7b7XrPY7LRxEohW86cVh" +
       "fR1nYiaCEEeNp9xm0wyTDTpIGruwE5Bub4OSbtJZeRpBzTiWbcadec4wYbbI" +
       "h8u0t2yziG5Do0m7Q2Q1G2U6oTyytWF72ORoMM1HUDfoyWyeZfkC1uu7eofq" +
       "5/maH/cJ2Bi2tLbU4Whaq+f4ikXtlqhs+YjeUqbBe5w3sCboMDfqSsPWoWmj" +
       "LiXtJiqtpjEhOiIhCmwr2bZTvY6byXoDO6mRwOuwHmujyApjxJfmVCLYsxQA" +
       "3QrxQHKxJKQdTZ/VwhTxIYUONjDPbh2XnGtmr7eOoeGgTXYIx7frES7mSIYs" +
       "E5gR10F9Cpa+PG0kK33FLbadFTmilAT3UxNROIxxZWD3M29DmGxs4zFe1Qe7" +
       "VoR77K7qtZrODHOtKbyprS0RbczN1CO8MQxcGVGXlWU1j5bV0TQd0ywkG7Fs" +
       "E+s6trAUxkb6tUad6GWDPqPGdNyilCqdgTjIrowFPUV6szCPdzIXktuW68BN" +
       "qzlUNusGsZs2MCxz0Uae6PS6u/M8oRpSPSD4zDC2mxzTKJepG7s2WLXSAr5b" +
       "i1naQxSBQ9c40tsmVKLPBA0odFcvfD7c7jRiZTSFxHa7XbwqePnNvSp4qHz1" +
       "cXyuY+1gRcFf3MTbgH3RuT2HlaM3YGfOApx6jVTWfPRor2NYef31jmuUG00/" +
       "8e0ffVYXfqB25XBPYat4WecHX+MYqeGc6uoB0NM7rr9FkCtPq5zs0/u5b/+9" +
       "xybvXD1zE9ve33gO5/ku/zH33C9QX6V95ErltuNde9ecoznb6Kmze/XuDY04" +
       "Cb3JmR17rz/mbLkRtHj//R2HnP2O8y/oTmR38cvvt+1lX5adbNk82Fc4euX1" +
       "0PHrRSpUg5WlRUWrg8fPtTq10fPgrUXyhrhyR1C8jr7wRVPqH74PLrTq4I03" +
       "sxO0yDh47TEbHi4yHwN6/a/3bfffN8OGZy5lQ1h58vp6VO4n32/OfvYfPf6L" +
       "73n28d8q9wffbUWSGrbD5QXnj061+dJzn/viL7/89Z8sjy3cDmaJe0GfP7h1" +
       "7bmsM8etSvj3HTOk2KlReROAfsiQ/fetH4tZhJa+NGACoBxroRXElrfseqkV" +
       "+p4L+nixTt/cyDD5hTq12MbGhVpcvKE8wA/fVx98/SXvq992xiXe6Rjecn+w" +
       "qdhYeoAd7oIs+j93UuAVJ+9yScf3jOK4wtn9DpZ/9fhsHyjML0J68No90nKw" +
       "U970Iv08bXDsJWV8kTDAGLUC156MS6oP8/13/ZI64yKB48rdSyMWj038zJaj" +
       "k+zSwKu3YODlPh8aGPZ/ODTwz7w4Bn53WeHuUrpnxXja2SGdo7Iny7JiZ8jV" +
       "dhyH1iKJDZ1cgaCgAetkYqM8UVNULjeFNY7aPXrcp+kD/Z2ADlh16yfHXPua" +
       "Gz5l0vMPN9yXYnj6EhFZRaLElXv1UM2OtyocvP1EJN94qyJ5KxDF/z4UyR++" +
       "OCK5q6xw15HB7a3umROWHiUHeklkdAkDkiLx4srDpuU4Bc8JVbOXoZ94+jlG" +
       "+LfKiGKTzP37tvvvW2fElWOXdPDMmQM4ZyPQSM3K6dHT2r8Yfv6z37f71HP7" +
       "8zVFJIkr0PUORl97Nrs4ZndJmDt1ZPaPqL/2/O/+N+ldRxOwlx3zolaQ3riM" +
       "F2fdxOERm/IE2MH7SqG95xKBfqBIdnHlgUKjRQC1uJblkbjT0vyWF0Oarzmk" +
       "4DUvgTSL9L3XMu2yIQ/ed8Kij1zCoo8Xyd8GLCp0/vos+tCtsmgKcL71EO9b" +
       "XxwWnRw12tv74MTeS9K+/xKy/2GRfA9YCAClP95MeJrg771VgueVYoK2J/ia" +
       "za9fGcG3nSzGqidUl/Q8dwmtnyySH4yB2YHQa3hH+2hPU/uCe6IvobasBkR6" +
       "++SQ2smLQ+3BSYU9jT9xCY3FnuCDfxpXHgHTC9oPrV1x5MppO9bSM4op4OY4" +
       "Ypf0/titSvddgM53HdL7rpdcuv/uEsp/tkh+Oq68HEiXCJNodbSf97R8n7/V" +
       "xdKbAJ3LQ3qXLw69Jx6upPeQ1F+6hNRfLpJPg1iwLIzWDw39mNbpCa2fuVXZ" +
       "jkunsqd18+LQeupU5OBEFc/MfscrtVyzH5Q9HPz6JXz4fJH86tFa+ZyoX3AX" +
       "9AuRzwCg7z8k//0vumqX07PfOKHz9y6h8/eL5H/ElftKOmUrXgH3dY7c/3mr" +
       "mg0BMj9ySO5HXmzNPtBPNPuPL6H0T4vky3HlNUCzJSOMLe3QeRW+qzzaWbRq" +
       "nJD9h7dA9mNF5tsAud9zSPb33CzZFz8EOkXQlSuXlJUR+8/3ZnzqDHzpCE4o" +
       "/IubOukLVi0n/3lRHOB/9Jr/2dn/N4z2yWcfuPuRZ6e/un9+cvT/LfewlbvN" +
       "xHFOH3s9dX9nEBqmVVJ9z/4QbFCS8jKwxLuhlRgw1vK7QH7l3n3j++PKG1+g" +
       "cQxMxzVPN3oorrz2kkaADyc/Trd7ZVx58Hw7AKr8Pl3vEdDDSb24cuf+5nSV" +
       "xwAqUKW4fW1w5MjwG1uQthdRXCx+T4SV75+3PHpKV/ePjR9+IQU49QD48TPr" +
       "kPKfmI4esSbi4XLnU8/2+W/5cvMH9v+boTnqblf0cjdbuWv/Fx5lp8Vj2jdf" +
       "t7ejvu6k3/5n9//oPU8erWju3wM+sZtT2N548Z9UdN0gLv9WYvcTj/zY1/7g" +
       "s79ZnnL+/6O4KTYiSwAA");
}
