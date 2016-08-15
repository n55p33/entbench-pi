package org.apache.batik.transcoder.wmf.tosvg;
public class WMFRecordStore extends org.apache.batik.transcoder.wmf.tosvg.AbstractWMFReader {
    private java.net.URL url;
    protected int numRecords;
    protected float vpX;
    protected float vpY;
    protected java.util.List records;
    private boolean _bext = true;
    public WMFRecordStore() { super();
                              reset(); }
    public void reset() { numRecords = 0;
                          vpX = 0;
                          vpY = 0;
                          vpW = 1000;
                          vpH = 1000;
                          scaleX = 1;
                          scaleY = 1;
                          scaleXY = 1.0F;
                          inch = 84;
                          records = new java.util.ArrayList(20); }
    protected boolean readRecords(java.io.DataInputStream is) throws java.io.IOException {
        short functionId =
          1;
        int recSize =
          0;
        short recData;
        numRecords =
          0;
        while (functionId >
                 0) {
            recSize =
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
            org.apache.batik.transcoder.wmf.tosvg.MetaRecord mr =
              new org.apache.batik.transcoder.wmf.tosvg.MetaRecord(
              );
            switch (functionId) {
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETMAPMODE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int mapmode =
                          readShort(
                            is);
                        if (mapmode ==
                              org.apache.batik.transcoder.wmf.WMFConstants.
                                MM_ANISOTROPIC)
                            isotropic =
                              false;
                        mr.
                          addElement(
                            mapmode);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DRAWTEXT:
                    {
                        for (int i =
                               0;
                             i <
                               recSize;
                             i++)
                            recData =
                              readShort(
                                is);
                        numRecords--;
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_EXTTEXTOUT:
                    {
                        int yVal =
                          readShort(
                            is) *
                          ySign;
                        int xVal =
                          (int)
                            (readShort(
                               is) *
                               xSign *
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
                                   xSign *
                                   scaleXY);
                            y1 =
                              readShort(
                                is) *
                                ySign;
                            x2 =
                              (int)
                                (readShort(
                                   is) *
                                   xSign *
                                   scaleXY);
                            y2 =
                              readShort(
                                is) *
                                ySign;
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
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bstr);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            xVal);
                        mr.
                          addElement(
                            yVal);
                        mr.
                          addElement(
                            flag);
                        if (clipped) {
                            mr.
                              addElement(
                                x1);
                            mr.
                              addElement(
                                y1);
                            mr.
                              addElement(
                                x2);
                            mr.
                              addElement(
                                y2);
                        }
                        records.
                          add(
                            mr);
                    }
                    break;
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
                        int yVal =
                          readShort(
                            is) *
                          ySign;
                        int xVal =
                          (int)
                            (readShort(
                               is) *
                               xSign *
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
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bstr);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            xVal);
                        mr.
                          addElement(
                            yVal);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEFONTINDIRECT:
                    {
                        int lfHeight =
                          readShort(
                            is);
                        int lfWidth =
                          readShort(
                            is);
                        int lfEscapement =
                          readShort(
                            is);
                        int lfOrientation =
                          readShort(
                            is);
                        int lfWeight =
                          readShort(
                            is);
                        int lfItalic =
                          is.
                          readByte(
                            );
                        int lfUnderline =
                          is.
                          readByte(
                            );
                        int lfStrikeOut =
                          is.
                          readByte(
                            );
                        int lfCharSet =
                          is.
                          readByte(
                            ) &
                          255;
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
                        java.lang.String str =
                          new java.lang.String(
                          lfFaceName);
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.StringRecord(
                            str);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            lfHeight);
                        mr.
                          addElement(
                            lfItalic);
                        mr.
                          addElement(
                            lfWeight);
                        mr.
                          addElement(
                            lfCharSet);
                        mr.
                          addElement(
                            lfUnderline);
                        mr.
                          addElement(
                            lfStrikeOut);
                        mr.
                          addElement(
                            lfOrientation);
                        mr.
                          addElement(
                            lfEscapement);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETVIEWPORTORG:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETVIEWPORTEXT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETWINDOWORG:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETWINDOWEXT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int height =
                          readShort(
                            is);
                        int width =
                          readShort(
                            is);
                        if (width <
                              0) {
                            width =
                              -width;
                            xSign =
                              -1;
                        }
                        if (height <
                              0) {
                            height =
                              -height;
                            ySign =
                              -1;
                        }
                        mr.
                          addElement(
                            (int)
                              (width *
                                 scaleXY));
                        mr.
                          addElement(
                            height);
                        records.
                          add(
                            mr);
                        if (_bext &&
                              functionId ==
                              org.apache.batik.transcoder.wmf.WMFConstants.
                                META_SETWINDOWEXT) {
                            vpW =
                              width;
                            vpH =
                              height;
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
                            _bext =
                              false;
                        }
                        if (!isAldus) {
                            this.
                              width =
                              vpW;
                            this.
                              height =
                              vpH;
                        }
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_OFFSETVIEWPORTORG:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_OFFSETWINDOWORG:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int y =
                          readShort(
                            is) *
                          ySign;
                        int x =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            x);
                        mr.
                          addElement(
                            y);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SCALEVIEWPORTEXT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SCALEWINDOWEXT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int ydenom =
                          readShort(
                            is);
                        int ynum =
                          readShort(
                            is);
                        int xdenom =
                          readShort(
                            is);
                        int xnum =
                          readShort(
                            is);
                        mr.
                          addElement(
                            xdenom);
                        mr.
                          addElement(
                            ydenom);
                        mr.
                          addElement(
                            xnum);
                        mr.
                          addElement(
                            ynum);
                        records.
                          add(
                            mr);
                        scaleX =
                          scaleX *
                            (float)
                              xdenom /
                            (float)
                              xnum;
                        scaleY =
                          scaleY *
                            (float)
                              ydenom /
                            (float)
                              ynum;
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEBRUSHINDIRECT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            readShort(
                              is));
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
                        int flags =
                          (colorref &
                             50331648) >>
                          24;
                        mr.
                          addElement(
                            red);
                        mr.
                          addElement(
                            green);
                        mr.
                          addElement(
                            blue);
                        mr.
                          addElement(
                            readShort(
                              is));
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEPENINDIRECT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            readShort(
                              is));
                        int width =
                          readInt(
                            is);
                        int colorref =
                          readInt(
                            is);
                        if (recSize ==
                              6)
                            readShort(
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
                        int flags =
                          (colorref &
                             50331648) >>
                          24;
                        mr.
                          addElement(
                            red);
                        mr.
                          addElement(
                            green);
                        mr.
                          addElement(
                            blue);
                        mr.
                          addElement(
                            width);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETTEXTALIGN:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
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
                        mr.
                          addElement(
                            align);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETTEXTCOLOR:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETBKCOLOR:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
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
                        int flags =
                          (colorref &
                             50331648) >>
                          24;
                        mr.
                          addElement(
                            red);
                        mr.
                          addElement(
                            green);
                        mr.
                          addElement(
                            blue);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_LINETO:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_MOVETO:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int y =
                          readShort(
                            is) *
                          ySign;
                        int x =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            x);
                        mr.
                          addElement(
                            y);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETPOLYFILLMODE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int mode =
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
                        mr.
                          addElement(
                            mode);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_POLYPOLYGON:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
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
                        mr.
                          addElement(
                            count);
                        for (int i =
                               0;
                             i <
                               count;
                             i++)
                            mr.
                              addElement(
                                pts[i]);
                        int offset =
                          count +
                          1;
                        for (int i =
                               0;
                             i <
                               count;
                             i++) {
                            int nPoints =
                              pts[i];
                            for (int j =
                                   0;
                                 j <
                                   nPoints;
                                 j++) {
                                mr.
                                  addElement(
                                    (int)
                                      (readShort(
                                         is) *
                                         xSign *
                                         scaleXY));
                                mr.
                                  addElement(
                                    readShort(
                                      is) *
                                      ySign);
                            }
                        }
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_POLYLINE:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_POLYGON:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int count =
                          readShort(
                            is);
                        mr.
                          addElement(
                            count);
                        for (int i =
                               0;
                             i <
                               count;
                             i++) {
                            mr.
                              addElement(
                                (int)
                                  (readShort(
                                     is) *
                                     xSign *
                                     scaleXY));
                            mr.
                              addElement(
                                readShort(
                                  is) *
                                  ySign);
                        }
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_ELLIPSE:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_INTERSECTCLIPRECT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_RECTANGLE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int bottom =
                          readShort(
                            is) *
                          ySign;
                        int right =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            left);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            right);
                        mr.
                          addElement(
                            bottom);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEREGION:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        int right =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int bottom =
                          readShort(
                            is) *
                          ySign;
                        mr.
                          addElement(
                            left);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            right);
                        mr.
                          addElement(
                            bottom);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_ROUNDRECT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int el_height =
                          readShort(
                            is) *
                          ySign;
                        int el_width =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int bottom =
                          readShort(
                            is) *
                          ySign;
                        int right =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            left);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            right);
                        mr.
                          addElement(
                            bottom);
                        mr.
                          addElement(
                            el_width);
                        mr.
                          addElement(
                            el_height);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_ARC:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_PIE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int yend =
                          readShort(
                            is) *
                          ySign;
                        int xend =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int ystart =
                          readShort(
                            is) *
                          ySign;
                        int xstart =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int bottom =
                          readShort(
                            is) *
                          ySign;
                        int right =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            left);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            right);
                        mr.
                          addElement(
                            bottom);
                        mr.
                          addElement(
                            xstart);
                        mr.
                          addElement(
                            ystart);
                        mr.
                          addElement(
                            xend);
                        mr.
                          addElement(
                            yend);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_PATBLT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int rop =
                          readInt(
                            is);
                        int height =
                          readShort(
                            is) *
                          ySign;
                        int width =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        mr.
                          addElement(
                            rop);
                        mr.
                          addElement(
                            height);
                        mr.
                          addElement(
                            width);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            left);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETBKMODE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int mode =
                          readShort(
                            is);
                        mr.
                          addElement(
                            mode);
                        if (recSize >
                              1)
                            for (int i =
                                   1;
                                 i <
                                   recSize;
                                 i++)
                                readShort(
                                  is);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETROP2:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int rop;
                        if (recSize ==
                              1)
                            rop =
                              readShort(
                                is);
                        else
                            rop =
                              readInt(
                                is);
                        mr.
                          addElement(
                            rop);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DIBSTRETCHBLT:
                    {
                        int mode =
                          is.
                          readInt(
                            ) &
                          255;
                        int heightSrc =
                          readShort(
                            is) *
                          ySign;
                        int widthSrc =
                          readShort(
                            is) *
                          xSign;
                        int sy =
                          readShort(
                            is) *
                          ySign;
                        int sx =
                          readShort(
                            is) *
                          xSign;
                        int heightDst =
                          readShort(
                            is) *
                          ySign;
                        int widthDst =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int dy =
                          readShort(
                            is) *
                          ySign;
                        int dx =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int len =
                          2 *
                          recSize -
                          20;
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
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bitmap);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            mode);
                        mr.
                          addElement(
                            heightSrc);
                        mr.
                          addElement(
                            widthSrc);
                        mr.
                          addElement(
                            sy);
                        mr.
                          addElement(
                            sx);
                        mr.
                          addElement(
                            heightDst);
                        mr.
                          addElement(
                            widthDst);
                        mr.
                          addElement(
                            dy);
                        mr.
                          addElement(
                            dx);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_STRETCHDIB:
                    {
                        int mode =
                          is.
                          readInt(
                            ) &
                          255;
                        int usage =
                          readShort(
                            is);
                        int heightSrc =
                          readShort(
                            is) *
                          ySign;
                        int widthSrc =
                          readShort(
                            is) *
                          xSign;
                        int sy =
                          readShort(
                            is) *
                          ySign;
                        int sx =
                          readShort(
                            is) *
                          xSign;
                        int heightDst =
                          readShort(
                            is) *
                          ySign;
                        int widthDst =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int dy =
                          readShort(
                            is) *
                          ySign;
                        int dx =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
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
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bitmap);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            mode);
                        mr.
                          addElement(
                            heightSrc);
                        mr.
                          addElement(
                            widthSrc);
                        mr.
                          addElement(
                            sy);
                        mr.
                          addElement(
                            sx);
                        mr.
                          addElement(
                            heightDst);
                        mr.
                          addElement(
                            widthDst);
                        mr.
                          addElement(
                            dy);
                        mr.
                          addElement(
                            dx);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DIBBITBLT:
                    {
                        int mode =
                          is.
                          readInt(
                            ) &
                          255;
                        int sy =
                          readShort(
                            is);
                        int sx =
                          readShort(
                            is);
                        int hdc =
                          readShort(
                            is);
                        int height =
                          readShort(
                            is);
                        int width =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int dy =
                          readShort(
                            is);
                        int dx =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int len =
                          2 *
                          recSize -
                          18;
                        if (len >
                              0) {
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
                            mr =
                              new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                                bitmap);
                            mr.
                              numPoints =
                              recSize;
                            mr.
                              functionId =
                              functionId;
                        }
                        else {
                            mr.
                              numPoints =
                              recSize;
                            mr.
                              functionId =
                              functionId;
                            for (int i =
                                   0;
                                 i <
                                   len;
                                 i++)
                                is.
                                  readByte(
                                    );
                        }
                        mr.
                          addElement(
                            mode);
                        mr.
                          addElement(
                            height);
                        mr.
                          addElement(
                            width);
                        mr.
                          addElement(
                            sy);
                        mr.
                          addElement(
                            sx);
                        mr.
                          addElement(
                            dy);
                        mr.
                          addElement(
                            dx);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DIBCREATEPATTERNBRUSH:
                    {
                        int type =
                          is.
                          readInt(
                            ) &
                          255;
                        int len =
                          2 *
                          recSize -
                          4;
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
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bitmap);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            type);
                        records.
                          add(
                            mr);
                    }
                    break;
                default:
                    mr.
                      numPoints =
                      recSize;
                    mr.
                      functionId =
                      functionId;
                    for (int j =
                           0;
                         j <
                           recSize;
                         j++)
                        mr.
                          addElement(
                            readShort(
                              is));
                    records.
                      add(
                        mr);
                    break;
            }
            numRecords++;
        }
        if (!isAldus) {
            right =
              (int)
                vpX;
            left =
              (int)
                (vpX +
                   vpW);
            top =
              (int)
                vpY;
            bottom =
              (int)
                (vpY +
                   vpH);
        }
        setReading(
          false);
        return true;
    }
    public java.net.URL getUrl() { return url;
    }
    public void setUrl(java.net.URL newUrl) {
        url =
          newUrl;
    }
    public org.apache.batik.transcoder.wmf.tosvg.MetaRecord getRecord(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.MetaRecord)
                 records.
                 get(
                   idx);
    }
    public int getNumRecords() { return numRecords;
    }
    public float getVpX() { return vpX; }
    public float getVpY() { return vpY; }
    public void setVpX(float newValue) { vpX =
                                           newValue;
    }
    public void setVpY(float newValue) { vpY =
                                           newValue;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ficAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "K7//Vs35YaCNHx5q5Ydvvzm/eou6Py2S");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("V1LoHUAhwvEH7lKZJwD/51sAWK6KwG9fum1Pu3+/rQAvXLxF3W1F4Q/383US" +
       "KcWv506Q/dnbgeyuQ2R3vf3I7rlF3fUiuXKETD2L7MLVt+qJPggQ3XeI7L63" +
       "fao+V0J46BbwHi6S+/ee6HDgTjzRhQfeDnjvOYT3nr8geB+4BbwiJr3w2BE8" +
       "9Ry8x98MvDyF7jl7dbO4h/bu11wd31931n/5xWt3Pvii/Dvl7cXjK8lXOOhO" +
       "K/O809eGTuXviGLTckvYV/aXiKISBpxCT70hzwkip/JdSH/hYE9cBTHi6xCn" +
       "0CWQniZqpNB7b0GUguj1+MdpulYKXT9PB4Qq36fbPQM4nLQDA7TPnG7yUSAV" +
       "aFJkPxYdLSDYG1tA8HkCyvW0HDCtuEN34eye4Ng33fd6NnBqG/HEmeC//N+C" +
       "o0A9Gx5e4/jqiz3hE680f2F/+1P3tN2u4HInB13eX0Q9DvYfuym3I153ME//" +
       "4J5fufLU0cbknr3AJ/PmlGyP3viqJeVHaXk5cvfPHvwnP/b3X/xW+VX//wL6" +
       "vDzH9DEAAA==");
}
