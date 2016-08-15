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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e9ArSXWfvruvu3cf9+4u7C5r2GWXXQwIfyONNHqwGKOR" +
       "NJqRNNJoRhpJE/Ay7/dD89CMxsHGVBmwSRHiLBiXzf5B4XJMlke5IC9i15pU" +
       "bChTNriIIUlloRw7sQNUIC4/Cpw4PSN9j/vd+327l3uxqqZn1N2n+/zOOX36" +
       "dE/Ps98u3BL4haLnWhvVcsN9OQn3DQvZDzeeHOz3hwjF+4EstS0+CKYg7ynx" +
       "sU9d/Ovvv1+7dK5wK1e4j3ccN+RD3XUCWg5cay1Lw8LFo9yuJdtBWLg0NPg1" +
       "D0WhbkFDPQifHBbuOEYaFh4fHrAAARYgwAKUswC1jmoBortkJ7LbGQXvhMGq" +
       "8NOFvWHhVk/M2AsLj17eiMf7vL1rhsoRgBbOZ/9ZAConTvzCKw+xbzFfAfgD" +
       "RejpX/rJS795U+EiV7ioO0zGjgiYCEEnXOFOW7YF2Q9akiRLXOEeR5YlRvZ1" +
       "3tLTnG+ucG+gqw4fRr58KKQsM/JkP+/zSHJ3ihk2PxJD1z+Ep+iyJR38u0Wx" +
       "eBVgvf8I6xYhluUDgBd0wJiv8KJ8QHKzqTtSWHjkJMUhxscHoAIgvc2WQ809" +
       "7OpmhwcZhXu3urN4R4WY0NcdFVS9xY1AL2HhoVMbzWTt8aLJq/JTYeHBk/Wo" +
       "bRGodXsuiIwkLLz0ZLW8JaClh05o6Zh+vj164/t+ysGdcznPkixaGf/nAdHD" +
       "J4hoWZF92RHlLeGdrxt+kL//t95zrlAAlV96ovK2zr/+x9998+sffu7z2zo/" +
       "cpU6Y8GQxfAp8aPC3V9+efu1zZsyNs57bqBnyr8MeW7+1K7kycQDI+/+wxaz" +
       "wv2Dwufo312+42PyN88VLhCFW0XXimxgR/eIru3pluz3ZEf2+VCWiMLtsiO1" +
       "83KicBt4HuqOvM0dK0ogh0ThZivPutXN/wMRKaCJTES3gWfdUdyDZ48Ptfw5" +
       "8QqFwm3gKtwJrlcXtr/8HhYkSHNtGeJF3tEdF6J8N8MfQLITCkC2GiQAqzeh" +
       "wI18YIKQ66sQD+xAk3cFoc87gehKsg/FtgKFbrBWIVoWXV9igNXL+5m1ef9A" +
       "/SQZ3kvx3h5QxctPOgILjCHctUALT4lPR2j3u5946vfPHQ6MnaTCQhl0vb/t" +
       "ej/vev+o633Q9X7e9f6xrgt7e3mPL8lY2CoeqM0EDgC4xjtfy7y1/7b3PHYT" +
       "sDgvvhnIPKsKne6h20cug8gdowjstvDch+KfZX+mdK5w7nJXm7ENsi5k5FTm" +
       "IA8d4eMnh9jV2r347j//609+8O3u0WC7zHfvfMCVlNkYfuykgH1XlCXgFY+a" +
       "f90r+c889Vtvf/xc4WbgGIAzDHlgvMDPPHyyj8vG8pMHfjHDcgsArLi+zVtZ" +
       "0YEzuxBqvhsf5eSavzt/vgfI+I7MuO8H12t21p7fs9L7vCx9ydZSMqWdQJH7" +
       "3R9nvA9/7Q/+opKL+8BFXzw26TFy+OQxt5A1djF3APcc2cDUl2VQ7799iPrn" +
       "H/j2u/9RbgCgxquu1uHjWdoG7gCoEIj55z6/+s9ff/6jXzl3ZDQhmBcjwdLF" +
       "5BBkll+4cAZI0Nurj/gBbsUCQy6zmsdnju1KuqLzgiVnVvp3F58of+Zb77u0" +
       "tQML5ByY0etfuIGj/JehhXf8/k/+zcN5M3tiNq0dyeyo2tZX3nfUcsv3+U3G" +
       "R/Kzf/SKX/49/sPA6wJPF+ipnDuvQi6DQq40KMf/ujzdP1FWzpJHguPGf/n4" +
       "OhZ+PCW+/yvfuYv9zm9/N+f28vjluK5J3ntya15Z8soENP/AyZGO84EG6lWf" +
       "G73lkvXc90GLHGhRBJ4sGPvAcSSXWcau9i23/Zff+Q/3v+3LNxXOYYULlstL" +
       "GJ8PssLtwLrlQAPOKvF+4s1b5cbnQXIph1q4AvzWKB7M/90NGHzt6f4Fy8KP" +
       "oyH64PfGlvDOP/nbK4SQe5arzLon6Dno2V99qP2mb+b0R0M8o344udILg1Dt" +
       "iBb+mP1X5x679T+eK9zGFS6JuziQ5a0oGzgciH2Cg+AQxIqXlV8ex2wn7ScP" +
       "XdjLT7qXY92edC5H3h88Z7Wz5wsn/EnmSgoPg2F451YZ2/txf7JXyB9+Iid5" +
       "NE8fz5IfzXVyLizc5vn6GkzyIdBuNqHoYObbjeW/B789cP2/7MoazjK20/O9" +
       "7V2M8MrDIMEDk9RNkW/ltC8NC3fmhuXI4f6MHm7dWpbCWfLmbQ/IqUb0hkOI" +
       "D2a5Pwqg3b2DePcpEIenQrzd890QKEKWsuxOLsNuWLgAgvztdBmcbZqUr9vA" +
       "n653AR309nu/bv7qn398G6ydtMMTleX3PP0Lf7//vqfPHQuRX3VFlHqcZhsm" +
       "50zelXOajexHz+olp8D+5yff/tl/8fZ3b7m69/KArwugfvyP/+8X9z/0jS9c" +
       "Jba4CQTzJzRE/gAaurjT0MVTNPSWUzSUPVJXqGY7ePLKsxPMvfXFM/fSA+Yu" +
       "7Zi7dApz4hnMveYy5u4Ci4Jwyx0hJVfjT7pG4b0S8HXPjr97TuHPeNHCu2nt" +
       "La7GlfkDcHXvjqt7T+FqdS1cLa/Glf8DcHXfjqv7TuEquRau5lfjavMDcPWS" +
       "HVcvOYWrn7kWrvCrcfWOH2BQ3r/j6v5TuHrXi+bqNv/QWT56irOk+ThfMj8l" +
       "/tvJN7784fSTz269jcCDNWGheNruy5UbQFkg/8QZi5Gjdflf9d7w3F/8d/at" +
       "53ax1h2Xi+Dhs0RwMFVdOoqBWDkLdbL8958Q/ruvUfivBz0+sOv5gVOE//SL" +
       "Fv6dbu5wtuzl9d97JdBTuzvEcxLUB64RVBm0/rJdLy87BdSHXzSo8wIt85Lu" +
       "bIMeOs/dMsQCcxNc15J55wTHz7wgx9tm9sDS5BZ4v75fyv7/+tV5uil7fA1Y" +
       "wwT5bhugUHSHtw74e8CwxMcPIh1W9gMQgD5uWPXL7SYL9fa3W1YneO2+aF7B" +
       "mLr7qLGh66hPvvdP3//Ff/qqr4MB1C/css6CSzAmjvU4irINwXc9+4FX3PH0" +
       "N96bL8mAUth3PPG/8+2V3zwLcZb8yyx59gDqQxlUJt/lGILpjcxXUbJ0iPaE" +
       "cm623OtAG77kNXg1IFoHv2FZ6CwmIkuzxQi2p6MuzDs1wVPKPhMOZ5ik2+22" +
       "brNdbMVHdrlTipc8T47Mpj7nOIezbdwWBCJincp4VjWsedLqsy7uNuiJx6y0" +
       "6sSiG747Mgy80mQwxlxBbrsFE2PVq6HVeiVIx/VxOkZGkUSWkGJFgNcLZR1B" +
       "Ur3ZRCoVJFrIzYba3cDTETYeJZIGq+VVYtG+b5qbYd8IZxuBgCcWrCi9iGuO" +
       "hDnb5KXuZmGt59OB2WNCi5kPfWvg2j5d27AJFiC6uZFonoZNZiB4JG9hKd0b" +
       "DPz1nOGXPmtP+zOaFZZzo9wPZmOKa3PEWmSWK4VxejJc6k1bm1HcY5KhaTYW" +
       "HCSWozZLRrVAqoRUQE3XIjVVjfK0bqlzojLvC9KAwLqNlF6WHIyIytws2axW" +
       "PR+OJdYRWVcL5vBqrgjdQdJ3+iV8Iq4XPADfbPDaWK2jbNeZSqTABik3Ycpg" +
       "Udnpo3xY4S3GG81ZmZki7Q3ad4KamBB8g+BGrVonsbEJXY4qWElTJnW2tDIp" +
       "p2a08Vnd1NxSm3T6w2HSR8nBfJ7WZGLTqkoDLlqP9RkuFFkr1DgOGYRIg3dS" +
       "ymfX/tqyemCR1ff5ftlN1U2bxFQTq7asgVBbze1yHyFL8Gy9GnFGINjuylz5" +
       "QdCTazFL9EZL21oqrjQftjYC254aRUtHFZKIPMuzZctm/RIqWB3Yr5qdlTEh" +
       "IoNHItUdsXC3OcB0S+11bLVFwxwyInsYX+q3qRRCaQ5nAwjV4FbY7mMw15bx" +
       "+ardN7sYT7ds1/T55TAWpt2GoA2qU2mKtkwE49RZTPOlMaPVWBR2xXlNXi/6" +
       "3EotbyZjtE/EZFBRjMW4Ped8y94sKGi4SYS1E63qU3bu0d3JeGla7HympMRk" +
       "pETEKGyhvDWMWyVsuZ7Sid6cljaDqktIKGKvimmNotSkWlTAWEqrdLFP+eSw" +
       "iTnKuloZ+F1IrqSQVZuaEtOoepO0u+pIZUak+uloLMlle14JezNS76Cj+bK+" +
       "7OEk34GhalXm/Pqqt6ZnFtvf2AtpOpdaRrSyoPnM5Y3ZmtBW5f5kOV3wDMPS" +
       "Q2ndgacWgaaxhbm1PgyJ7RbNmo7NdzYrZyBBMU+gbgubWBMsrbqw21lTWsD0" +
       "ijjVIwh6FhPSLIZFuruAGjaCmUpXo0qCajLISq8p3WhWUpr+VOs6eL0l6Ybc" +
       "KS8hfKiUwpZp90bKKBbUrmSg3fqEsxkQVEyS1qZaG3vq1Jj6HI4WW8tVDeY3" +
       "vdoGRBod3qCg6Rh1ZlLRc/ut/pQURaWNTWNgQbW2ltaQTsVrl5fyugatk8aQ" +
       "KHWwwEM1DjUpPBm1EsqZkvjU7U0aSrXUwalSe8JUGRJ2VU2v2jiv6d3WpMVE" +
       "i3DQ5MQSG5X9QTwekKWJ3RovuHDD2v1xGLvV5RSm1tZk0oCBY6uGcpoM+jpN" +
       "qBsmDQdTPQ77UcccEqYrhX6tHmnpYrBgfFtGloPFeEQueK6vYzTKVIWRxxKK" +
       "ywhzsjl0q3Ir4Mb6piGjljfoNBCqI5fmYd03qgazGiCrmByP6W67h/Qry1lK" +
       "JREyV8oTNxkqcNFS5PFiOpyG8KiTOkNDGA0Qq6d39HLRhjqd0kZcO0yjWaIU" +
       "IrWW4+KGISqluK1UqQk8jhViozTCjq3h+NxDiRkudUhrJRnmEksxzUya5UFF" +
       "SyyfcpI1OmwDVaQCisRjWIX6a6FX2gT9ODLQdZgORGyx8ce1VIiK4wW1WJdU" +
       "rRly7Nxt1matCjeHZYYQyJ5jkCtHGUmrUX+g0HVxDi0QuFmsQv4wIsttI55j" +
       "qJ1igUrqvW6sxVTax8sVZIXI4/qiEdVCF1Frs0Zl0uBmDO/3R/x0pbWspUBj" +
       "vhFP2uyc6Npq2eeCUtBtWpM+XmOXq3GTrYexPaPWw1p9Gupo25iPe1wJHqnj" +
       "ihItMaTvKgJUxklYnJqLriUZWBpVnZgKF1alV+NLDj8jKlRIVsZQY0CX0E08" +
       "6/bjkJsoVoPj4k5LV8LhGIFsJW7oiQJX5WTe0xBjCi3WaczNgPeuVkbQqugg" +
       "cI3CI4FBBpxU8UNpQHtBPNzEc27ZaUp4M57rZW7S7Kx9kvKHq+a0U28McTxC" +
       "3ThFy2VvPVml2f5cr7II9YQvQlDFmGKz4sKU1dVstVjNnAGb9GFy2hr6Xric" +
       "JCOZbEh4msjMmDX7dFKeWbLoOyzTaTVij6qIq1k8NZbjerUJKXVLKpbqyapC" +
       "dsGsIUJ+vwf8j6uDelgFX0cK14Eg3Q8gidRXc0hfoCUxwUdFqiv7CygKIYiM" +
       "mxs8EAdee1YshvXqWlCommUkvZVUacUeE8LCxtqYxEavh7YimxW3BltUQ2V0" +
       "r8Zw5aDfcJum5/VGRRhDRugmsCXCcyheTMimKc1L3ISycbwRN+LU78CLqKEa" +
       "FIxGCl9J6XYMhtmEd/yEmw7rtWaJCdvFLpjeyg65AZbgkDVn2PAIbd5dBX2z" +
       "vWGUBGNlFFZozLBNrZWijGVwbMVp9IjmQjQ708HSC+B+d6omFGHMBzG9GAXt" +
       "VJgY46JL+liJdEtwQiMlxh3x9mQ4s3u8MG7hGz4Ze2XKhW0NQm2vtYLpzZAO" +
       "8MEUtTbLqEk1MT2NGdXXi0tdaiEQJy3njVV94XeAD+OSpdqlYBtfapAXKW7o" +
       "QXGZJ5hZVR+lAV3rqjQxmiZDloMnEF6p6o2OU4E0VBewNtInRviCa4/TolDi" +
       "B1PNWQnTKl5NXX6h2U0I4dFJPG7y6wAplRGEWieQsJ6JQQuEJmEbXXPFgdVl" +
       "A8OdVOcKY0iDec8QCY9V0lqpUet2xrXGYmYszP7a9JccMabWxbXTmMLQmiPU" +
       "xWYzHfYqoWb4RGiSQQerCC7dxprIpAi1R5353Ccox+33WW8qmJvpNJpGDLJc" +
       "8os6xVGW4EtiWKfZuGpp/SExQ4KO05pWjAaB8nDJ81tp0upArRaYRUSO8tAp" +
       "sfD0moGtBKE26qDjhTvyDJUrN2203KJXpGark0GNRpexNqVtMMU0om7bq/Sn" +
       "7a5Fmuw4rsRLr1mV/RRp6fwaJ+MyOiWxGl1Nhu2qVUzBPCbUUZyfqBNI8RMd" +
       "rXctIipGXMeNGkutaNF1a2CirtOEqQGBk/JcX5T7RBNd48RiZVAzwM5Yrxim" +
       "UiIGnNgczTF61KgbXmfKERCDtTs1q7E0ZA2dMt0OWceIetjoDKJZl0dEaaYo" +
       "Q0svRvw8aCKrBit7Lb/U5BKnvqi7UR1u6sXQLAnOpBdV60nqxWxt0ZhEK1xp" +
       "lfGNwJmS3Oq3jCow7LpuJ3h5nSZCS+jPlBaT0sZGZVmCidMKQ5tpW0SjoT5V" +
       "qAEHpw4F+TKepqZHLaOESsJ5rwyJMKVQs4Yql7wWa/dgqFHHIAiugckHH3qL" +
       "4Wi8bBrohg9RWlLqyBitasNWjKBO14FkeJgalUYtCJpzJEYcYohVaNMZ18pp" +
       "mJpNjJKoOdUYKQjfoqpKk4HkhQ4xRqnaoaXR2vRiMHcLSq9aktBpG6+U17aO" +
       "wB4cD5SOWlqsgtamZ89NapSOWlpJwd0SOZnFS6QxWa76NDvqk+3Fstl1el1d" +
       "5tI2WFYiEluzTUeamgrT7IpSr9QjwmmADDfrylAHk02ZGftci6ZK1tBC0WLQ" +
       "MJplqMIhzY3CVoYORYpqpzL3vSQyPXw19rQypwqtAHfK6/6iLdfHTXLmjeqV" +
       "hiMJaLvqIo7I1BADH+NgwFJ4O/VELEI0xdrI6yJprw191fV1Q3OdsdTZiNCm" +
       "7i8quG+55iKZWsNGpcuu7TUlhtGMDiPWqlkzi4NDetOACCxaSs1ax0rkct1Q" +
       "/BE8FCWnG5pG2O4wJjm2sdKQXwRTXZ4t7aoVjsDwnvWBR2BCooysRoa8wKv8" +
       "pDkP0agBeXYgrudwhIxSQV6MOyKO1YsB3QZwJUuDplh5KoVtMy3i/iQ0aiKF" +
       "VxvoqJF0pLaKg05ANG6orBpUyR4Ic01ivXC6egeblJdDBROWg1VpGVf7cjoT" +
       "Db1Dd2Ga1AS5qTWmfBcjF5sq1e7qDbLeF9tovwG5zDwMOIkn1RmJgqhPH85j" +
       "NtWJaGpNWGqx1JB2UbI9zK6IG3OmuriBMd1SCSnznfXCb6REmUSriWzay6SL" +
       "LeLReMOmVcKeWSrRwAmHqfbgmBR0VV7rKIPHNC2VcNn2AqJKY9Z0vJmNJ2qq" +
       "uqWAVOXhao6aM4PwGHwgDaX+cuAx87gowvPmQtBN0dNHjMMn5sIjNoY29kmk" +
       "2xSb4kwDMwbqugu0GCmtUlTFObPbV8e4M3KMlhh25nW7k8QthtZsrc6ahqDV" +
       "2wRZJorMyLTNckOORipWXSbMXBTbxVGy5it9qMG0uuYELDNQKRWksGOOjdbS" +
       "MNXlfE43+kZHZtiWqhXLI5FyCDaStKqHE65a6rUcDZeBAsdG29XGbTTUuwjw" +
       "li0LxJ6jOrxA6BmVrTpTXCHcuENVqjY5aRSNpqlS2LKhmD1zWexV+hMGovQ4" +
       "whSDq29GAURWq2MlVllk2dDQtJXy8wFdoVSxQfeqMyNptXhai9qGBhYHNiQQ" +
       "RJssqyO4Vh8HouFHw4RtecHCGLCR7lX9LkGoFRosoQm4zC6DdjyvrEdNrBqW" +
       "BpLsuXWuTVfXOR561KQ0YRrGUZ8PZvUyTCjBUDUWFj3ogmWSnVRdnFhm9XBK" +
       "q08lg2QjtDodUVqrOC+5E8jW/Eag6JOJqndYvLTZYOGigesjVe4ylVitYMig" +
       "i9Uqo4XdlNF2m+mSM4o2GEnVgXurEqtKCdSBV2GrQpWatQ2o5+f1SIkXhg1B" +
       "DaadeSdWS8ayTuIGE9pFtuua09BwHWAzuo5Pgn6/Sk5kgsDcBsL0UgABq7a5" +
       "HkEDB9RgS7OuC2S+wZNFS2VSmErEWO4zlYSgMHbQb3uhxKyG9GZASO3YVDS5" +
       "nZDhEiI5dOnPKJ1WILDuN5cgTo+k2rDZ7NsIVV6ogtofNosVv85tij4yoiET" +
       "kSkelp15m23VTFZi62LDTxe92lLqdrQWxg/l8rShmYI5mi3njjUppqLWhdwS" +
       "T1NVXaegwWYYgznS9NRmHwyPDQ0zWBeMR4SqJyUFls3UbOCTNbYW6k0wi8sV" +
       "vLHhZQqFxxOMmdBSQ8HE5VLEUmKBlUZhUJeUhBQlb0kWEWQsECpSm7WhSoNB" +
       "YrYVBWGRXmhuBfHKbFKBSv2Kjq/ggDFC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "v/7M8/mZ2/8PoItybNxAAAA=");
}
