package org.apache.batik.transcoder.wmf.tosvg;
public class WMFHeaderProperties extends org.apache.batik.transcoder.wmf.tosvg.AbstractWMFReader {
    private static final java.lang.Integer INTEGER_0 = new java.lang.Integer(
      0);
    protected java.io.DataInputStream stream;
    private int _bleft;
    private int _bright;
    private int _btop;
    private int _bbottom;
    private int _bwidth;
    private int _bheight;
    private int _ileft;
    private int _iright;
    private int _itop;
    private int _ibottom;
    private float scale = 1.0F;
    private int startX = 0;
    private int startY = 0;
    private int currentHorizAlign = 0;
    private int currentVertAlign = 0;
    private org.apache.batik.transcoder.wmf.tosvg.WMFFont wf = null;
    private static final java.awt.font.FontRenderContext fontCtx = new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      false,
      true);
    private transient boolean firstEffectivePaint = true;
    public static final int PEN = 1;
    public static final int BRUSH = 2;
    public static final int FONT = 3;
    public static final int NULL_PEN = 4;
    public static final int NULL_BRUSH = 5;
    public static final int PALETTE = 6;
    public static final int OBJ_BITMAP = 7;
    public static final int OBJ_REGION = 8;
    public WMFHeaderProperties(java.io.File wmffile) throws java.io.IOException {
        super(
          );
        reset(
          );
        stream =
          new java.io.DataInputStream(
            new java.io.BufferedInputStream(
              new java.io.FileInputStream(
                wmffile)));
        read(
          stream);
        stream.
          close(
            );
    }
    public WMFHeaderProperties() { super(); }
    public void closeResource() { try { if (stream != null)
                                            stream.
                                              close(
                                                ); }
                                  catch (java.io.IOException e) {
                                      
                                  } }
    public void setFile(java.io.File wmffile) throws java.io.IOException {
        stream =
          new java.io.DataInputStream(
            new java.io.BufferedInputStream(
              new java.io.FileInputStream(
                wmffile)));
        read(
          stream);
        stream.
          close(
            );
    }
    public void reset() { left = 0;
                          right = 0;
                          top = 1000;
                          bottom = 1000;
                          inch = 84;
                          _bleft = -1;
                          _bright = -1;
                          _btop = -1;
                          _bbottom = -1;
                          _ileft = -1;
                          _iright = -1;
                          _itop = -1;
                          _ibottom = -1;
                          _bwidth = -1;
                          _bheight = -1;
                          vpW = -1;
                          vpH = -1;
                          vpX = 0;
                          vpY = 0;
                          startX = 0;
                          startY = 0;
                          scaleXY = 1.0F;
                          firstEffectivePaint = true; }
    public java.io.DataInputStream getStream() { return stream;
    }
    protected boolean readRecords(java.io.DataInputStream is)
          throws java.io.IOException { short functionId =
                                         1;
                                       int recSize = 0;
                                       int gdiIndex;
                                       int brushObject = -1;
                                       int penObject = -1;
                                       int fontObject = -1;
                                       org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj;
                                       while (functionId >
                                                0) { recSize =
                                                       readInt(
                                                         is);
                                                     recSize -=
                                                       3;
                                                     functionId =
                                                       readShort(
                                                         is);
                                                     if (functionId <=
                                                           0)
                                                         break;
                                                     switch (functionId) {
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SETMAPMODE:
                                                             {
                                                                 int mapmode =
                                                                   readShort(
                                                                     is);
                                                                 if (mapmode ==
                                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                                         MM_ANISOTROPIC)
                                                                     isotropic =
                                                                       false;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SETWINDOWORG:
                                                             {
                                                                 vpY =
                                                                   readShort(
                                                                     is);
                                                                 vpX =
                                                                   readShort(
                                                                     is);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SETWINDOWEXT:
                                                             {
                                                                 vpH =
                                                                   readShort(
                                                                     is);
                                                                 vpW =
                                                                   readShort(
                                                                     is);
                                                                 if (!isotropic)
                                                                     scaleXY =
                                                                       (float)
                                                                         vpW /
                                                                         (float)
                                                                           vpH;
                                                                 vpW =
                                                                   (int)
                                                                     (vpW *
                                                                        scaleXY);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEPENINDIRECT:
                                                             {
                                                                 int objIndex =
                                                                   0;
                                                                 int penStyle =
                                                                   readShort(
                                                                     is);
                                                                 readInt(
                                                                   is);
                                                                 int colorref =
                                                                   readInt(
                                                                     is);
                                                                 int red =
                                                                   colorref &
                                                                   255;
                                                                 int green =
                                                                   (colorref &
                                                                      65280) >>
                                                                   8;
                                                                 int blue =
                                                                   (colorref &
                                                                      16711680) >>
                                                                   16;
                                                                 java.awt.Color color =
                                                                   new java.awt.Color(
                                                                   red,
                                                                   green,
                                                                   blue);
                                                                 if (recSize ==
                                                                       6)
                                                                     readShort(
                                                                       is);
                                                                 if (penStyle ==
                                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                                         META_PS_NULL) {
                                                                     objIndex =
                                                                       addObjectAt(
                                                                         NULL_PEN,
                                                                         color,
                                                                         objIndex);
                                                                 }
                                                                 else {
                                                                     objIndex =
                                                                       addObjectAt(
                                                                         PEN,
                                                                         color,
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
                                                                   readShort(
                                                                     is);
                                                                 int colorref =
                                                                   readInt(
                                                                     is);
                                                                 int red =
                                                                   colorref &
                                                                   255;
                                                                 int green =
                                                                   (colorref &
                                                                      65280) >>
                                                                   8;
                                                                 int blue =
                                                                   (colorref &
                                                                      16711680) >>
                                                                   16;
                                                                 java.awt.Color color =
                                                                   new java.awt.Color(
                                                                   red,
                                                                   green,
                                                                   blue);
                                                                 readShort(
                                                                   is);
                                                                 if (brushStyle ==
                                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                                         META_PS_NULL) {
                                                                     objIndex =
                                                                       addObjectAt(
                                                                         NULL_BRUSH,
                                                                         color,
                                                                         objIndex);
                                                                 }
                                                                 else
                                                                     objIndex =
                                                                       addObjectAt(
                                                                         BRUSH,
                                                                         color,
                                                                         objIndex);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SETTEXTALIGN:
                                                             int align =
                                                               readShort(
                                                                 is);
                                                             if (recSize >
                                                                   1)
                                                                 for (int i =
                                                                        1;
                                                                      i <
                                                                        recSize;
                                                                      i++)
                                                                     readShort(
                                                                       is);
                                                             currentHorizAlign =
                                                               org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                                                                 getHorizontalAlignment(
                                                                   align);
                                                             currentVertAlign =
                                                               org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                                                                 getVerticalAlignment(
                                                                   align);
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_EXTTEXTOUT:
                                                             {
                                                                 int y =
                                                                   readShort(
                                                                     is);
                                                                 int x =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int lenText =
                                                                   readShort(
                                                                     is);
                                                                 int flag =
                                                                   readShort(
                                                                     is);
                                                                 int read =
                                                                   4;
                                                                 boolean clipped =
                                                                   false;
                                                                 int x1 =
                                                                   0;
                                                                 int y1 =
                                                                   0;
                                                                 int x2 =
                                                                   0;
                                                                 int y2 =
                                                                   0;
                                                                 int len;
                                                                 if ((flag &
                                                                        org.apache.batik.transcoder.wmf.WMFConstants.
                                                                          ETO_CLIPPED) !=
                                                                       0) {
                                                                     x1 =
                                                                       (int)
                                                                         (readShort(
                                                                            is) *
                                                                            scaleXY);
                                                                     y1 =
                                                                       readShort(
                                                                         is);
                                                                     x2 =
                                                                       (int)
                                                                         (readShort(
                                                                            is) *
                                                                            scaleXY);
                                                                     y2 =
                                                                       readShort(
                                                                         is);
                                                                     read +=
                                                                       4;
                                                                     clipped =
                                                                       true;
                                                                 }
                                                                 byte[] bstr =
                                                                   new byte[lenText];
                                                                 int i =
                                                                   0;
                                                                 for (;
                                                                      i <
                                                                        lenText;
                                                                      i++) {
                                                                     bstr[i] =
                                                                       is.
                                                                         readByte(
                                                                           );
                                                                 }
                                                                 java.lang.String sr =
                                                                   org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                                                                   decodeString(
                                                                     wf,
                                                                     bstr);
                                                                 read +=
                                                                   (lenText +
                                                                      1) /
                                                                     2;
                                                                 if (lenText %
                                                                       2 !=
                                                                       0)
                                                                     is.
                                                                       readByte(
                                                                         );
                                                                 if (read <
                                                                       recSize)
                                                                     for (int j =
                                                                            read;
                                                                          j <
                                                                            recSize;
                                                                          j++)
                                                                         readShort(
                                                                           is);
                                                                 java.awt.font.TextLayout layout =
                                                                   new java.awt.font.TextLayout(
                                                                   sr,
                                                                   wf.
                                                                     font,
                                                                   fontCtx);
                                                                 int lfWidth =
                                                                   (int)
                                                                     layout.
                                                                     getBounds(
                                                                       ).
                                                                     getWidth(
                                                                       );
                                                                 x =
                                                                   (int)
                                                                     layout.
                                                                     getBounds(
                                                                       ).
                                                                     getX(
                                                                       );
                                                                 int lfHeight =
                                                                   (int)
                                                                     getVerticalAlignmentValue(
                                                                       layout,
                                                                       currentVertAlign);
                                                                 resizeBounds(
                                                                   x,
                                                                   y);
                                                                 resizeBounds(
                                                                   x +
                                                                     lfWidth,
                                                                   y +
                                                                     lfHeight);
                                                                 firstEffectivePaint =
                                                                   false;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_DRAWTEXT:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_TEXTOUT:
                                                             {
                                                                 int len =
                                                                   readShort(
                                                                     is);
                                                                 int read =
                                                                   1;
                                                                 byte[] bstr =
                                                                   new byte[len];
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        len;
                                                                      i++) {
                                                                     bstr[i] =
                                                                       is.
                                                                         readByte(
                                                                           );
                                                                 }
                                                                 java.lang.String sr =
                                                                   org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                                                                   decodeString(
                                                                     wf,
                                                                     bstr);
                                                                 if (len %
                                                                       2 !=
                                                                       0)
                                                                     is.
                                                                       readByte(
                                                                         );
                                                                 read +=
                                                                   (len +
                                                                      1) /
                                                                     2;
                                                                 int y =
                                                                   readShort(
                                                                     is);
                                                                 int x =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 read +=
                                                                   2;
                                                                 if (read <
                                                                       recSize)
                                                                     for (int j =
                                                                            read;
                                                                          j <
                                                                            recSize;
                                                                          j++)
                                                                         readShort(
                                                                           is);
                                                                 java.awt.font.TextLayout layout =
                                                                   new java.awt.font.TextLayout(
                                                                   sr,
                                                                   wf.
                                                                     font,
                                                                   fontCtx);
                                                                 int lfWidth =
                                                                   (int)
                                                                     layout.
                                                                     getBounds(
                                                                       ).
                                                                     getWidth(
                                                                       );
                                                                 x =
                                                                   (int)
                                                                     layout.
                                                                     getBounds(
                                                                       ).
                                                                     getX(
                                                                       );
                                                                 int lfHeight =
                                                                   (int)
                                                                     getVerticalAlignmentValue(
                                                                       layout,
                                                                       currentVertAlign);
                                                                 resizeBounds(
                                                                   x,
                                                                   y);
                                                                 resizeBounds(
                                                                   x +
                                                                     lfWidth,
                                                                   y +
                                                                     lfHeight);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEFONTINDIRECT:
                                                             {
                                                                 int lfHeight =
                                                                   readShort(
                                                                     is);
                                                                 float size =
                                                                   (int)
                                                                     (scaleY *
                                                                        lfHeight);
                                                                 int lfWidth =
                                                                   readShort(
                                                                     is);
                                                                 int escape =
                                                                   (int)
                                                                     readShort(
                                                                       is);
                                                                 int orient =
                                                                   (int)
                                                                     readShort(
                                                                       is);
                                                                 int weight =
                                                                   (int)
                                                                     readShort(
                                                                       is);
                                                                 int italic =
                                                                   (int)
                                                                     is.
                                                                     readByte(
                                                                       );
                                                                 int underline =
                                                                   (int)
                                                                     is.
                                                                     readByte(
                                                                       );
                                                                 int strikeOut =
                                                                   (int)
                                                                     is.
                                                                     readByte(
                                                                       );
                                                                 int charset =
                                                                   (int)
                                                                     (is.
                                                                        readByte(
                                                                          ) &
                                                                        255);
                                                                 int lfOutPrecision =
                                                                   is.
                                                                   readByte(
                                                                     );
                                                                 int lfClipPrecision =
                                                                   is.
                                                                   readByte(
                                                                     );
                                                                 int lfQuality =
                                                                   is.
                                                                   readByte(
                                                                     );
                                                                 int lfPitchAndFamily =
                                                                   is.
                                                                   readByte(
                                                                     );
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
                                                                 int len =
                                                                   2 *
                                                                   (recSize -
                                                                      9);
                                                                 byte[] lfFaceName =
                                                                   new byte[len];
                                                                 byte ch;
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        len;
                                                                      i++)
                                                                     lfFaceName[i] =
                                                                       is.
                                                                         readByte(
                                                                           );
                                                                 java.lang.String face =
                                                                   new java.lang.String(
                                                                   lfFaceName);
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
                                                                     FONT,
                                                                     wf,
                                                                     objIndex);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEREGION:
                                                             {
                                                                 int objIndex =
                                                                   0;
                                                                 for (int j =
                                                                        0;
                                                                      j <
                                                                        recSize;
                                                                      j++)
                                                                     readShort(
                                                                       is);
                                                                 objIndex =
                                                                   addObjectAt(
                                                                     PALETTE,
                                                                     INTEGER_0,
                                                                     0);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEPALETTE:
                                                             {
                                                                 int objIndex =
                                                                   0;
                                                                 for (int j =
                                                                        0;
                                                                      j <
                                                                        recSize;
                                                                      j++)
                                                                     readShort(
                                                                       is);
                                                                 objIndex =
                                                                   addObjectAt(
                                                                     OBJ_REGION,
                                                                     INTEGER_0,
                                                                     0);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SELECTOBJECT:
                                                             gdiIndex =
                                                               readShort(
                                                                 is);
                                                             if ((gdiIndex &
                                                                    -2147483648) !=
                                                                   0)
                                                                 break;
                                                             gdiObj =
                                                               getObject(
                                                                 gdiIndex);
                                                             if (!gdiObj.
                                                                    used)
                                                                 break;
                                                             switch (gdiObj.
                                                                       type) {
                                                                 case PEN:
                                                                     penObject =
                                                                       gdiIndex;
                                                                     break;
                                                                 case BRUSH:
                                                                     brushObject =
                                                                       gdiIndex;
                                                                     break;
                                                                 case FONT:
                                                                     {
                                                                         this.
                                                                           wf =
                                                                           (org.apache.batik.transcoder.wmf.tosvg.WMFFont)
                                                                             gdiObj.
                                                                               obj;
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
                                                               readShort(
                                                                 is);
                                                             gdiObj =
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
                                                                META_LINETO:
                                                             {
                                                                 int y =
                                                                   readShort(
                                                                     is);
                                                                 int x =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 if (penObject >=
                                                                       0) {
                                                                     resizeBounds(
                                                                       startX,
                                                                       startY);
                                                                     resizeBounds(
                                                                       x,
                                                                       y);
                                                                     firstEffectivePaint =
                                                                       false;
                                                                 }
                                                                 startX =
                                                                   x;
                                                                 startY =
                                                                   y;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_MOVETO:
                                                             {
                                                                 startY =
                                                                   readShort(
                                                                     is);
                                                                 startX =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_POLYPOLYGON:
                                                             {
                                                                 int count =
                                                                   readShort(
                                                                     is);
                                                                 int[] pts =
                                                                   new int[count];
                                                                 int ptCount =
                                                                   0;
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        count;
                                                                      i++) {
                                                                     pts[i] =
                                                                       readShort(
                                                                         is);
                                                                     ptCount +=
                                                                       pts[i];
                                                                 }
                                                                 int offset =
                                                                   count +
                                                                   1;
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        count;
                                                                      i++) {
                                                                     for (int j =
                                                                            0;
                                                                          j <
                                                                            pts[i];
                                                                          j++) {
                                                                         int x =
                                                                           (int)
                                                                             (readShort(
                                                                                is) *
                                                                                scaleXY);
                                                                         int y =
                                                                           readShort(
                                                                             is);
                                                                         if (brushObject >=
                                                                               0 ||
                                                                               penObject >=
                                                                               0)
                                                                             resizeBounds(
                                                                               x,
                                                                               y);
                                                                     }
                                                                 }
                                                                 firstEffectivePaint =
                                                                   false;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_POLYGON:
                                                             {
                                                                 int count =
                                                                   readShort(
                                                                     is);
                                                                 float[] _xpts =
                                                                   new float[count +
                                                                               1];
                                                                 float[] _ypts =
                                                                   new float[count +
                                                                               1];
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        count;
                                                                      i++) {
                                                                     _xpts[i] =
                                                                       readShort(
                                                                         is) *
                                                                         scaleXY;
                                                                     _ypts[i] =
                                                                       readShort(
                                                                         is);
                                                                 }
                                                                 _xpts[count] =
                                                                   _xpts[0];
                                                                 _ypts[count] =
                                                                   _ypts[0];
                                                                 org.apache.batik.ext.awt.geom.Polygon2D pol =
                                                                   new org.apache.batik.ext.awt.geom.Polygon2D(
                                                                   _xpts,
                                                                   _ypts,
                                                                   count);
                                                                 paint(
                                                                   brushObject,
                                                                   penObject,
                                                                   pol);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_POLYLINE:
                                                             {
                                                                 int count =
                                                                   readShort(
                                                                     is);
                                                                 float[] _xpts =
                                                                   new float[count];
                                                                 float[] _ypts =
                                                                   new float[count];
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        count;
                                                                      i++) {
                                                                     _xpts[i] =
                                                                       readShort(
                                                                         is) *
                                                                         scaleXY;
                                                                     _ypts[i] =
                                                                       readShort(
                                                                         is);
                                                                 }
                                                                 org.apache.batik.ext.awt.geom.Polyline2D pol =
                                                                   new org.apache.batik.ext.awt.geom.Polyline2D(
                                                                   _xpts,
                                                                   _ypts,
                                                                   count);
                                                                 paintWithPen(
                                                                   penObject,
                                                                   pol);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_ELLIPSE:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_INTERSECTCLIPRECT:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_RECTANGLE:
                                                             {
                                                                 int bot =
                                                                   readShort(
                                                                     is);
                                                                 int right =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int top =
                                                                   readShort(
                                                                     is);
                                                                 int left =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 java.awt.geom.Rectangle2D.Float rec =
                                                                   new java.awt.geom.Rectangle2D.Float(
                                                                   left,
                                                                   top,
                                                                   right -
                                                                     left,
                                                                   bot -
                                                                     top);
                                                                 paint(
                                                                   brushObject,
                                                                   penObject,
                                                                   rec);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_ROUNDRECT:
                                                             {
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 int bot =
                                                                   readShort(
                                                                     is);
                                                                 int right =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int top =
                                                                   readShort(
                                                                     is);
                                                                 int left =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 java.awt.geom.Rectangle2D.Float rec =
                                                                   new java.awt.geom.Rectangle2D.Float(
                                                                   left,
                                                                   top,
                                                                   right -
                                                                     left,
                                                                   bot -
                                                                     top);
                                                                 paint(
                                                                   brushObject,
                                                                   penObject,
                                                                   rec);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_ARC:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CHORD:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_PIE:
                                                             {
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 int bot =
                                                                   readShort(
                                                                     is);
                                                                 int right =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int top =
                                                                   readShort(
                                                                     is);
                                                                 int left =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 java.awt.geom.Rectangle2D.Float rec =
                                                                   new java.awt.geom.Rectangle2D.Float(
                                                                   left,
                                                                   top,
                                                                   right -
                                                                     left,
                                                                   bot -
                                                                     top);
                                                                 paint(
                                                                   brushObject,
                                                                   penObject,
                                                                   rec);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_PATBLT:
                                                             {
                                                                 readInt(
                                                                   is);
                                                                 int height =
                                                                   readShort(
                                                                     is);
                                                                 int width =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int left =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int top =
                                                                   readShort(
                                                                     is);
                                                                 if (penObject >=
                                                                       0)
                                                                     resizeBounds(
                                                                       left,
                                                                       top);
                                                                 if (penObject >=
                                                                       0)
                                                                     resizeBounds(
                                                                       left +
                                                                         width,
                                                                       top +
                                                                         height);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_DIBSTRETCHBLT:
                                                             {
                                                                 is.
                                                                   readInt(
                                                                     );
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 float heightDst =
                                                                   (float)
                                                                     readShort(
                                                                       is);
                                                                 float widthDst =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   scaleXY;
                                                                 float dy =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   getVpWFactor(
                                                                     ) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH;
                                                                 float dx =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   getVpWFactor(
                                                                     ) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   scaleXY;
                                                                 widthDst =
                                                                   widthDst *
                                                                     getVpWFactor(
                                                                       ) *
                                                                     (float)
                                                                       inch /
                                                                     PIXEL_PER_INCH;
                                                                 heightDst =
                                                                   heightDst *
                                                                     getVpHFactor(
                                                                       ) *
                                                                     (float)
                                                                       inch /
                                                                     PIXEL_PER_INCH;
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     dx,
                                                                   (int)
                                                                     dy);
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     (dx +
                                                                        widthDst),
                                                                   (int)
                                                                     (dy +
                                                                        heightDst));
                                                                 int len =
                                                                   2 *
                                                                   recSize -
                                                                   20;
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        len;
                                                                      i++)
                                                                     is.
                                                                       readByte(
                                                                         );
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_STRETCHDIB:
                                                             {
                                                                 is.
                                                                   readInt(
                                                                     );
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 float heightDst =
                                                                   (float)
                                                                     readShort(
                                                                       is);
                                                                 float widthDst =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   scaleXY;
                                                                 float dy =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   getVpHFactor(
                                                                     ) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH;
                                                                 float dx =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   getVpHFactor(
                                                                     ) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   scaleXY;
                                                                 widthDst =
                                                                   widthDst *
                                                                     getVpWFactor(
                                                                       ) *
                                                                     (float)
                                                                       inch /
                                                                     PIXEL_PER_INCH;
                                                                 heightDst =
                                                                   heightDst *
                                                                     getVpHFactor(
                                                                       ) *
                                                                     (float)
                                                                       inch /
                                                                     PIXEL_PER_INCH;
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     dx,
                                                                   (int)
                                                                     dy);
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     (dx +
                                                                        widthDst),
                                                                   (int)
                                                                     (dy +
                                                                        heightDst));
                                                                 int len =
                                                                   2 *
                                                                   recSize -
                                                                   22;
                                                                 byte[] bitmap =
                                                                   new byte[len];
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        len;
                                                                      i++)
                                                                     bitmap[i] =
                                                                       is.
                                                                         readByte(
                                                                           );
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_DIBBITBLT:
                                                             {
                                                                 is.
                                                                   readInt(
                                                                     );
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 float height =
                                                                   readShort(
                                                                     is) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   getVpHFactor(
                                                                     );
                                                                 float width =
                                                                   readShort(
                                                                     is) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   getVpWFactor(
                                                                     ) *
                                                                   scaleXY;
                                                                 float dy =
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   getVpHFactor(
                                                                     ) *
                                                                   readShort(
                                                                     is);
                                                                 float dx =
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   getVpWFactor(
                                                                     ) *
                                                                   readShort(
                                                                     is) *
                                                                   scaleXY;
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     dx,
                                                                   (int)
                                                                     dy);
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     (dx +
                                                                        width),
                                                                   (int)
                                                                     (dy +
                                                                        height));
                                                             }
                                                             break;
                                                         default:
                                                             for (int j =
                                                                    0;
                                                                  j <
                                                                    recSize;
                                                                  j++)
                                                                 readShort(
                                                                   is);
                                                             break;
                                                     }
                                       }
                                       if (!isAldus) {
                                           width =
                                             vpW;
                                           height =
                                             vpH;
                                           right =
                                             vpX;
                                           left =
                                             vpX +
                                               vpW;
                                           top =
                                             vpY;
                                           bottom =
                                             vpY +
                                               vpH;
                                       }
                                       resetBounds(
                                         );
                                       return true;
    }
    public int getWidthBoundsPixels() { return _bwidth;
    }
    public int getHeightBoundsPixels() { return _bheight;
    }
    public int getWidthBoundsUnits() { return (int)
                                                ((float)
                                                   inch *
                                                   (float)
                                                     _bwidth /
                                                   PIXEL_PER_INCH);
    }
    public int getHeightBoundsUnits() { return (int)
                                                 ((float)
                                                    inch *
                                                    (float)
                                                      _bheight /
                                                    PIXEL_PER_INCH);
    }
    public int getXOffset() { return _bleft;
    }
    public int getYOffset() { return _btop;
    }
    private void resetBounds() { scale = (float)
                                           getWidthPixels(
                                             ) /
                                           (float)
                                             vpW;
                                 if (_bright !=
                                       -1) {
                                     _bright =
                                       (int)
                                         (scale *
                                            (vpX +
                                               _bright));
                                     _bleft =
                                       (int)
                                         (scale *
                                            (vpX +
                                               _bleft));
                                     _bbottom =
                                       (int)
                                         (scale *
                                            (vpY +
                                               _bbottom));
                                     _btop =
                                       (int)
                                         (scale *
                                            (vpY +
                                               _btop));
                                 }
                                 if (_iright !=
                                       -1) {
                                     _iright =
                                       (int)
                                         ((float)
                                            _iright *
                                            (float)
                                              getWidthPixels(
                                                ) /
                                            (float)
                                              width);
                                     _ileft =
                                       (int)
                                         ((float)
                                            _ileft *
                                            (float)
                                              getWidthPixels(
                                                ) /
                                            (float)
                                              width);
                                     _ibottom =
                                       (int)
                                         ((float)
                                            _ibottom *
                                            (float)
                                              getWidthPixels(
                                                ) /
                                            (float)
                                              width);
                                     _itop =
                                       (int)
                                         ((float)
                                            _itop *
                                            (float)
                                              getWidthPixels(
                                                ) /
                                            (float)
                                              width);
                                     if (_bright ==
                                           -1 ||
                                           _iright >
                                           _bright)
                                         _bright =
                                           _iright;
                                     if (_bleft ==
                                           -1 ||
                                           _ileft <
                                           _bleft)
                                         _bleft =
                                           _ileft;
                                     if (_btop ==
                                           -1 ||
                                           _itop <
                                           _btop)
                                         _btop =
                                           _itop;
                                     if (_bbottom ==
                                           -1 ||
                                           _ibottom >
                                           _bbottom)
                                         _bbottom =
                                           _ibottom;
                                 }
                                 if (_bleft !=
                                       -1 &&
                                       _bright !=
                                       -1)
                                     _bwidth =
                                       _bright -
                                         _bleft;
                                 if (_btop !=
                                       -1 &&
                                       _bbottom !=
                                       -1)
                                     _bheight =
                                       _bbottom -
                                         _btop;
    }
    private void resizeBounds(int x, int y) {
        if (_bleft ==
              -1)
            _bleft =
              x;
        else
            if (x <
                  _bleft)
                _bleft =
                  x;
        if (_bright ==
              -1)
            _bright =
              x;
        else
            if (x >
                  _bright)
                _bright =
                  x;
        if (_btop ==
              -1)
            _btop =
              y;
        else
            if (y <
                  _btop)
                _btop =
                  y;
        if (_bbottom ==
              -1)
            _bbottom =
              y;
        else
            if (y >
                  _bbottom)
                _bbottom =
                  y;
    }
    private void resizeImageBounds(int x,
                                   int y) {
        if (_ileft ==
              -1)
            _ileft =
              x;
        else
            if (x <
                  _ileft)
                _ileft =
                  x;
        if (_iright ==
              -1)
            _iright =
              x;
        else
            if (x >
                  _iright)
                _iright =
                  x;
        if (_itop ==
              -1)
            _itop =
              y;
        else
            if (y <
                  _itop)
                _itop =
                  y;
        if (_ibottom ==
              -1)
            _ibottom =
              y;
        else
            if (y >
                  _ibottom)
                _ibottom =
                  y;
    }
    private java.awt.Color getColorFromObject(int brushObject) {
        java.awt.Color color =
          null;
        if (brushObject >=
              0) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj =
              getObject(
                brushObject);
            return (java.awt.Color)
                     gdiObj.
                       obj;
        }
        else
            return null;
    }
    private void paint(int brushObject, int penObject,
                       java.awt.Shape shape) {
        if (brushObject >=
              0 ||
              penObject >=
              0) {
            java.awt.Color col;
            if (brushObject >=
                  0)
                col =
                  getColorFromObject(
                    brushObject);
            else
                col =
                  getColorFromObject(
                    penObject);
            if (!(firstEffectivePaint &&
                    col.
                    equals(
                      java.awt.Color.
                        white))) {
                java.awt.Rectangle rec =
                  shape.
                  getBounds(
                    );
                resizeBounds(
                  (int)
                    rec.
                    getMinX(
                      ),
                  (int)
                    rec.
                    getMinY(
                      ));
                resizeBounds(
                  (int)
                    rec.
                    getMaxX(
                      ),
                  (int)
                    rec.
                    getMaxY(
                      ));
                firstEffectivePaint =
                  false;
            }
        }
    }
    private void paintWithPen(int penObject,
                              java.awt.Shape shape) {
        if (penObject >=
              0) {
            java.awt.Color col =
              getColorFromObject(
                penObject);
            if (!(firstEffectivePaint &&
                    col.
                    equals(
                      java.awt.Color.
                        white))) {
                java.awt.Rectangle rec =
                  shape.
                  getBounds(
                    );
                resizeBounds(
                  (int)
                    rec.
                    getMinX(
                      ),
                  (int)
                    rec.
                    getMinY(
                      ));
                resizeBounds(
                  (int)
                    rec.
                    getMaxX(
                      ),
                  (int)
                    rec.
                    getMaxY(
                      ));
                firstEffectivePaint =
                  false;
            }
        }
    }
    private float getVerticalAlignmentValue(java.awt.font.TextLayout layout,
                                            int vertAlign) {
        if (vertAlign ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BASELINE)
            return -layout.
              getAscent(
                );
        else
            if (vertAlign ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    TA_TOP)
                return layout.
                  getAscent(
                    ) +
                  layout.
                  getDescent(
                    );
            else
                return 0;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bC5AcxXnu3XvqHrrTCb3R+0SQgF1JIECceNyd7qQTe4+6" +
       "OwlxQqxmZ3v3RpqdGc303u0dViIoW8i4jAmWMHaw4gqiwAQsijJJ7NiUEsrG" +
       "lLGNjWLHdsA2ThUYQgKVWKSiOM7/9/Tu7M7uzN1eeX1V0zs33X////f133+/" +
       "Zp55n9RYJllFNRZiUwa1Qj0aG5JMi8a7VcmyRuFZVP5clfSfd78zsD1IasfI" +
       "/HHJ6pcli/YqVI1bY2SlollM0mRqDVAaR4khk1rUnJCYomtjZJFi9aUMVZEV" +
       "1q/HKRbYJ5kRskBizFRiaUb7RAWMrIyAJWFuSbjTnd0RIU2ybkw5xZfmFe/O" +
       "y8GSKUeXxUhr5LA0IYXTTFHDEcViHRmTXGXo6lRS1VmIZljosLpNULAnsq2I" +
       "gnXPtVy89NB4K6dgoaRpOuPwrGFq6eoEjUdIi/O0R6Up6yj5U1IVIY15hRlp" +
       "j2SVhkFpGJRm0TqlwPpmqqVT3TqHw7I11RoyGsTI2sJKDMmUUqKaIW4z1FDP" +
       "BHYuDGjX5NDaKIsgnr4qfOpzd7c+X0VaxkiLoo2gOTIYwUDJGBBKUzFqWp3x" +
       "OI2PkQUaNPYINRVJVaZFS7dZSlKTWBqaP0sLPkwb1OQ6Ha6gHQGbmZaZbubg" +
       "JbhDif9qEqqUBKyLHaw2wl58DgAbFDDMTEjgd0Kk+oiixRlZ7ZbIYWy/HQqA" +
       "aF2KsnE9p6pak+ABabNdRJW0ZHgEXE9LQtEaHRzQZGS5Z6XItSHJR6QkjaJH" +
       "usoN2VlQah4nAkUYWeQuxmuCVlruaqW89nl/YMeD92i7tSAJgM1xKqtofyMI" +
       "rXIJDdMENSn0A1uwaVPkEWnxN08GCYHCi1yF7TJ/+7EPb7t61fnv2GVWlCgz" +
       "GDtMZRaVz8bm//Dy7o3bq9CMekO3FGz8AuS8lw2JnI6MARFmca5GzAxlM88P" +
       "f/vO40/T94KkoY/UyrqaToEfLZD1lKGo1NxFNWpKjMb7yDyqxbt5fh+pg/uI" +
       "olH76WAiYVHWR6pV/qhW5/8DRQmoAilqgHtFS+jZe0Ni4/w+YxBC6uAiTXCF" +
       "iP3HfxlRw+N6ioYlWdIUTQ8PmTrit8IQcWLA7Xg4Bl5/JGzpaRNcMKybybAE" +
       "fjBORQYzJc2SIQiZ4clUIsx0ayIZvqO/dzeV4BlUh71CAXLR64w/sr4M4l84" +
       "GQhA01zuDgwq9KndugpSUflUuqvnw69Ev2s7HXYUwRwj28GEkG1CiJsQckwI" +
       "gQkhbkKohAkkEOCaL0NTbIeA5jwCgQEic9PGkYN7Dp1cVwWeaExWQ1sEoei6" +
       "ghGq24ke2ZAflc+1NU+vfXPLS0FSHSFtkszSkooDTqeZhFAmHxG9vSkGY5cz" +
       "hKzJG0Jw7DN1mcYhgnkNJaKWen2CmvickcvyasgOcNiVw97DS0n7yflHJ+/d" +
       "92ebgyRYOGqgyhoIeCg+hLE+F9Pb3dGiVL0t979z8dwjx3QnbhQMQ9nRs0gS" +
       "Maxz+4abnqi8aY30QvSbx9o57fMgrjMJ+iGEzFVuHQVhqSMb4hFLPQBO6GZK" +
       "UjEry3EDGzf1SecJd9oF/P4ycItG7Ker4NojOi7/xdzFBqZLbCdHP3Oh4EPI" +
       "zSPGF//5+7+5ltOdHW1a8qYJI5R15EU4rKyNx7IFjtuOmpRCuTceHfrs6ffv" +
       "P8B9FkqsL6WwHdNuiGzQhEDzJ75z9Ke/ePPshWDOzwMMhvh0DGZKmRxIfE4a" +
       "fECCtisceyBCqhA10Gva92rgn0pCkWIqxY71vy0btrzwbw+22n6gwpOsG109" +
       "cwXO82Vd5Ph37/5oFa8mIOMI7XDmFLPD/kKn5k7TlKbQjsy9P1r5+ZelL8IA" +
       "AkHbUqYpj8MBmwOOfCkjTVxS0UO9EMV5S27jWZt5el2xwMKsQN9gT0amBhrB" +
       "5bZjssHK7y2FHTJv6hWVH7rwQfO+D178kMMrnLvlO0e/ZHTY/ojJFRmofok7" +
       "mu2WrHEod935gbta1fOXoMYxqFGG6G0NmhAQMwWuJErX1P3sH15afOiHVSTY" +
       "SxpUXYr3SrxXknnQHag1DoE5Y9x6m+0Nk/WQtOJdhuSIIZwYkil6gC2yunRb" +
       "96QMxltn+u+WfHXHk2fe5G5p8CpWFne5UeGNo6W7HKZ/gslVxY7sJepq3azN" +
       "+P/tPnn9mPTyrB2Y7LJh3zpHhvBBj2FnrOAPL8chsmD04QsfJwA+/foN//Tk" +
       "nz8yaU+dNnpHfZfc0v8ZVGP3vfXfRZ7G432JaZ1Lfiz8zGPLu295j8s7gRel" +
       "2zPFwzoMXo7s1qdTvw2uq/1WkNSNkVZZLDT2SWoaw9kYTK6t7OoDFiMF+YUT" +
       "ZXtW2JEbWC53B/08te6Q70wn4B5L432zK8ovw3a5Ba7Nwm82u10uQPjNnbbX" +
       "8XQTJtfw5qtipM4wFViMguW1Fl/TMLBD0STVFWaX+mhhZF7fwGjPrp7h6OZs" +
       "xLE7L9IQ6oO1SNLmfqHji2Mz+eJIzoD5+HQDXFuFAVs9YCZKw4SxY55h6gwa" +
       "g8ZduJp9quWcmFTMKQDUkmwY3SkxqU8z0myE57ugJWcPDefWZCdc1wobrvWA" +
       "dtQDGt4edGFq9KkPMEVhyEqwwnkjzs1G0jEL5nhKCob0CbE82jp0SD7ZPvSv" +
       "dv9dVkLALrfoqfCn9/3k8Kt8wlCPs8jRrM/mzRFhtpk3W2m1rf49/AXg+j+8" +
       "0Fp8gL/QmbrFWmdNbrFjGDic+AQSF4DwsbZfHHnsnWdtAO6o4SpMT5564Peh" +
       "B0/ZswB7xby+aNGaL2Ovmm04mEyjdWv9tHCJ3rfPHfv7p47db1vVVrj+69HS" +
       "qWd//LtXQ4/+8pUSS4sqRex65I/zMI8rbBsb0M5PtnzjobaqXph/9pH6tKYc" +
       "TdO+eGF0qbPSsbzGclbiTsQR0LBhGAlsgjZwebxZAY9/ABOYWdRFY6aSHOcT" +
       "simX3k9VQO9nhN6aaIzpRimtD1VA6ymhtT4ai+mM6alSik9XQPHnHZonlbi9" +
       "+Hfr/UIF9J5xAI9Tr/b9yzIVb4HrOqH4Og/FjzszMFYcN72kMW4qGDdLmXm2" +
       "AmY+jckT2C6Kp/v/dQX0nhN6a6KKh/s/VwGtXxVa66OKt/u/UKbi1XBtE4q3" +
       "eSj+mq83eEkDPZYsqfbae1IEfvz5WN79cZxKwSKlKFrjvyfcIfTrZYJbAdf1" +
       "wrzrPcB9yxecl7Q9FTTZ/lJt8O05mHmDUHSDh5mv+prpJZ01885SZn6vTDOv" +
       "gOtGoehGDzNf9zXTSxqmwnLaNGF03q2bynSnqiS1UhZfKNNinA9vFzq3e1j8" +
       "M1+LvaQZLHpsi/dRk3ka/PMyDcal8U1C5U0eBv/K12AvaUaCk4nsHP2aWe+8" +
       "9sKq0IXprdlj4muvXrh2CKs6PDC967H2wtuDmNyNSbTEeqvDo2YYFBJgezfL" +
       "ZEHbGxfSJAthRgiRDVMNEIsTKhfM92YPc3HWQ24WxtzsAfO/SsMMcpiwAOOt" +
       "oIBTuYAu8qmbkYUJxbRYTyKBezETdEjKTn59gm5dTNdVKmmzCru/nT0V2CSk" +
       "ndgrbpL9LaAikNsBzV/5tr31pbMf3Xv/jUHc1KuZwI0CmPW3OuUG0nh6eOKZ" +
       "0ysbT/3yU3x3SRgcCPp4T8jTe5b4WAkriKGegRI9OlBVJhcYNG8VWm4twQXW" +
       "mfWBQPOcgXipgOG1a3jvyO5SUOaXCQWjqShq/3pAQXMDi+cMxUsFI9W9gwOj" +
       "pZAsKRPJRrg6hZpOHyTVeLN6zki8VMAUbmBvJBL1cLE1ZaK5Cq4uoarLB00N" +
       "3lw5ZzReKhhp4Gg8/WxjmXiuhKtbKOv2wVOLN1vmjMdLBQTHoc5Iz+hoTykw" +
       "W+fQODuFpp0+YOrw5qY5g/FSAY0z2LUn2tU32t85VApPxxzw9AhlPT546vGm" +
       "e854vFQIPMM9u/oGS3aenT54Ms7MyTlX4H+1xHV8n6eSl1yR3fA3yUqvNyz4" +
       "rtXZ+06diQ8+sSUojhfuxWFdN65R6QRV86pqw5oKTgX6+Tslzhb7G/Mf/vXX" +
       "2pNd5RxH47NVMxw44/+rYWzd5L0/6Dbl5fveXT56y/ihMk6WV7tYclf55f5n" +
       "Xtl1hfxwkL9AY+/9F714UyjUUbgn12BSlja1wl249bl25UdNuLrdL9p1v9tb" +
       "Hc/xOmryEuUlSx4nBe7yyUNvD9zBSLOs6hbFl5n4qxhY1DU9q57Qlbjj1Pv/" +
       "EGdSvGuOFPKDQ7okQErl8+Ml6uIgb255PSdC9S5wEy+Ai6lAEiKxRVmv/RZO" +
       "4JDDx3il+MDQc1iAOlw+H16iPj4x5ZN3DyYMpnD4OiRzcZCuAAe4EcFn7ycE" +
       "kBPlc+Al6oPzhE/eSUwwiCZp3kFSyuHhvgrwwBd0a+F6QIB5YAYelEIemn1E" +
       "vV0/xQF/dqa+cRqTBxlpBDLiw1TWTTtSXHI4+UwFOGnBvPWwUDlo12n/luUb" +
       "nqI+7f8ln7y/wuQvGLkMfOMO3Jfv0tNa3BpSMmKonXIoeaxSlEB3CcYFrnj5" +
       "lHiJ+sB+1icPd6YDTzGyCCjZzY8MfDj5cqU4WQeAjghgR8rnxEvUB/fXffK+" +
       "gckLjCwsdJO9msLcjPxNJTuOKWCZ5TPiJeqD+mWfvFcw+Ue74+R7SSlKXqoU" +
       "JcsAz5TANVU+JV6iPrAv+OT9GJMfwPICKNlvvxHsIuK1ShJxXKA5Xj4RXqI+" +
       "YH/lk/drTP7FJuLOkkS8UQEisrvfwY8LNB+fgYjirW9PUR+w/+6T9wEmv+Hj" +
       "LHBgd5CjhXOwdyvFBKyyg48LOI+Xz4SXqAtt0Nl95svoKY77kg8nv8PkIiNN" +
       "wIkyTUuS8lGlSNkMtj4vkD1fPileorMhJVjvTUqwAZMqRhbYpPSlpGRJZoLV" +
       "FWCmDfNwDnJewDtfPjNeot4zUZuURT6kLMGklZE2CCPduqqbvaaesl/24+WX" +
       "MjI/dyDDCzg8LaiUB3UDyNcE2NfK58lL1EVDlbPJNeWEzgLAI+OSwV9KDrb7" +
       "cHglJqth/WfgkY7LmWbcJZ4rSdsB4dsC6dvlk+Ql6t/Nghs44mt92NiGSQhi" +
       "D2fjDoWND1HNRUq4Uj0MA/JFgexi+aR4iZYmJesvSwtPLEdphkWkKT3NnC54" +
       "mw9hOzHpYGQZdEE8pVZkSeUn1SkqXsVFqRcd9nb8QV59hol2iU928NXxpUVf" +
       "ENpfvclfOdNSv+TM3p/wrc7cl2lNEVKfSKtq/lu+efe1hkkTCie/yX7nl79y" +
       "F4wwsmFW59vQsfgvIgnebgsPMrJ6BmEGHTyVyBcaZmSFjxDMpZx/8uX2MtLq" +
       "lgOj+G9+uf1Qg1OOkVr7Jr/IAbAKiuDtXUbWf26Y3TF/Z8yC5zKDVhvmrZax" +
       "v4lYkd/S/CB40UwOkrdNvr5ge5l/YprdCk7bH5lG5XNn9gzc8+H1T9if0Miq" +
       "ND2NtTRG8PAev+bhleJ28lrP2rJ11e7eeGn+c/M2ZDfeF9gGO31zhdM18Fgh" +
       "YKBLLnd9X2K15z4z+enZHS9+72Ttj4IkcIAEJHDrA8XvrWeMtElWHogUv1i6" +
       "TzL5hy8dG78wdcvVif/4ee7IuvB7AHf5qHzhyYOvP7z07KogaewjNYoWpxn+" +
       "Qv3OKW2YyhPmGGlWrJ4MmAi1KJJa8NbqfOw9En58ynkRdDbnnuIHWIysK35h" +
       "t/iztQZVn6Qmn8lgNc0R0ug8sVvGtSOfNgyXgPNENCWmn8BkOoOtAW4bjfQb" +
       "RvZ95qZqg8eRE6VmHfzFhCD/DPME3hn/D+B0Gp5+PgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gdodhUs6S4Zg+/iw7lnDdmg3ipRdW3Z1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "5P8BotLbOeBMAAA=");
}
