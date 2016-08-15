package org.apache.batik.transcoder.wmf.tosvg;
public class RecordStore {
    public RecordStore() { super();
                           reset(); }
    public void reset() { numRecords = 0;
                          vpX = 0;
                          vpY = 0;
                          vpW = 1000;
                          vpH = 1000;
                          numObjects = 0;
                          records = new java.util.Vector(20, 20);
                          objectVector = new java.util.Vector(); }
    synchronized void setReading(boolean state) { bReading = state; }
    synchronized boolean isReading() { return bReading; }
    public boolean read(java.io.DataInputStream is) throws java.io.IOException {
        setReading(
          true);
        reset(
          );
        int functionId =
          0;
        numRecords =
          0;
        numObjects =
          is.
            readShort(
              );
        objectVector.
          ensureCapacity(
            numObjects);
        for (int i =
               0;
             i <
               numObjects;
             i++) {
            objectVector.
              add(
                new org.apache.batik.transcoder.wmf.tosvg.GdiObject(
                  i,
                  false));
        }
        while (functionId !=
                 -1) {
            functionId =
              is.
                readShort(
                  );
            if (functionId ==
                  -1) {
                break;
            }
            org.apache.batik.transcoder.wmf.tosvg.MetaRecord mr;
            switch (functionId) {
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_TEXTOUT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DRAWTEXT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_EXTTEXTOUT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEFONTINDIRECT:
                    {
                        short len =
                          is.
                          readShort(
                            );
                        byte[] b =
                          new byte[len];
                        for (int i =
                               0;
                             i <
                               len;
                             i++) {
                            b[i] =
                              is.
                                readByte(
                                  );
                        }
                        java.lang.String str =
                          new java.lang.String(
                          b);
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.StringRecord(
                            str);
                    }
                    break;
                default:
                    mr =
                      new org.apache.batik.transcoder.wmf.tosvg.MetaRecord(
                        );
                    break;
            }
            int numPts =
              is.
              readShort(
                );
            mr.
              numPoints =
              numPts;
            mr.
              functionId =
              functionId;
            for (int j =
                   0;
                 j <
                   numPts;
                 j++) {
                mr.
                  AddElement(
                    new java.lang.Integer(
                      is.
                        readShort(
                          )));
            }
            records.
              add(
                mr);
            numRecords++;
        }
        setReading(
          false);
        return true;
    }
    public void addObject(int type, java.lang.Object obj) { for (int i =
                                                                   0;
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
    }
    public void addObjectAt(int type, java.lang.Object obj,
                            int idx) { if (idx ==
                                             0 ||
                                             idx >
                                             numObjects) {
                                           addObject(
                                             type,
                                             obj);
                                           return;
                                       }
                                       lastObjectIdx =
                                         idx;
                                       for (int i =
                                              0;
                                            i <
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
                                       } }
    public java.net.URL getUrl() { return url;
    }
    public void setUrl(java.net.URL newUrl) {
        url =
          newUrl;
    }
    public org.apache.batik.transcoder.wmf.tosvg.GdiObject getObject(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                 objectVector.
                 get(
                   idx);
    }
    public org.apache.batik.transcoder.wmf.tosvg.MetaRecord getRecord(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.MetaRecord)
                 records.
                 get(
                   idx);
    }
    public int getNumRecords() { return numRecords;
    }
    public int getNumObjects() { return numObjects;
    }
    public int getVpX() { return vpX; }
    public int getVpY() { return vpY; }
    public int getVpW() { return vpW; }
    public int getVpH() { return vpH; }
    public void setVpX(int newValue) { vpX =
                                         newValue;
    }
    public void setVpY(int newValue) { vpY =
                                         newValue;
    }
    public void setVpW(int newValue) { vpW =
                                         newValue;
    }
    public void setVpH(int newValue) { vpH =
                                         newValue;
    }
    private transient java.net.URL url;
    protected transient int numRecords;
    protected transient int numObjects;
    public transient int lastObjectIdx;
    protected transient int vpX;
    protected transient int vpY;
    protected transient int vpW;
    protected transient int vpH;
    protected transient java.util.Vector records;
    protected transient java.util.Vector objectVector;
    protected transient boolean bReading =
      false;
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hiF6tkb1KlwR0FoNo+R0VpZHAV/C52Rc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "eT4/c/v/Adz30aTcQAAA");
}
