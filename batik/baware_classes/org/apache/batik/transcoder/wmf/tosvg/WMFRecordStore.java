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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ficAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Qjerda0n8l16aez4aF5F0WXmbelaiGeII1umj2T8JpMNDRuhruskEaOyoxzt" +
       "7Wxuvc6XWD933DkzzkZ2I3GIkZRkY7/eg5fbUWCbw24lt6POhCQzfzidyMiw" +
       "wk02W3+0cqVNmolxPhn3drpsJWGQ1Sglr8iNVo2nuMDtT31OR+uSjIR6pZnN" +
       "xSAXuQwj0cYY7Jm8ag83qbCiVdTICSeS1Rnn6Mrx6pNYk9suthmrklFfGFqV" +
       "alU7WWwJQ1vHZkOY86ic4KgEQ3MUzTudWW9WC0beZrzSwjaI+bmkPkgJXoYD" +
       "cxAabGTxcVcRaDPdNmuDmgk8Ab/EUCtlrI271rHmMglMK9hhGL+rVwbzLRc0" +
       "qq6xnkzEfr6Ydlg9ShvTzOF0xBtp9Y48NmQJcVV7qqozn69v+lsQgdeUhVtH" +
       "XRgV5G1vJWAqn9soh7uZTNfrSsWD+0gqUUtbw3H8Ix8pjlr+3ps7Arq3PO06" +
       "vmPiuFhR8Zk3ccqzr3qsSJ46Pi8s/+6Azt1LOHVeeOqDFlSc1D9ys6sj5Sn9" +
       "lz75wos694vVowNRMYGuJEH411wjM9xTrK4CTh+++RErW96cOflA9Ruf/KOH" +
       "ph+1nnsTn90fPSfneZa/xL70W/0PaH/nInTp+HPVa+70nCV65uxHqquRkaSR" +
       "Pz3zqeqRs5++HwRP81CzzfMnsSdjd+Nj2A/tx/4W31n/4S3q/nGRvJRAt0dG" +
       "bNzwDPe2LLD1E9v58uudEJ7uoSz4pWOwDxwdO/cOwfbeLFjuhmAvHN7UODzS" +
       "3X/vtYODjpIotB+mySSJDMUraV++Ne07j2hprptrRljYT0n3b4rk1xLoLsBJ" +
       "P/xgVhT9+Ilq/sVbUM21ovB+CLr4nT3t/v322sF/uEXdbxfJ1xLoDtNIZlF5" +
       "m6t/guzrbwHZXYf+4uKfHCL7k7cH2YWTBv2ywX+5BbxvFsnvFh8JjuF99QTe" +
       "771Vm34UwHr1EN6rbzu8adngO7eA90dF8vvAi4LRO2WbwJ6RN3ZFCrgw5RRh" +
       "qZU/eKvm/DDQxvcPtfL9t9+cX71F3Z8X");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ySsJ9A6gkNHxB+5SmScA/+dbAFiuisBvX7ptT7t/v60AL1y8Rd1tReH39/NV" +
       "DOfFr+dOkP3F24HsrkNkd739yO65Rd31IrlyhEw+i+zC1bfqiT4IEN13iOy+" +
       "t32qPldCeOgW8B4ukvv3nuhw4E480YUH3g547zmE956/IngfuAW8Iia98NgR" +
       "PPkcvMffDLw8ge45e3WzuIf27tdcHd9fd9Z+5cVrdz744ux3y9uLx1eSrwyh" +
       "O5ep656+NnQqf0cYGUu7hH1lf4koLGHACfTUG/KcIHIq34X0Fw72xDUQI74O" +
       "cQJdAulpIjSB3nsLogREr8c/TtO1Euj6eTogVPk+3e4ZwOGkHRigfeZ0k48C" +
       "qUCTIvux8GgBwd7YAoKrMSjXknLAlOIO3YWze4Jj33Tf69nAqW3EE2eC//J/" +
       "C44C9XR8eI3jKy8yo0+80vzF/e1PzVV2u4LLnUPo8v4i6nGw/9hNuR3xuoN6" +
       "+nv3/OqVp442JvfsBT6ZN6dke/TGVy27XpiUlyN3/+zBf/JDf//Fb5Zf9f8v" +
       "GuzK0/QxAAA=");
}
