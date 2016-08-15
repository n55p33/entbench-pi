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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bC5AcxXnu3XvqHrrTCb3R+0SQgF1JIECceNyd9qQTe4+6" +
       "OwlxQqxmZ3vvRpqdGc303u0dViIoWyi4ggmWMHaw4gqiwAQsijLxIzalmLIx" +
       "Zexgo9ixHbCNUwFDSKASi1QUx/n/nt6d3dmdudsrb65qeuem++///77+++/X" +
       "zDPvkxrLJKuoxkJsyqBWKKKxQcm0aKJblSxrBJ7F5M9USf9x9zv924OkdpTM" +
       "H5esPlmyaI9C1YQ1SlYqmsUkTaZWP6UJlBg0qUXNCYkpujZKFilWb8pQFVlh" +
       "fXqCYoF9khklCyTGTCWeZrRXVMDIyihYEuaWhDvd2R1R0iTrxpRTfGle8e68" +
       "HCyZcnRZjLRGD0sTUjjNFDUcVSzWkTHJVYauTo2pOgvRDAsdVrcJCvZEtxVR" +
       "sO65louXHhpv5RQslDRNZxyeNUQtXZ2giShpcZ5GVJqyjpI/JlVR0phXmJH2" +
       "aFZpGJSGQWkWrVMKrG+mWjrVrXM4LFtTrSGjQYysLazEkEwpJaoZ5DZDDfVM" +
       "YOfCgHZNDq2Nsgji6avCpz5zd+vzVaRllLQo2jCaI4MRDJSMAqE0Faem1ZlI" +
       "0MQoWaBBYw9TU5FUZVq0dJuljGkSS0PzZ2nBh2mDmlynwxW0I2Az0zLTzRy8" +
       "JHco8V9NUpXGAOtiB6uNsAefA8AGBQwzkxL4nRCpPqJoCUZWuyVyGNtvhwIg" +
       "WpeibFzPqarWJHhA2mwXUSVtLDwMrqeNQdEaHRzQZGS5Z6XItSHJR6QxGkOP" +
       "dJUbtLOg1DxOBIowsshdjNcErbTc1Up57fN+/44H79F2a0ESAJsTVFbR/kYQ" +
       "WuUSGqJJalLoB7Zg06boI9Lib54MEgKFF7kK22W+8rEPb7t61fnv2mVWlCgz" +
       "ED9MZRaTz8bn//Dy7o3bq9CMekO3FGz8AuS8lw2KnI6MARFmca5GzAxlM88P" +
       "fefO40/T94KkoZfUyrqaToEfLZD1lKGo1NxFNWpKjCZ6yTyqJbp5fi+pg/uo" +
       "olH76UAyaVHWS6pV/qhW5/8DRUmoAilqgHtFS+rZe0Ni4/w+YxBC6uAiTXCF" +
       "iP3HfxlRw+N6ioYlWdIUTQ8Pmjrit8IQceLA7Xg4Dl5/JGzpaRNcMKybY2EJ" +
       "/GCcigxmSpolQxAyw5OpZJjp1sRY+I6+nt1UgmdQHfYKBchFrzP+n/VlEP/C" +
       "yUAAmuZyd2BQoU/t1lWQismn0l2RD78U+57tdNhRBHOMbAcTQrYJIW5CyDEh" +
       "BCaEuAmhEiaQQIBrvgxNsR0CmvMIBAaIzE0bhw/uOXRyXRV4ojFZDW0RhKLr" +
       "Ckaobid6ZEN+TD7X1jy99s0tLwVJdZS0STJLSyoOOJ3mGIQy+Yjo7U1xGLuc" +
       "IWRN3hCCY5+pyzQBEcxrKBG11OsT1MTnjFyWV0N2gMOuHPYeXkraT84/Onnv" +
       "vj/ZHCTBwlEDVdZAwEPxQYz1uZje7o4Wpeptuf+di+ceOaY7caNgGMqOnkWS" +
       "iGGd2zfc9MTkTWukF2LfPNbOaZ8HcZ1J0A8hZK5y6ygISx3ZEI9Y6gFwUjdT" +
       "kopZWY4b2LipTzpPuNMu4PeXgVs0Yj9dBdce0XH5L+YuNjBdYjs5+pkLBR9C" +
       "bh42Pv+PP/jNtZzu7GjTkjdNGKasIy/CYWVtPJYtcNx2xKQUyr3x6OCnT79/" +
       "/wHus1BifSmF7Zh2Q2SDJgSaP/Hdoz/9xZtnLwRzfh5gMMSn4zBTyuRA4nPS" +
       "4AMStF3h2AMRUoWogV7TvlcD/1SSihRXKXas/2nZsOWFf32w1fYDFZ5k3ejq" +
       "mStwni/rIse/d/dHq3g1ARlHaIczp5gd9hc6NXeapjSFdmTu/dHKz74sfR4G" +
       "EAjaljJNeRwO2Bxw5EsZaeKSih7qgSjOW3Ibz9rM0+uKBRZmBXoHIhmZGmgE" +
       "l9uOyQYrv7cUdsi8qVdMfujCB837PnjxQw6vcO6W7xx9ktFh+yMmV2Sg+iXu" +
       "aLZbssah3HXn++9qVc9fghpHoUYZorc1YEJAzBS4kihdU/ezv3tp8aEfVpFg" +
       "D2lQdSnRI/FeSeZBd6DWOATmjHHrbbY3TNZD0op3GZIjhnBiSKboAbbI6tJt" +
       "HUkZjLfO9FeXfHnHk2fe5G5p8CpWFne5EeGNI6W7HKZ/hMlVxY7sJepq3azN" +
       "+P/tPnl9mPTwrB2Y7LJh3zpHhvBBxLAzVvCHl+MQWTD68IWPEwCffv2Gf3jy" +
       "zx+ZtKdOG72jvktu6X8PqPH73vqvIk/j8b7EtM4lPxp+5rHl3be8x+WdwIvS" +
       "7ZniYR0GL0d269Op3wbX1X47SOpGSassFhr7JDWN4WwUJtdWdvUBi5GC/MKJ" +
       "sj0r7MgNLJe7g36eWnfId6YTcI+l8b7ZFeWXYbvcAtdm4Teb3S4XIPzmTtvr" +
       "eLoJk2t481UxUmeYCixGwfJai69pGNihaJLqCrNLfbQwMq+3fySyKzIU25yN" +
       "OHbnRRpCvbAWGbO5X+j44uhMvjicM2A+Pt0A11ZhwFYPmMnSMGHsmGeYOoPG" +
       "oAkXrmafajknJhVzCgC1JBtGd0pM6tWMNBvm+S5oY7OHhnNrshOua4UN13pA" +
       "O+oBDW8PujA1+tQHmGIwZCVZ4bwR52bD6bgFczwlBUP6hFgebR08JJ9sH/xn" +
       "u/8uKyFgl1v0VPjP9v3k8Kt8wlCPs8iRrM/mzRFhtpk3W2m1rf49/AXg+l+8" +
       "0Fp8gL/QmbrFWmdNbrFjGDic+AQSF4DwsbZfHHnsnWdtAO6o4SpMT5564Peh" +
       "B0/ZswB7xby+aNGaL2Ovmm04mEyjdWv9tHCJnrfPHfvbp47db1vVVrj+i2jp" +
       "1LM//t2roUd/+UqJpUWVInY98sd5mMcVto0NaOeftnzjobaqHph/9pL6tKYc" +
       "TdPeRGF0qbPS8bzGclbiTsQR0LBhGAlsgjZwebxZAY9/ABOYWdTF4qYyNs4n" +
       "ZFMuvZ+sgN5PCb01sTjTjVJaH6qA1lNCa30sHtcZ01OlFJ+ugOLPOjRPKgl7" +
       "8e/W+7kK6D3jAB6nXu37l2Uq3gLXdULxdR6KH3dmYKw4bnpJY9xUMG6WMvNs" +
       "Bcx8GpMnsF0UT/f/6wroPSf01sQUD/d/rgJavyy01scUb/d/oUzFq+HaJhRv" +
       "81D8NV9v8JIGeixZUu2196QI/Pjzsbz74ziVgkVKUbTGf0+4Q+jXywS3Aq7r" +
       "hXnXe4D7ti84L2l7Kmiy/aXa4DtzMPMGoegGDzNf9TXTSzpr5p2lzPx+mWZe" +
       "AdeNQtGNHma+7mumlzRMheW0acLovFs3lelOVRnTSll8oUyLcT68Xejc7mHx" +
       "z3wt9pJmsOixLd5HTeZp8M/LNBiXxjcJlTd5GPwrX4O9pBkJTiazc/RrZr3z" +
       "2gOrQhemt2aPia+9euDaIazq8MD0rsfaC28PYnI3JrES660Oj5phUEiC7d0s" +
       "kwVtb1xIkyyEGSFENkQ1QCxOqFww35s9zMVZD7lZGHOzB8z/LA0zyGHCAoy3" +
       "ggJO5QK6yKduRhYmFdNikWQS92Im6KCUnfz6BN26uK6rVNJmFXZ/O3sqsElI" +
       "O7FX3CT7W0BFILcDmr/ybXvrC2c/uvf+G4O4qVczgRsFMOtvdcr1p/H08MQz" +
       "p1c2nvrlJ/nukjA4EPTxnpCn9yzxsRJWEIOR/hI9OlBVJhcYNG8VWm4twQXW" +
       "mfWBQPOcgXipgOG1a2jv8O5SUOaXCQWjqShq/3pAQXMDi+cMxUsFI9U9A/0j" +
       "pZAsKRPJRrg6hZpOHyTVeLN6zki8VMAUrn9vNBrzcLE1ZaK5Cq4uoarLB00N" +
       "3lw5ZzReKhhp4Gg8/WxjmXiuhKtbKOv2wVOLN1vmjMdLBQTHwc5oZGQkUgrM" +
       "1jk0zk6haacPmDq8uWnOYLxUQOMMdO2JdfWO9HUOlsLTMQc8EaEs4oOnHm+6" +
       "54zHS4XAMxTZ1TtQsvPs9MGTcWZOzrkC/6slruP7PJW85Irshr9JVnq9YcF3" +
       "rc7ed+pMYuCJLUFxvHAvDuu6cY1KJ6iaV1Ub1lRwKtDH3ylxttjfmP/wr7/W" +
       "PtZVznE0Pls1w4Ez/r8axtZN3vuDblNevu/d5SO3jB8q42R5tYsld5Vf7Hvm" +
       "lV1XyA8H+Qs09t5/0Ys3hUIdhXtyDSZlaVMr3IVbn2tXftSEq9v9ol33u73V" +
       "8RyvoyYvUV6y5HFS4C6fPPT2wB2MNMuqblF8mYm/ioFFXdOz6gldSThOvf8P" +
       "cSbFu+ZwIT84pEsCpFQ+P16iLg7y5pbXcyJU7wI38QK4mAqMQSS2KOux38IJ" +
       "HHL4GK8UHxh6DgtQh8vnw0vUxyemfPLuwYTBFA5fh2QuDtIV4AA3Ivjs/YQA" +
       "cqJ8DrxEfXCe8Mk7iQkG0TGad5CUcni4rwI88AXdWrgeEGAemIEHpZCHZh9R" +
       "b9dPccCfnqlvnMbkQUYagYzEEJV1044UlxxOPlUBTlowbz0sVA7addq/ZfmG" +
       "p6hP+3/BJ++vMPkLRi4D37gD9+W79LSWsAaVjBhqpxxKHqsUJdBdggmBK1E+" +
       "JV6iPrCf9cnDnenAU4wsAkp28yMDH06+WClO1gGgIwLYkfI58RL1wf11n7xv" +
       "YPICIwsL3WSvpjA3I39TyY5jClhm+Yx4ifqgftkn7xVMvmV3nHwvKUXJS5Wi" +
       "ZBngmRK4psqnxEvUB/YFn7wfY/L3sLwASvbbbwS7iHitkkQcF2iOl0+El6gP" +
       "2F/55P0ak3+yibizJBFvVICI7O538OMCzcdnIKJ469tT1Afsv/nkfYDJb/g4" +
       "CxzYHeRo4Rzs3UoxAavs4OMCzuPlM+El6kIbdHaf+TJ6iuO+5MPJ7zC5yEgT" +
       "cKJM05KkfFQpUjaDrc8LZM+XT4qX6GxICdZ7kxJswKSKkQU2Kb0paawkM8Hq" +
       "CjDThnk4Bzkv4J0vnxkvUe+ZqE3KIh9SlmDSykgbhJFuXdXNHlNP2S/78fJL" +
       "GZmfO5DhBRyeFlTKg7oB5GsC7Gvl8+Ql6qKhytnkmnJCZwHg4XHJ4C8lB9t9" +
       "OLwSk9Ww/jPwSMflTDPuEs+VpO2A8G2B9O3ySfIS9e9mwQ0c8bU+bGzDJASx" +
       "h7Nxh8LGB6nmIiVcqR6GAfmiQHaxfFK8REuTkvWXpYUnliM0w6LSlJ5mThe8" +
       "zYewnZh0MLIMuiCeUiuypPKT6hQVr+Ki1IsOezv+IK8+w0S7xCc7+Or40qIv" +
       "CO2v3uQvnWmpX3Jm70/4Vmfuy7SmKKlPplU1/y3fvPtaw6RJhZPfZL/zy1+5" +
       "C0YZ2TCr823oWPwXkQRvt4UHGFk9gzCDDp5K5gsNMbLCRwjmUs4/+XJ7GWl1" +
       "y4FR/De/3H6owSnHSK19k1/kAFgFRfD2LiPrPzfM7pi/M27Bc5lBqw3xVsvY" +
       "30SsyG9pfhC8aCYHydsmX1+wvcw/Mc1uBaftj0xj8rkze/rv+fD6J+xPaGRV" +
       "mp7GWhqjeHiPX/PwSnE7ea1nbdm6andvvDT/uXkbshvvC2yDnb65wukaeKwQ" +
       "MNAll7u+L7Hac5+Z/PTsjhe/f7L2R0ESOEACErj1geL31jNG2iQrD0SLXyzd" +
       "J5n8w5eOjZ+buuXq5L//PHdkXfg9gLt8TL7w5MHXH156dlWQNPaSGkVL0Ax/" +
       "oX7nlDZE5QlzlDQrViQDJkItiqQWvLU6H3uPhB+fcl4Enc25p/gBFiPril/Y" +
       "Lf5srUHVJ6nJZzJYTXOUNDpP7JZx7cinDcMl4DwRTYnpJzCZzmBrgNvGon2G" +
       "kX2fufFfDB5HTpSadfAXE4L8M8wTeGf8HxQx9Sd+PgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SHrAsfW6AephwyJbbpiU3lzXPWkmr8lx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "4EwAAA==");
}
