package org.apache.batik.transcoder.wmf.tosvg;
public class AbstractWMFPainter {
    public static final java.lang.String WMF_FILE_EXTENSION = ".wmf";
    protected org.apache.batik.transcoder.wmf.tosvg.WMFFont wmfFont = null;
    protected int currentHorizAlign = 0;
    protected int currentVertAlign = 0;
    public static final int PEN = 1;
    public static final int BRUSH = 2;
    public static final int FONT = 3;
    public static final int NULL_PEN = 4;
    public static final int NULL_BRUSH = 5;
    public static final int PALETTE = 6;
    public static final int OBJ_BITMAP = 7;
    public static final int OBJ_REGION = 8;
    protected org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore;
    protected transient boolean bReadingWMF = true;
    protected transient java.io.BufferedInputStream bufStream = null;
    protected java.awt.image.BufferedImage getImage(byte[] bit, int width,
                                                    int height) { int _width =
                                                                    ((int)
                                                                       bit[7] &
                                                                       255) <<
                                                                    24 |
                                                                    ((int)
                                                                       bit[6] &
                                                                       255) <<
                                                                    16 |
                                                                    ((int)
                                                                       bit[5] &
                                                                       255) <<
                                                                    8 |
                                                                    (int)
                                                                      bit[4] &
                                                                    255;
                                                                  int _height =
                                                                    ((int)
                                                                       bit[11] &
                                                                       255) <<
                                                                    24 |
                                                                    ((int)
                                                                       bit[10] &
                                                                       255) <<
                                                                    16 |
                                                                    ((int)
                                                                       bit[9] &
                                                                       255) <<
                                                                    8 |
                                                                    (int)
                                                                      bit[8] &
                                                                    255;
                                                                  if (width !=
                                                                        _width ||
                                                                        height !=
                                                                        _height)
                                                                      return null;
                                                                  return getImage(
                                                                           bit);
    }
    protected java.awt.Dimension getImageDimension(byte[] bit) {
        int _width =
          ((int)
             bit[7] &
             255) <<
          24 |
          ((int)
             bit[6] &
             255) <<
          16 |
          ((int)
             bit[5] &
             255) <<
          8 |
          (int)
            bit[4] &
          255;
        int _height =
          ((int)
             bit[11] &
             255) <<
          24 |
          ((int)
             bit[10] &
             255) <<
          16 |
          ((int)
             bit[9] &
             255) <<
          8 |
          (int)
            bit[8] &
          255;
        return new java.awt.Dimension(
          _width,
          _height);
    }
    protected java.awt.image.BufferedImage getImage(byte[] bit) {
        int _width =
          ((int)
             bit[7] &
             255) <<
          24 |
          ((int)
             bit[6] &
             255) <<
          16 |
          ((int)
             bit[5] &
             255) <<
          8 |
          (int)
            bit[4] &
          255;
        int _height =
          ((int)
             bit[11] &
             255) <<
          24 |
          ((int)
             bit[10] &
             255) <<
          16 |
          ((int)
             bit[9] &
             255) <<
          8 |
          (int)
            bit[8] &
          255;
        int[] bitI =
          new int[_width *
                    _height];
        java.awt.image.BufferedImage img =
          new java.awt.image.BufferedImage(
          _width,
          _height,
          java.awt.image.BufferedImage.
            TYPE_INT_RGB);
        java.awt.image.WritableRaster raster =
          img.
          getRaster(
            );
        int _headerSize =
          ((int)
             bit[3] &
             255) <<
          24 |
          ((int)
             bit[2] &
             255) <<
          16 |
          ((int)
             bit[1] &
             255) <<
          8 |
          (int)
            bit[0] &
          255;
        int _planes =
          ((int)
             bit[13] &
             255) <<
          8 |
          (int)
            bit[12] &
          255;
        int _nbit =
          ((int)
             bit[15] &
             255) <<
          8 |
          (int)
            bit[14] &
          255;
        int _size =
          ((int)
             bit[23] &
             255) <<
          24 |
          ((int)
             bit[22] &
             255) <<
          16 |
          ((int)
             bit[21] &
             255) <<
          8 |
          (int)
            bit[20] &
          255;
        if (_size ==
              0)
            _size =
              ((_width *
                  _nbit +
                  31 &
                  ~31) >>
                 3) *
                _height;
        int _clrused =
          ((int)
             bit[35] &
             255) <<
          24 |
          ((int)
             bit[34] &
             255) <<
          16 |
          ((int)
             bit[33] &
             255) <<
          8 |
          (int)
            bit[32] &
          255;
        if (_nbit ==
              24) {
            int pad =
              _size /
              _height -
              _width *
              3;
            int offset =
              _headerSize;
            for (int j =
                   0;
                 j <
                   _height;
                 j++) {
                for (int i =
                       0;
                     i <
                       _width;
                     i++) {
                    bitI[_width *
                           (_height -
                              j -
                              1) +
                           i] =
                      (255 &
                         255) <<
                        24 |
                        ((int)
                           bit[offset +
                                 2] &
                           255) <<
                        16 |
                        ((int)
                           bit[offset +
                                 1] &
                           255) <<
                        8 |
                        (int)
                          bit[offset] &
                        255;
                    offset +=
                      3;
                }
                offset +=
                  pad;
            }
        }
        else
            if (_nbit ==
                  8) {
                int nbColors =
                  0;
                if (_clrused >
                      0)
                    nbColors =
                      _clrused;
                else
                    nbColors =
                      (1 &
                         255) <<
                        8;
                int offset =
                  _headerSize;
                int[] palette =
                  new int[nbColors];
                for (int i =
                       0;
                     i <
                       nbColors;
                     i++) {
                    palette[i] =
                      (255 &
                         255) <<
                        24 |
                        ((int)
                           bit[offset +
                                 2] &
                           255) <<
                        16 |
                        ((int)
                           bit[offset +
                                 1] &
                           255) <<
                        8 |
                        (int)
                          bit[offset] &
                        255;
                    offset +=
                      4;
                }
                _size =
                  bit.
                    length -
                    offset;
                int pad =
                  _size /
                  _height -
                  _width;
                for (int j =
                       0;
                     j <
                       _height;
                     j++) {
                    for (int i =
                           0;
                         i <
                           _width;
                         i++) {
                        bitI[_width *
                               (_height -
                                  j -
                                  1) +
                               i] =
                          palette[(int)
                                    bit[offset] &
                                    255];
                        offset++;
                    }
                    offset +=
                      pad;
                }
            }
            else
                if (_nbit ==
                      1) {
                    int nbColors =
                      2;
                    int offset =
                      _headerSize;
                    int[] palette =
                      new int[nbColors];
                    for (int i =
                           0;
                         i <
                           nbColors;
                         i++) {
                        palette[i] =
                          (255 &
                             255) <<
                            24 |
                            ((int)
                               bit[offset +
                                     2] &
                               255) <<
                            16 |
                            ((int)
                               bit[offset +
                                     1] &
                               255) <<
                            8 |
                            (int)
                              bit[offset] &
                            255;
                        offset +=
                          4;
                    }
                    int pos =
                      7;
                    byte currentByte =
                      bit[offset];
                    int pad =
                      _size /
                      _height -
                      _width /
                      8;
                    for (int j =
                           0;
                         j <
                           _height;
                         j++) {
                        for (int i =
                               0;
                             i <
                               _width;
                             i++) {
                            if ((currentByte &
                                   1 <<
                                   pos) !=
                                  0)
                                bitI[_width *
                                       (_height -
                                          j -
                                          1) +
                                       i] =
                                  palette[1];
                            else
                                bitI[_width *
                                       (_height -
                                          j -
                                          1) +
                                       i] =
                                  palette[0];
                            pos--;
                            if (pos ==
                                  -1) {
                                pos =
                                  7;
                                offset++;
                                currentByte =
                                  bit[offset];
                            }
                        }
                        offset +=
                          pad;
                        pos =
                          7;
                        if (offset <
                              bit.
                                length)
                            currentByte =
                              bit[offset];
                    }
                }
        raster.
          setDataElements(
            0,
            0,
            _width,
            _height,
            bitI);
        return img;
    }
    protected java.text.AttributedCharacterIterator getCharacterIterator(java.awt.Graphics2D g2d,
                                                                         java.lang.String sr,
                                                                         org.apache.batik.transcoder.wmf.tosvg.WMFFont wmffont) {
        return getAttributedString(
                 g2d,
                 sr,
                 wmffont).
          getIterator(
            );
    }
    protected java.text.AttributedCharacterIterator getCharacterIterator(java.awt.Graphics2D g2d,
                                                                         java.lang.String sr,
                                                                         org.apache.batik.transcoder.wmf.tosvg.WMFFont wmffont,
                                                                         int align) {
        java.text.AttributedString ats =
          getAttributedString(
            g2d,
            sr,
            wmffont);
        return ats.
          getIterator(
            );
    }
    protected java.text.AttributedString getAttributedString(java.awt.Graphics2D g2d,
                                                             java.lang.String sr,
                                                             org.apache.batik.transcoder.wmf.tosvg.WMFFont wmffont) {
        java.text.AttributedString ats =
          new java.text.AttributedString(
          sr);
        java.awt.Font font =
          g2d.
          getFont(
            );
        ats.
          addAttribute(
            java.awt.font.TextAttribute.
              SIZE,
            new java.lang.Float(
              font.
                getSize2D(
                  )));
        ats.
          addAttribute(
            java.awt.font.TextAttribute.
              FONT,
            font);
        if (wmfFont.
              underline !=
              0)
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  UNDERLINE,
                java.awt.font.TextAttribute.
                  UNDERLINE_ON);
        if (wmfFont.
              italic !=
              0)
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  POSTURE,
                java.awt.font.TextAttribute.
                  POSTURE_OBLIQUE);
        else
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  POSTURE,
                java.awt.font.TextAttribute.
                  POSTURE_REGULAR);
        if (wmfFont.
              weight >
              400)
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  WEIGHT,
                java.awt.font.TextAttribute.
                  WEIGHT_BOLD);
        else
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  WEIGHT,
                java.awt.font.TextAttribute.
                  WEIGHT_REGULAR);
        return ats;
    }
    public void setRecordStore(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore) {
        if (currentStore ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          currentStore =
          currentStore;
    }
    public org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore getRecordStore() {
        return currentStore;
    }
    protected int addObject(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore store,
                            int type,
                            java.lang.Object obj) {
        return currentStore.
          addObject(
            type,
            obj);
    }
    protected int addObjectAt(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore store,
                              int type,
                              java.lang.Object obj,
                              int idx) { return currentStore.
                                           addObjectAt(
                                             type,
                                             obj,
                                             idx);
    }
    public AbstractWMFPainter() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rZ5qt4O6jLXTrSl0twI4RqNzdNYnZr36");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("QKoNB5KHtWbAG1z3NNMeRUFNS+pqu5exMsXNB+tE0bhFXuuJKGIFIrwRDB4T" +
       "U2gEL9u9OeWyOZVlDL6ycgxOY6ZlrefrXaM2a3pUKHBu1GPEqTevmxt+vk7o" +
       "jTpl+g1oSLQ2PMSITgMsVnQsItTGb+EwOAxhC51oy8DU9RCcGwnEZKzpYq/j" +
       "KYQs0kt1FeCdLIugnhOso0U3gOqdesaZLq6OdJSPiC1fXwLjTvs+Ve+2iTYs" +
       "r9vVHUBvce1tZzqaoHk8kiIn30LaMO0Nqb4TbKdsag1jEdYMaxY0t6hXd7LB" +
       "aj1O/bo8zmeJ3ZZcgW9E1DrnOhCSIlWL8BPN7W8berqz89WAyuccypNVHZb6" +
       "w7ZqeFwOJ+lqR6GusOaxFjiIc7XMAcdbCIVEvDvZ1MR1HrTVpauAQ7lrkG1g" +
       "M3lk4VtVV6oO3d5SzqTBEK3N1prKD63BUjM6azhfDWdmW18LHFYXuhG76rkE" +
       "iQj9es7n2dwl7UWdtrihx7gSWY1knGgtJlUkD+dNnNhI/URmKHA8zqMoYbSm" +
       "q5AiDnsZDvOmNVNDaMIh0lCdE4mSqV3Gq42TCQd8cWEaajY9xxmUCfpVnIbI" +
       "mt7rsH0Y8ZeyPzWxqq7zmg3vqAW6Ga3Q3hqaKTleb7LVfs/S3C43wrDi8eRf" +
       "XOyx6YPlI9+jcNof4GHvvuotRfLU0ePz8u9q5fbxZ2XLhw8idpK48ujtomTL" +
       "9/af+8hzzxvCr1YvH8Q2fbB4KRBG7/bMtemdGOoeMNI7bx+jwJVBwscxN3/0" +
       "kf/2yOS99gcvEFX42Cmcp4f8p9zn/4R8m/7zlyt3HEXg3BK+fHOnZ26Ou7kn" +
       "NtMsDiY3Rd88eiTZNxUSK17VYweSxU6/mDieu3PfEZV1x6Fjd+zVBAjwqdsL" +
       "sIxN28dsPP9rT/zZTz7/xH8qw7uuOclMjbF4cUa884k+3/z8C1//6qsf/UIZ" +
       "DnlFU5M9w9OB4rfGgd8U3l3Cv/dmgTwOuP2LvTz2/9OK/jLDb7XYMRYmjAOU" +
       "Yz12otQJFv1g7cRh4IMxDqN8/z5usz3zDYa2S82j6bt0EFp79Jriu4cvqL5/" +
       "zguqd9xkC64Cb2ixD6Qu32N+J9oejX953+nwzdVrjl/odL0wMIvQx8O61x6+" +
       "1Tr6lgBUbs9E+vU90vJmRfLEKaU8Ec946Z5z6u4tkmtp5U69ALPHfk7z+7eV" +
       "I5IfKO/+7XNaP1gU/o+0cm1hprSvLo6Ivqkkqm7S605RfPwW76hRaTz/9sVe" +
       "K5284V4st4ZZcAernXtlVvul4wbfKUk+eo4AHiuSh8FecSiAngNUMzk0lEAS" +
       "Dx1J4uaqgv+lH3oZ/I+s3fsP+L///xN/6Bz+7y6St51QgOL3a44Jvv1lECzD" +
       "wN4Lrq8cEPzKK2vOb1qvxQSRsRrZjp7UeqvDjV4sWaLnSKCwKJdqYGkDCXRt" +
       "tQj/N2M6Nctg7cN7PFXeo/i06DqWprGjZalpnN26FFv9lRDb1w7E9rVXRmxX" +
       "ygZFvNKl9rF8juzEJfIcIdFFgt9GSEXde465d18G98eKwiLk5oUD7i+8oipz" +
       "intJbXwO7WmR8EDFAO3jed9H5h6qxiNnqcaJJqVMhJchk1cVhUVM8rcPZPLt" +
       "i8rkHS9mJ367ZKueIwm9SN6fVu5LzPREAM2Zm/c6dIxj6j/6Mqg/UhQWUWPf" +
       "P6D+/VeG+klm522mpWovAevFTaxLkR0z9F4Gw4eKwjcCsJf3fff/X0mFr/x2" +
       "ucQP1fVE/Oo+mr4k+uPnCOFDRbIBpxLVMPZdjgcs+W9fLv9HAZWrB/yvvjL8" +
       "j43dAf8C6LPHxu6nzyH8s0XyUyk4NR0Sxk5T/uhFKG+BE3Hrl2XFpzEP3/KV" +
       "6/7LTP0Lz99/7Q3PT//9/jRx+PXk3WzlmpV53skvGU7kr0axaTmlOO7ef9cQ" +
       "lXx+AexfLyk6DjiZ5f+CwaWf33f+NDjjvUjnFGibb53s9Etp5Y3ndErB6fPo" +
       "x8l+nwX6ebofAFX+P9nuV8AIx+2Ad7/PnGzyjwAq0KTI/uOonPzt3i9/+KQi" +
       "lk7sQy82mSfO8k/cdIAsv2U+PC1n+6+Zb+hffH7A/9i3Wr+6/8JM99Q8L0a5" +
       "Bs56+4/dykGLE/dbbjva4VhXqae/d99v3f3U4dOB+/aAjxfFCWyPnf0JV9+P" +
       "0vKjq/z33vDPf/jXn//LMlL9/wEtTVeMZD4AAA==");
}
