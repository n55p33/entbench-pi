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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8RuCkcquiyORfh8Vu71Eac6Eb7k91PIi0ozBzJ2jlsZvCEaquDS+enZXifKg" +
       "p15hD7aiiDwVmLl/1PL4DQFxSrQ50tbb21ZImMOjmJyV9kgriwgzFjMPj1oY" +
       "vyFgcrpbNvS3dPR2NkcLyfPIKOQ5yx7srCLyVGLmyKjl8RvClmdj2zoIjgvJ" +
       "82SJzhVd4ip7sFV58gjn+lxR5+pHzch427n2wDaTZoLes7900LuRyroZ58Qe" +
       "IX9d4qQhiufYbJ7jI+RLheeK+6XNEPJzLhWQpsBs+fXNSHVsI5XisF8BeTgd" +
       "37iERB9bXHkNll1M11Uqad54DX8ybxD1cokQnA/fapvN1T4QvFMMAkxeLSC7" +
       "X6cAWSyVgM0atY8MYe5n8XBG0UMtqQSexsFe20gx0cYj37tF5Ev7bMz4snJY" +
       "5H8VxP9wxXUGQTAUr/e7++Bh+MFr9x6Id9+5ImifEemoFLqxTKVDVHV1VYU9" +
       "5RxndPLbHuds4K0JN/3h0YaBllLOirFszklOg/H3XIgal/hveLysPHPtX2b2" +
       "XjB4ZQnHvnM9KHm7/EnnoefWLZZvCvKrLXFokXcllkvUlLvJqDIpS5la7rZi" +
       "YXZeZ+N8YYzdbM9rs1efHV3yM1p+pLylcyZYJux17g11dnPKTxvF3umy6qd/" +
       "ad3xxwfFHq3Q1tdzJ3bP3ZXym8mn389o02CuePNAnR8TLIr/jMj/4wVNzFTi" +
       "AzTcAkrVI5uKwcAqtWlDiqlrSeTXvgf6KobBxbbIX0lduB64a+GLVx9Y+C4/" +
       "46xULFB7WCUF7ildNB8dOnb8pZr6+/nyKsdFxLXIe8Gbf3+bcy3LZ6UWky/S" +
       "J7Pc5bERRgub7bzNN7fNolthdgPVRczuMhEg8OEYqVCpNiDuDtFeBsoNp/+g" +
       "IMqY2snOzrFV1TWK5+uZuikZM5y9PofKwpz+XXDKB3MW1HHOj2etuM7PAzOK" +
       "1M3EZCpszGTkS4hRpHl9XilfqS2G62A6z1HyqEjh2c+K9D0fCz+B7cgAZR1J" +
       "aSCL0GyOkDTMQgoWO/4q24g7qU9P5oSLn5oLOQTO+Ru0TttEdZZu3fxIPVC4" +
       "YPuc41FsSpdj0sjIpAxWaxVYz1bGVwBodVnQcqsQqsCSUwBV1hFcZst7WelQ" +
       "+ZGeDKrzi0D1NUzWuNQKfy90sDj3FGDBj7YugO+oLdDR0rHwI/VxijmWBqd9" +
       "nSkZg4psreT2rQeTKzggG4qAhbuYQBsYJQCrdVDCu3pqdjDK7zIzYyziY+A7" +
       "oFD2VVa8cGuOcPupRPh1G6bXS0fYj9SDTzlnBE9fAhc5UGZtWmBzETwvx2ST" +
       "D55YF3VguuQUwDQX63AbfsyW9VjpMPmRFlZED0wchcEiCKHzxjvlyYCQo03i" +
       "WimjcDMLKZyrCYcvfgrgq8Y6vI372Mbg45PAdzwXvqoipP427UUOzHAR0EYw" +
       "MRmZYFHm2pgXjIaGdCXuoGSdApRmYh2ek31ui/p56Sj5kRYBYVeRuuswuRYA" +
       "GsgBiKPrgPGtUwBGHdbNgpkMij7F/5JWnC+p74ojL3JzlFkvrosKcWHNMdlb" +
       "BK/9mHwP9tBSPC5InA45VHtOFVT1IGeFLW9F6VD5kfracBsqlGnftqwNv6MI" +
       "NndicoDBhjyDTbMXnR/9P9BJQ9CW/0AOX3PMyHusKx6YyvcfqK2cfuDi18Tm" +
       "KvMIdHyEVCZSqup+b+DKVxgmTYhwfLx4fcAvBQP3gWf/UseBsFvg/1GQwCFB" +
       "/AAjc09CzEBhkwk30U8ZmVWEiJEq54eb7ueg4l46YIr/d7d7FHpw2sGOTWTc" +
       "TR4DrqAJZh83/NeP2H/Ncs8g33NMPdnEuw60Fubssfkz7cyxREo81O6XDx/Y" +
       "0HXViXPuFM/VZFXavh17qYbtsHgUxzvFg5/5vr1l+qpY3/jZhAfGLcocauQ8" +
       "l3PzxtUP1hB/WjbT837Lasg+43rj4HlP/GZ3xUuw/d9MAhL47M35T2PSRsok" +
       "9Zsj+XfamySTPyxravzhyAVLE397M3ttmvvkyNu+X37l7stfvmnGwTlBUt1B" +
       "xihanKb5m521IxoY9yGzj9QoVlsaWIReYA+dc2E+AZeFhLECx8WGsyZbiu8Y" +
       "GVmQ/1Yg//VnlaoPU7NFT2lx7KYmQqqdEjEznrOzlGF4CJwSeyoxtYTPxtkA" +
       "feyPdBpG5hFg9VsGtw95Dwd4Idfh3/Is5o7+F+e4crTCMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "l7XEhlDb7m/ZdohxbKdBOmi9IfTDESHw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "vHSV/d4b/tkP//rzf1lEqv8/rMcrWWQ+AAA=");
}
