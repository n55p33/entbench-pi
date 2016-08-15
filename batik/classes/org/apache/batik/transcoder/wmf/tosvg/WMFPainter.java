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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "I3wFf8SnK/8PyiiKrD48AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oeKISUzxuyhrzCEcbbblqgZpuyay1ucM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ktoixvNSPpaN7krBBU3eDHe11WTpkYm2nmSeNZvY1GJJYci2VeUbPiZ4Ea4O" +
       "pCXvqCu/qfTdEVhnWsGuDbqjlQYFc21GX9NBo8f5G1vvbthkyeXZFtF31V4S" +
       "enForGo7oQapUHOXdNLqWhZ3UWwo9SEBpvAp59oMQZrVnuxWu7k4b3UjyhGB" +
       "WFF0NDA3UlaNl4E3VefJjmA6Gpgm6nDT1i2wTtOXOlvL0Zm2S9h+g8DRbIfX" +
       "q+uYVn0CZUN8NOSJXRi6SepYBrsQiDzjJhxrORgzille13WH8xa4hGzDUT82" +
       "RzO6KkdrxK6u8xncT3t+g1u1DNybObVwtVX0NZxWCZTX+2xziyaCK80b9hjd" +
       "1FhZVFcjN0qI9ZAjSDGEvA6r29XWct0wlJ3utScjLqnh8UBcaCr4hSF1oxY2" +
       "NbaOrWkPLBnqm6kFTJcQjQAVzJbhNQwibYVx2GUVK5rLUW2oZVnmB9uG5bRV" +
       "tjUJkXGsLi216rUbYt7YWTs0VNtLekqntUmOa5m24qc9u82Om0KOEEac6VmN" +
       "nM46qdBD8lSNsInoBtkagkdgnblRVD3T1lYA0Q2X6lGbkY9sETl3MMIatOOF" +
       "KGwyZwhn1YHX8GweUdJ404uXrFqNESnpdeozh0tGVosUmushDA1thuUiDtgz" +
       "kuGUhCDIVmPVRS/rbScDxGXtRt6Ukqylz4fpAkUie0n04aHnyxTWlvtgWTEY" +
       "yVy/MctR0rKN6jJ3mJ7Wa83DCCY0fImudb+3YkOEtXeDzirr66NhxA3ZBeFK" +
       "rXzTsAhERFQisiaA+MGmXlu32ri8pOs7uzHTt51qEs6XXbYJL8as3OoviY6f" +
       "1HuiSy+WgygNV+uBG8JErWor2xrHcKu2gKcdIK4hjRmQyo/dJRkSWY3wV4uc" +
       "NaRevky3MTefcn5oILOhNNmNmjmj8oLLyKQ37XtS26lWU5DVIKKGW59JAyOt" +
       "N9dLrttBfK9dJ3HSp3iaVqWR2M5rdG8p6PlmQQrjFj4m5JbZyFjSRVt9F4P7" +
       "nSYRs40tAWZaAQiP6Sgdm1WZ4qm5GUhBvK0P4kYadPyWQ23rpBZ3DLBGoJZD" +
       "th9P/XDV7S5RLgXu0MRai10vlwx/3fYwiQ/Mds0i83GrxTTBugdFRTmDzQ6V" +
       "Yis0gmJFJNqdIYpOzaC7ridMP24NjLhjjeYr4FXQPMQRJZDbRObClogz+Wrd" +
       "hONl3KuKtB71FCoIR1G03LATHZ2lWm6O1VoS7NQxzWIY3pDrbIJJYG3SDbpb" +
       "XM1HgmOYPtWB5mjXYslIimUnE5ftpdrbYVsNmcVxnPOh3U1x1lopoTImKb7F" +
       "TLhI8V3XTzmBr6LLdodoKPFmNm5mS4JnQsPV+M1wxkB9hIp2xG4aeZvdLLKM" +
       "qc4YOT+DMMlQlZE+q9Wqs7i/DJrBkgXT8mwSQAQ/zvMUirXYbW3MYZBivGMQ" +
       "2TTqWBzRi/0FXPNRdjhrWKS/kPJRh20xQnva38nATj09ZqpdrQdMPlBwaUlC" +
       "1ciTptxqsSTSCNos+Ajzx3OZHdddt40noex3Z2PAW5XtoSs6HTkZmMPIMyeT" +
       "hru1vAJeIVzgnXzcyD1ttWx7hL5UhK2yxBZMPaV0ggczJWKcm+Yg6KBEq9Uq" +
       "9koevPTmXhU8VL76OD7XYdl4UfDVm3gbsC86t+ewcvQG7MxZgFOvkcqajx7t" +
       "dQwqr73ecY1yo+lHv+fDz6ijH6tdOdxT2Cxe1nn+N9haotmnunoA9PT2628R" +
       "HJanVU726f3K9/zxY7N3GE/fxLb315/Deb7Lfzx89td6X6d86ErltuNde9ec" +
       "oznb6Mmze/XuDbQoDtzZmR17rz3mbLkRtHj//Z5Dzr7n/Au6E9ld/PL7rXvZ" +
       "l2UnWzYP9hWOXnk9dPx6sRdIvmEqYdHq4PFzrU5t9Dx4S5G8Lqrc4Revoy98" +
       "0ZR4h++DC606eP3N7AQtMg5efcyGh4vMx4Be/+t92/33zbDh6UvZEFTefH09" +
       "KveT7zdnP/OPHv+Ndz/z+O+X+4PvNsOFFLSC9QXnj061+eKzn/n8p1762o+V" +
       "xxZul6VwL+jzB7euPZd15rhVCf++Y4YUOzUqbwDQDxmy/771YzFyYKprDWoD" +
       "lLwSmH5kuuuum5iB5zqgjxfq9M2NDJNdqFNyHmkXanHxhvKAOHxfffDNl7yv" +
       "fusZl3inrbnr/cGmYmPpAX64C7Lo/9xJgZedvMslbc/ViuMKZ/c7mN7V47N9" +
       "oDC7COnBq/dIy8FOedOL9PO0wbGXlHFFwgBjVApcezIuqT7J9t/oJXX4IoGi" +
       "yt1rLRofm/iZLUcn2aWBw7dg4OU+HxoY9n84NPBPvDAGfndZ4e5SumfFeNrZ" +
       "IZ2jsjeXZcXOkKutKApMOY40lTRAUFCAdTKRVp6oKSqXm8IaR+0ePe5T94D+" +
       "zkAHrJR78THXvuGGT5lQ3uGG+1IMT10iIrNIxKhyrxpI6fFWhYO3nYjkW29V" +
       "JG8BovhfhyL50xdGJHeVFe46Mri91T19wtKj5EAtiQwvYUBcJG5UeVg3bbvg" +
       "eVtSNuvAi131HCO8W2VEsUnm/n3b/fetM+LKsUs6ePrMAZyzEWgqpeX06Cnl" +
       "X0w++8kf2X382f35miKSRJXq9Q5GX3s2uzhmd0mYO3Vk9s96f+25P/pvi3ce" +
       "TcBecsyLWkF64zJenHUTh0dsyhNgB+8thfbuSwT6/iLZRZUHCo0eA6jFtS6P" +
       "xJ2W5ne8ENJ81SEFr3oRpFmk33Ut0y4b8uC9Jyz60CUs+v4i+duARYXOX59F" +
       "H7hVFs0Bzrcc4n3LC8Oik6NGe3sfnNh7SdqPXkL2PyySHwILAaD0x5sJTxP8" +
       "w7dK8KpSTND2BF+z+fVrI/i2k8UYfEJ1Sc+zl9D6sSL58QiYHQi9mnu0j/Y0" +
       "tc+7J/oSastqQKS3zw6pnb0w1B6cVNjT+HOX0FjsCT74p1HlETC9oL3A3BVH" +
       "ruyWba5drZgCbo8jdknvz9yqdN8J6HznIb3vfNGl++8uofyXi+QXo8pLgXTb" +
       "QRwaR/t5T8v3uVtdLL0B0Lk+pHf9wtB74uFKeg9J/c1LSP1Ukfw6iAXrwmi9" +
       "QFOPaZ2f0PqJW5UtXzqVPa3bF4bWU6ciByeqeGb2yxtSuWY/KHs4+J1L+PDZ" +
       "Ivn00Vr5nKifdxf085HPAKDvOyT/fS+4apfTs989ofOPL6HzT4rkf0SV+0o6" +
       "BTMygPs6R+7/vFXNrgIyP3RI7odeaM0+UE80+8uXUPoXRfKlqPIqoNkLLYhM" +
       "5dB5Fb6rPNpZtGqckP2nt0D2Y0XmWwG5P3RI9g/dLNkXPwQ6RdCVK5eUlRH7" +
       "L/dmfOoMfOkITij86k2d9AWrlpP/vCgO8D96zf/s7P8bRvnYMw/c/cgz80/v" +
       "n58c/X/LPWzlbj227dPHXk/d3+kHmm6WVN+zPwTrl6S8BCzxbmglBoy1/C6Q" +
       "X7l33/j+qPL652kcAdNx9NONHooqr76kEeDDyY/T7V4eVR483w6AKr9P13sE" +
       "9HBSL6rcub85XeUxgApUKW5f7R85MuLGFqQtOYyKxe+JsLL985ZHT+nq/rHx" +
       "w8+nAKceAD9+Zh1S/hPT0SPWeHy43Pn4M33uO76E/dj+fzMUW9rtil7uZit3" +
       "7f/Co+y0eEz7xuv2dtTXnfTbvnL/T9/z5qMVzf17wCd2cwrb6y/+k4qu40fl" +
       "30rsfu6Rn/nGH3/m98pTzv8PdwhTRyJLAAA=");
}
