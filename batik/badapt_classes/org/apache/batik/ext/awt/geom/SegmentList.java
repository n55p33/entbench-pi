package org.apache.batik.ext.awt.geom;
public class SegmentList {
    java.util.List segments = new java.util.LinkedList();
    public SegmentList() { super(); }
    public SegmentList(java.awt.Shape s) { super();
                                           java.awt.geom.PathIterator pi =
                                             s.
                                             getPathIterator(
                                               null);
                                           float[] pts = new float[6];
                                           int type;
                                           java.awt.geom.Point2D.Double loc =
                                             null;
                                           java.awt.geom.Point2D.Double openLoc =
                                             null;
                                           while (!pi.isDone()) {
                                               type =
                                                 pi.
                                                   currentSegment(
                                                     pts);
                                               switch (type) {
                                                   case java.awt.geom.PathIterator.
                                                          SEG_MOVETO:
                                                       openLoc =
                                                         (loc =
                                                            new java.awt.geom.Point2D.Double(
                                                              pts[0],
                                                              pts[1]));
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_LINETO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Linear(
                                                                 loc,
                                                                 p0));
                                                           loc =
                                                             p0;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_QUADTO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           java.awt.geom.Point2D.Double p1 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[2],
                                                             pts[3]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Quadradic(
                                                                 loc,
                                                                 p0,
                                                                 p1));
                                                           loc =
                                                             p1;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_CUBICTO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           java.awt.geom.Point2D.Double p1 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[2],
                                                             pts[3]);
                                                           java.awt.geom.Point2D.Double p2 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[4],
                                                             pts[5]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Cubic(
                                                                 loc,
                                                                 p0,
                                                                 p1,
                                                                 p2));
                                                           loc =
                                                             p2;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_CLOSE:
                                                       segments.
                                                         add(
                                                           new org.apache.batik.ext.awt.geom.Linear(
                                                             loc,
                                                             openLoc));
                                                       loc =
                                                         openLoc;
                                                       break;
                                               }
                                               pi.
                                                 next(
                                                   );
                                           }
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.util.Iterator iter =
          iterator(
            );
        if (!iter.
              hasNext(
                ))
            return null;
        java.awt.geom.Rectangle2D ret;
        ret =
          (java.awt.geom.Rectangle2D)
            ((org.apache.batik.ext.awt.geom.Segment)
               iter.
               next(
                 )).
            getBounds2D(
              ).
            clone(
              );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.geom.Segment seg =
              (org.apache.batik.ext.awt.geom.Segment)
                iter.
                next(
                  );
            java.awt.geom.Rectangle2D segB =
              seg.
              getBounds2D(
                );
            java.awt.geom.Rectangle2D.
              union(
                segB,
                ret,
                ret);
        }
        return ret;
    }
    public void add(org.apache.batik.ext.awt.geom.Segment s) {
        segments.
          add(
            s);
    }
    public java.util.Iterator iterator() {
        return segments.
          iterator(
            );
    }
    public int size() { return segments.size(
                                          );
    }
    public org.apache.batik.ext.awt.geom.SegmentList.SplitResults split(double y) {
        java.util.Iterator iter =
          segments.
          iterator(
            );
        org.apache.batik.ext.awt.geom.SegmentList above =
          new org.apache.batik.ext.awt.geom.SegmentList(
          );
        org.apache.batik.ext.awt.geom.SegmentList below =
          new org.apache.batik.ext.awt.geom.SegmentList(
          );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.geom.Segment seg =
              (org.apache.batik.ext.awt.geom.Segment)
                iter.
                next(
                  );
            org.apache.batik.ext.awt.geom.Segment.SplitResults results =
              seg.
              split(
                y);
            if (results ==
                  null) {
                java.awt.geom.Rectangle2D bounds =
                  seg.
                  getBounds2D(
                    );
                if (bounds.
                      getY(
                        ) >
                      y) {
                    below.
                      add(
                        seg);
                }
                else
                    if (bounds.
                          getY(
                            ) ==
                          y) {
                        if (bounds.
                              getHeight(
                                ) !=
                              0) {
                            below.
                              add(
                                seg);
                        }
                    }
                    else {
                        above.
                          add(
                            seg);
                    }
                continue;
            }
            org.apache.batik.ext.awt.geom.Segment[] resAbove =
              results.
              getAbove(
                );
            for (int i =
                   0;
                 i <
                   resAbove.
                     length;
                 i++) {
                above.
                  add(
                    resAbove[i]);
            }
            org.apache.batik.ext.awt.geom.Segment[] resBelow =
              results.
              getBelow(
                );
            for (int i =
                   0;
                 i <
                   resBelow.
                     length;
                 i++) {
                below.
                  add(
                    resBelow[i]);
            }
        }
        return new org.apache.batik.ext.awt.geom.SegmentList.SplitResults(
          above,
          below);
    }
    public static class SplitResults {
        final org.apache.batik.ext.awt.geom.SegmentList
          above;
        final org.apache.batik.ext.awt.geom.SegmentList
          below;
        public SplitResults(org.apache.batik.ext.awt.geom.SegmentList above,
                            org.apache.batik.ext.awt.geom.SegmentList below) {
            super(
              );
            if (above !=
                  null &&
                  above.
                  size(
                    ) >
                  0) {
                this.
                  above =
                  above;
            }
            else {
                this.
                  above =
                  null;
            }
            if (below !=
                  null &&
                  below.
                  size(
                    ) >
                  0) {
                this.
                  below =
                  below;
            }
            else {
                this.
                  below =
                  null;
            }
        }
        public org.apache.batik.ext.awt.geom.SegmentList getAbove() {
            return above;
        }
        public org.apache.batik.ext.awt.geom.SegmentList getBelow() {
            return below;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+Bayu0L897LY/yXxisPV/wAxIgui+hcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "On52o5P8/p2/+47ffu472Tnm/wAbpJjilSIAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Gv4H7jrtwKYgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2fzOmAMS0dO+zV9y/uLyc1f/9WXoIQm6qR5luaJsJ6W7kEBmFx2nviATPtd+" +
       "Pks7pCQvnTjud190qmemvehST2MdeC+hy/frF7zolWOn8vyRLjx/UY0uQdUL" +
       "fdCkqrxVFn/9rF4+/lfg7xJ4/m/5lPVlxSHNeAI7ynXee5Ls+CD4XosO4TUC" +
       "Un3fPaS6kLMqPXxZ/c35177y2eKN1w/eS5FB/gPV7rXSuHOxUwazF+4TkE9z" +
       "0L8Y/+CbX/9j8UcvH2nvI+dZde1+rDpvIUe+4+BnV6fWWBnB9NsZwbgsZvkl" +
       "EBUebN7u3q6X3x+6uxAeKF/fD8JHVC1oQA/DcmW7wn8WA1dmq7eOhSCCBQ6w" +
       "gltbu3uM7s0K3VLfbh9WBRdwnX3HuAJRPnY6GO2BBcbP/OdPfvnvP/9VIDcK" +
       "ejAtNRyI4syMTFKuuX7q9U8988irX/uZKhoCXyN+5IX/XmWw5v0oLosPl4V8" +
       "TOrTJalclVDSchRPqwCmaxW193Ues9ByQJxPjxYU8CtPfHX3mT/5/GGxcNFT" +
       "XADWP/7qT//V7U+8evnMEu35O1ZJZ/sclmkV0m874vBZI7jLLFWP0X9945Xf" +
       "+oVXPnbA6onzCw4crKc//+//z5dvf/prv3OXXPeK7X0Xgo1v/CuiFZH94z9a" +
       "kORlpjYMN655RdwkOzyLjYldYSpZ3436yTIy9cmaICWmFUkUt1VxCVGa3VVo" +
       "NSV70/aavak8H1EUVxdiVhjszEV7pJq7vow1A3I5Gc5JW5iq+E6jJzo59wbr" +
       "CTYi8VDwlZqLpIWeqXoLC6WJ2GbhVO8hSGoYBpLyCIrLTsEz1IhZSG4zawS5" +
       "qHnKqL+npdAX9yu6aQ6KDJ7EjDZxxW4T6XmkFwi1RWNDUEuLoUd20xeG4tZX" +
       "N+hCYdf+1BWWu9gfbPExv/QXaj23rKBj7/FiNI5MJbDIUCGbuje3Mo6f8BIV" +
       "4s7E2SnCmiD6k2mBwxi3oFGKdGooQaW7kCeTkND6wFv1azAScoMdEqf0Opj3" +
       "EqEu73KyKfQWuBCO1gqK7/ZZriFSm9cWsjtYKIbvd7cWi+3bw51NJlYtrSEF" +
       "DcvTmJgueEqt80tdnS2jXrxaNLZjmfOnTWUlE1xKCI3aouNzEuUQRX8byVxX" +
       "npNNXsUcGtjLiMprk3gVGTTMNpd44q/8YW4CP2VtyJwaTCd6bT7WF+7ADJiC" +
       "HWtkxiJYK1Uxq00v6by9XNIp8C4NuDMZxxORdDok01qNdmyfG/IiaQqUPxN6" +
       "s2DfXHjUbunI8jAil16wC/wpS4VJRHEqtcWVBlubDDgtNts+ytd7Sw83zEJZ" +
       "2CBmjHohrXpUbmiiLe7NceouOqkZsSLbR6eMZWfT4TQ0tXp7Qi+3li9tJBxf" +
       "e+hm2yWA6jLceDYWtro7Dpe7JoZp5IbHOTEe5RaG57N9NvLceWssD8m9v6cW" +
       "Ni1s9jLDbc3OdrFWzEEkcHMc2QAlFRaOPM54064zE3VHSWgttb3uetkNe6Ol" +
       "3MA5k2fcYFJYNSkaBFyCx1TbCQR3MMwW1r5H72iRdsluYm36w6wYYJk5cxux" +
       "qiasjISd0RSTnJbkECtfERcO0NWBxkY0CvtdOtgO1sVcToKliZqsqu5RRRtJ" +
       "HSyTcGfashbifpq0YqJRwDmiR2x9XrP8sdNvTJOOnBiDbaBQetyei+Mg8TZe" +
       "gxLWRb85nzR4umcQzT4zHXSFeOw5o+aqEANhKA1kW4DFDpwhFmbS1GiA8waW" +
       "yCNXM3h1x0S0gWXrjd/H9bpJzZgcN+AIIe31bjETUH5n5b4VrN3Brq7VFJXD" +
       "CYIjmWSxGASRsV1sOsqaovztvBBzDGjk2lNbmB6s68WGbAeJys8LbjWoc9MZ" +
       "Ma5Pkyle36Om0ZsRZI7PYWWftYD4p524wQgzZr1y0nRVjCIjGbv5aLxZd02O" +
       "lBdEbO7pUJ6i+0bbIedxq7uxEVq1LYFv8VsmkzsjU5iiHjv0ojidTxXFjjqd" +
       "bjIO+9G6my2lQTSqs+1+nriI5+FK5hk2mTd4Kpd7qq5sBXGiUIMmV4xzKp/z" +
       "nFRbm8zU2W5Tvelj+Ern7I3HofYaaxWaZDskRomcWWdtQeptKa9VoOaUyARk" +
       "LY9Cygpcq0u7VN1AtmIN7hixu8B3dacvZvvCI9ekWbPocXc8YbZrHU0XXS1u" +
       "I4lBdG17U+sCQgayqjAbjFP29UGzuVEGrU2ytLGOQGw2sITrjOVmVO7sXFPM" +
       "+1iCUt3BlJqGebLfSdp4PbRCB7GpnBNX+a4R5QxPpAs78ZlZq5ZlmdVU6km9" +
       "3bKBB9rTvTzWZn1VWmdyyBX4QEUpMatLTJH7NcOAs/Uqbke9ppv7Rsvar2wY" +
       "nzukNhtKDIrmTbO+8zO6WVNgzGWQWl0tWGS5HqxX4+5wTHZ7+MTub7ihM27X" +
       "OrVYQJBim6nhwmvn+Hiixey8JvKT4YRCO5yP+WzWRF2wGB9awaIv1se+NS6W" +
       "Gb9fhtzYET1n1kuaCOXMe2hCx1qTxCfTTktyDUUc0EV715b5Thv8b3qai+d4" +
       "7hXhXs2GeHOEJju9XRSc3V1ZbJYKaZHC0q5HartB38RG6WTAirm96kv4pANo" +
       "2MISPMy7zFDWeTOKjGJMwPN01RTqNNtr1yTWd4p2uzcwYUXB6mgSd7ZLvo6l" +
       "M6ylz7EdhYrDXSeklhHemrZqSapMtHTljer9fLBY2BitLNkNi633I3M8b9dX" +
       "KmsQSIKqtYhmOK6z23J+4i+kyQp3ycasnwS7Rt8dN9ZEEeIBoaLCet3cOqFP" +
       "8u2duRNQkt4HdrJgcnPVixaplCJB5s26SG2wlNw+h9ajXmfEEwneirt1vOV6" +
       "9DCyJ92QnMt1Z4Avh1t4JiUL0W1HRb8xJNvUoMZ3wsDa9tTNfol2VoWqm6t6" +
       "su3NsiWBI83xktqGbj/jVvshgRLKCENYYrUN02GmwWqUtCbEpjOJjCbOdCOj" +
       "0+DrhY7CKsr1a4tFKmT5KKJm1LxrzAIDbploK91oOs7HywmOLHcTEkXoKdvm" +
       "a7QWG/Bs58lCsNC0OBiCwByse4PJXLCjhK8P4wE26C0H7UkzaCMO3XEGKttV" +
       "2nHWIrRJTpuETOTG0vPsWO94y2a+rnforL1ek0Zhsyi5rimmsOnNepzV4YKg" +
       "gVn+aMz15tbI2vTSQKvzTHuoxb7V6Yj5aqfO9g1dr8ctKakNeSUgGuF2kqUe" +
       "1e2h05kvTtx4GmEJHamtJbYBucxgkToNeDBLMY/j91afTCgboZBOvSOJcQFT" +
       "QmO9bewzCbCuGwxYT1212xGdBbuR4aYgNOiL/RAhqBo20jDTavD7+szcMdam" +
       "7UR4MnJ3Ld4UQ9Hw0LlpoA1xJhd1Q0w9eJbWIovUpNFILEQTgbNms9ZTpwa+" +
       "U6fWVKZaY9FeBjqaKIac87bP+ZpSDFmuEDUUxMFW1+lKuCtvl9aO7eD9/YSP" +
       "1ovmyla4OTaSLcmjWnTd53terdbUt34gCqTA7HBJETqdZkfoOx2iztg+UJR1" +
       "d7VCPL0jbhkbxqhsxhgGA/wbTq15QYfrzSimh5KysYm+xm1DG52EdkG1fLpj" +
       "ccE8sadRBI+Y2TxtiCw9m2paXZ/RGw5DC6WXTZEu0zSWK8N1VHLNehSIiiFT" +
       "xHA3h1F03IORRszYrO/5/FBjxdpuLa4a3Ya5HA7srT52W90WudIajTjVQVxd" +
       "jrttaeAtXDbtWPZ6aOzRPuVLSyZUMkHqoK1lr2DsDI1cgZupS2w33A4ptiep" +
       "8NYXOYNm6qu2uN6Sg724muDjHRL0NcZ3hKa8XsZ0MVrM2XWb83tec9of7zXD" +
       "FhdYKFIWMtoAxqpsoyA4d8JEybIdjvUk4hrNdCbb633ab2oFgrO4JU1cwUwG" +
       "jGoUxWTEt4H/GbQ6LYrQXEuk9jWHC7ai1VXtVSddtHtpGnK0YPBb1KFweSKx" +
       "eeBLgrmXQIouT1kFTyJ5ti00QkG66YpTPZteen2H7co1dAq0IEWwVF0ySIfm" +
       "9l0NHm6txq6Gz/O8PhxO6CBBsKmoAMWy2E0N1iNtynRNcSxHWp3SGSmTWvy6" +
       "L6DrqDOkaro33WrtScfClzsR2XSCiFCVDR9Y+xEugSwx2cQbHlnIrXazkaiG" +
       "sUPIhqpukWAzzKTcl7u2h7ebchvnF3bqWaqek6iIIwluo+aIGITb/b47GLaE" +
       "WtwauOSKM/pzxs8U3kMti4klgxwLptOwNgQaRqG8Lkw0x/lUaS9TG2d0g1FM" +
       "0bVXymygNbpOk/U61KprtJFUG7KjsWrUsQCbhRt8P/TGk24jG84CbhzXUW+S" +
       "bEaeTWx7+nJBN8Zagw26HPAGG38V7C1f1HKdbA/SJeuBCMnUevvUUHfKuD5B" +
       "exq3F5dW3QooGA439a6PTYD1bhbqNtqFtTAfoRHqIt1m7ruA+y0sgMeWWxvG" +
       "+ECzFVFsaDW1FndDEIqdEdchRvE4sCK6SQiKI7aF/nIo1tA1C9OrYS2LthG3" +
       "tdawKksE7PdA7iuYmUSOZ805UdAc4a1xzRils15BbIeLtjruL1uRMAPh2Bxa" +
       "w1YtcDdBGGiLgojgGmvB+x5uBiIiyGqR1gM3dfyeyg0ZtItaK62GDNrNcXe6" +
       "re17kq7WCpVFV2I4ySd4zpD+wpbHxIheYfly1Fju2vEkWPWQYqGnPaEtt3ZL" +
       "VmbpoWshTI+JUaLrjE1GrVOIGMuRTjfackTQblFPRKRB16lBJNk4UG9H2Xd6" +
       "E263Ztw55bRZG6QZQi/NsVgBC9ykvnLbSq8GeDKtaxMlGGJASPt9piMpwfPd" +
       "PqMJGonO2cBsBf2R4YlFZ7VmrKiVT+tLZxLLk/4mWwSYxY0Tc7jsERll7Pld" +
       "lI5w3RBaVq53hzNuJXpr22hp9YAPWj1+J/EYZwqdfVOKc6ct9dMlqizM7cCB" +
       "R9pSX4xqOBWbwzpL9dT1Jo6RRpjbKmOs9qZajLEZiB0rY5y2iO42jLPJ2gSr" +
       "9h8ul/P5W9tRebzaPDo5X97a3bJBfQs7Cfnd9qCrv6vQhTPJi3vQTx3vMYbQ" +
       "M/c6Nq52Rj730Vdf09ifbxzv2kUx9HDs+X/D1lPdPjNUeUXiA/feBZpWp+an" +
       "+7hf/OifPs1/cPPht3Am954LeF4c8henr//O+PvVf3AZeuBkV/eO8/zznV46" +
       "v5d7PdTjJHT5czu6z5xw9l3H3BSOOCvc52DgohZcqrTgIPv7bOl/4j5tnyyL" +
       "vxdDj5h6PPASV4uaw+Odxu87OTqoDlgXugoING39CKJSpZ9+K8cDVcVPnT8U" +
       "eRY86hHt6veG9gsnIC98R+fG1UifuQ+n/nFZ/FwMPSBrh5sa7hlTCmPoCghW" +
       "2iljPv1dMOYdZeW7wWMeMcb83ivF5+/T9kZZ/EIMXbNivTr+rKC484J7+/3w" +
       "O+b9E6d76+TRWGXLr53y6Re/Cz7dOMbDOsLD+t7z6Qv3afvnZfEb8eFc9G46" +
       "8YB1dFuqIvU3vwtSb5WVL4Jnd0Tq7ntvKxeQv6p5iWIfTgy/fB8ufKUsvhgD" +
       "b+3bVnws+c53fFvjFlf2W+hRYsfRKbe+9JYOHoEHOzNkeZr91B33yw53otRf" +
       "fu3GtXe9JvyH6g7Eyb2lh2nompHY9tljuDPvV/1QN6yK3ocPh3J+9fMHMfTM" +
       "fSkF2lH+VBj//qHPH8bQU/fqU/qXLD4L/bUYesfdoAEkKM9C/nEM3bwICcRS" +
       "/Z6F+y8xdP0UDgj68HIW5OtgdABSvv6pf5eTp8NJZ37pfNw/kd0T3052Z1KF" +
       "588F+Oru4HEwTmZH54lvvEYxP/7Nzs8frn+otlwU5SjXaOihw02Uk4D+vnuO" +
       "djzWVeLFbz32Kw+/cJx8PHZA+NR8zuD2nrvftcAdP65uRxS/8a5/+kP/5LU/" +
       "qg7C/h/H3kL81CkAAA==");
}
