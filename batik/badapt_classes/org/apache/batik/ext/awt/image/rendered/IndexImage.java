package org.apache.batik.ext.awt.image.rendered;
public class IndexImage {
    private static class Counter {
        final int val;
        int count = 1;
        Counter(int val) { super();
                           this.val = val; }
        boolean add(int val) { if (this.val != val) return false;
                               count++;
                               return true; }
        int[] getRgb(int[] rgb) { rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        RED] = (val & 16711680) >>
                                                 16;
                                  rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        GRN] = (val & 65280) >>
                                                 8;
                                  rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        BLU] = val &
                                                 255;
                                  return rgb; }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ze5AUxRnv2zuO4+C4B68T4XgdWjyyE9+PUxSOA1YXODml" +
           "ikM4emd7dwdmZ8aZ3rsFxVeVJVoVSgkKpvD+CQZCoRgrVh5Gg2XiIypVookx" +
           "lhqNlZgYS6lUTComMd/XPbPz2AehyuSqtqen5+uv+3v9vq/7jn5Cxjg26WIG" +
           "j/PtFnPifQbvp7bD0r06dZzrYWxI3VdP/7L5ozWXxUjjIJmYo85qlTpshcb0" +
           "tDNIZmqGw6mhMmcNY2mc0W8zh9nDlGumMUimaE4ib+maqvHVZpohwXpqJ0k7" +
           "5dzWUgXOEi4DTmYmYSeK2ImyNPq5J0kmqKa13SfvDJD3Br4gZd5fy+GkLbmV" +
           "DlOlwDVdSWoO7ynaZJFl6tuzusnjrMjjW/WLXBVck7yoTAVzH2/9/Iv7cm1C" +
           "BZOoYZhciOesY46pD7N0krT6o306yzs3kVtJfZKMDxBz0p30FlVgUQUW9aT1" +
           "qWD3Lcwo5HtNIQ73ODVaKm6IkzlhJha1ad5l0y/2DByauCu7mAzSzi5JK6Us" +
           "E/GBRcrefZvbnqgnrYOkVTMGcDsqbILDIoOgUJZPMdtZmk6z9CBpN8DYA8zW" +
           "qK7tcC3d4WhZg/ICmN9TCw4WLGaLNX1dgR1BNrugctMuiZcRDuW+jcnoNAuy" +
           "TvVllRKuwHEQsFmDjdkZCn7nTmnYphlpTmZFZ5Rk7L4WCGDq2DzjObO0VINB" +
           "YYB0SBfRqZFVBsD1jCyQjjHBAW1Opldlirq2qLqNZtkQemSErl9+AqpxQhE4" +
           "hZMpUTLBCaw0PWKlgH0+WXPF7puNVUaM1MGe00zVcf/jYVJXZNI6lmE2gziQ" +
           "EycsTD5Ipz69K0YIEE+JEEuaH9xy6urFXcdflDRnV6BZm9rKVD6kHkxNfG1G" +
           "74LL6nEbTZbpaGj8kOQiyvrdLz1FCxBmaokjfox7H4+ve37D7UfYxzHSnCCN" +
           "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" +
           "y7v7GfepJUBneWU0xPZ90cXmg/8AKFrNikgdAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "+SoIR/Ut3lL3S8FY8T0LpRbu2l3PtXFz6O64SdgC7W44lhvIXM+oEYV0I9SQ" +
           "1Ja+qw22zMYVKYd3ckpU50ufx3eeLI36Dpak+zT27Ii17SW8ZFZdUdniO39B" +
           "iHu6CXfgYYYrboPsSry/lkzF4rV4jWIBhXP1bbTAfKSO7fYxshWTkS6NWaro" +
           "7usBUu87oiFMhWVHXjTCJYUwSu636IQbTnGEp0R57GLD7d4xR6bckNWWU9/B" +
           "Taq7k1MyxV1iP99brdEYE+IePOjOlEjTpWzjhYYXrfmtuGAHChWHmyFDDX3e" +
           "EEbShFUTyd1i+w7ZDbg2tSba+2U4xhOFRFR0aUoGPCRdrrMgc3TJDGSGWzVU" +
           "Y9boclFqKAmbWpIyo9JlzVY8nyPS3SITHWc2TnO6N437LmWrW4n0cG/heuvA" +
           "dIKFK/Wl1myLM+iSHFBhk9rb/Iavi0Ouu1536/OuPgulvtiNqYZN7qa2TXeJ" +
           "ZYMPHNWxorAZMiEnJdup5s57kdOpEWFQTM0eakpsICyYLinn9cly7Bh0vbZc" +
           "Tfp4kHKiILMNdqDV63tR0WF7LY5WEjfEHLfXNPbWtLdT4gXVGgZ7rDOur4e9" +
           "Xm3U66Uy3Sl2WBr1V4qqO9TME7Gu5HaisUhhW3pbcPqgMcBRhsG83mYhbQJ5" +
           "YLe3/NTaZZHK7Bt9sui6sr+1db/AabSWaQhO4YK+Lvb03CNJLgy3q3bapXE5" +
           "lJL9XG3OUylf7sfLRdAt7J6NzNPaqG2uMVJpGG1vBjzF5ohFcrxphVxPwDHS" +
           "opgu0V+I1GrP7oJEQ8ZsbaQnPcvs7Ui65vaQmtiD/a03qu9H7sp1hZEgu24v" +
           "BC+to7Ydj4c9dKyOkoWQUo1msaAZzjYMPwikQhjrQdfGDY1dUBHZn9cnLUcn" +
           "6IGbz8VglDP8Omd6aBpkDbgR+lZ3NBmEbkQ0J6zVG3fBhKzvkpmJBiSW4GSM" +
           "d2b2dNdhuPZkqtCr/k5b5qqzS+mZGpE1spdonIVvLERNCj3FsxUzIJVt5GOx" +
           "Ptsiw6xObCiDiwmS4NkRma+bqw3nNDoFplCtKCBowcZm+2ndDRq5wlK1Jd0Y" +
           "sCqzyNyMzjQFjPeWnKoiL/RDl+eXy8AjNoiwWWLEom5202y8L9KCaMTdutSK" +
           "w3nO+aISa0yguErLlngWH7UIgmYw1eyQkcjWoz4sTexaXU+XNLxpNNltf4sK" +
           "KT9d55SlID6cr3ymwC2TEHlmo2Uq7RUdXAEjOq0LfhsxRnEzd3c2gWBmMetM" +
           "dwHZ1BcjVNOQZJs0KJT3R8WCpBrETsb9gdXbYll/Si/FgPB7+yBoeryH71Ru" +
           "zyr4uoX67WHUrK9gxTP62/raDZF8WfMGoWdbDWy7TBJ+62C8PpOn06U2GRNa" +
           "Zq5aMIrmIomIGClPG0LX4NlOPiMoyWmQEzPsdJCmFsSFTyeeDrcRGra3uI+Q" +
           "Etq3VqHQT3E66S4ICoSPjCNREUS6psG6McAHc6/FWUtGdgcR0x2mOtrMibhB" +
           "9Nx638U2e4pgNkt25rBYjtiYVMva7RbebtfQprxC1Zm9zwD6Y90MR5dKNsTn" +
           "nQx20tW6z3trC2+K2nIxX5N6i+Y0OUnqfA2zNVYfudNaZ9qtDUSCzvGBgbs9" +
           "Skm3vmm7vbrQM1q9YUumoymMk3LWhlMkZFKstq8JlubGpMluEWlB7Wx9meFe" +
           "o7+kNyOjQOme1lrmjEmxxFQZ581QzzNUbvN6Bg/ona92m9M5xpsNtkPHghXu" +
           "IpKJ9d6Aa9q92GDGexRvJN19CxMJf7pQhdk6kiIcb+iFp2eOJC86yq4dB0OL" +
           "7+lLrj9UNiTeR5RmkKzDdawNJwWyrqkr20NWoxWt0TFC6P0WxsO1RInaehPW" +
           "ZYcchPYKGUV1IyCKEaomw1yU9S0cLWp4FPbbXWHUMxZTkUoxj+ilW2O2s2mv" +
           "NwzX5A5emENqqtJTdrQXmOl0AxRhioUs1F15OGgs0Mwcb2oCOmUV3iWdhTKt" +
           "BZ0Nsl/GGbaX6uhIUVhHKwhDdDgGi3zVRbhpo8Nbg2VdVFcjQq3RBbfQmpii" +
           "wcQQo/L+oI/wzTiZ9+D+lstRZzwZ6OlGatU2abpsaOZoM5WCxhaTVsKQZqVu" +
           "QQw9brcdNZmGI67mTWM9lQq/h43nbEozXZtoSw2BhxmsXQhLH89sM+E7urK0" +
           "66tpn3PSWZEEhp6jQ9MZRv1cgSfdrapltfnKrLVgpTfHBB8hLHYfwawqT1Yr" +
           "r4u0MwF3hropWqPFCBYoB1vTUbb14b5OtRlU26drz50RLU/xkKy21Qt9jbAb" +
           "vUDtda6O3JqvJZy0yNbUemJYNNlWcF3pm8xk2tH75FRc9SdjJeMtQorWnOPD" +
           "RjaYEuwEjIDetmSLlHVyv192dEJarMz6zJs2rF3kWqu1zTWas63imAKLGdpu" +
           "MU040SQtorNQNiE646XFpq+a7M5qrfqZ2JvqZNgkvX2j6UTtaCAgjN0k83CP" +
           "bkTJ59bjQF46KzloJKYTb8byOtixybJIBl1S29YlmqYbHXu9RTGLnLH1Yc7B" +
           "GVhnCUFy1nhhePmkjMuErje3Om/hzlSdCTEmYWmO9BC2mCFhexk0Vrql7jZp" +
           "TW1O0mjC7MMFVmwGab0zR2oUygxd0+yIJL9Jl30ebtdh3XfSecMTWJu3QsPf" +
           "ZWM8RGu1ZDJUVKHD0lzfUUeCiiv8QouHRWOZ71cRySmkLIn7cagQRhuei4q/" +
           "ky0qDXFxscoiat3YBroyIp22uCI7gbCxUnO56a3NrhtIq35Xa2mzuu7kOjZv" +
           "dz0BkwO2GQhL12nV17UhmnpW4q3BkkNHDEWn5qg34otEGS1zVIEbotsIJL02" +
           "2OycYXfMB9xyCbSb4C1vH+lwVl+wpiqOrbat7nia2i+DTU3T4Q7BFOuMQqPl" +
           "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" +
           "P//aH1RHLv8PLCt3DRYoAAA=");
    }
    private static class Cube {
        static final byte[] RGB_BLACK = new byte[] { 0,
        0,
        0 };
        int[] min = { 0, 0, 0 };
        int[] max = { 255, 255, 255 };
        boolean done = false;
        final org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][]
          colors;
        int count = 0;
        static final int RED = 0;
        static final int GRN = 1;
        static final int BLU = 2;
        Cube(org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colors,
             int count) { super();
                          this.colors = colors;
                          this.count = count;
        }
        public boolean isDone() { return done;
        }
        private boolean contains(int[] val) {
            int vRed =
              val[RED];
            int vGrn =
              val[GRN];
            int vBlu =
              val[BLU];
            return min[RED] <=
              vRed &&
              vRed <=
              max[RED] &&
              (min[GRN] <=
                 vGrn &&
                 vGrn <=
                 max[GRN]) &&
              (min[BLU] <=
                 vBlu &&
                 vBlu <=
                 max[BLU]);
        }
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube split() {
            int dr =
              max[RED] -
              min[RED] +
              1;
            int dg =
              max[GRN] -
              min[GRN] +
              1;
            int db =
              max[BLU] -
              min[BLU] +
              1;
            int c0;
            int c1;
            int splitChannel;
            if (dr >=
                  dg) {
                if (dr >=
                      db) {
                    splitChannel =
                      RED;
                    c0 =
                      GRN;
                    c1 =
                      BLU;
                }
                else {
                    splitChannel =
                      BLU;
                    c0 =
                      RED;
                    c1 =
                      GRN;
                }
            }
            else
                if (dg >=
                      db) {
                    splitChannel =
                      GRN;
                    c0 =
                      RED;
                    c1 =
                      BLU;
                }
                else {
                    splitChannel =
                      BLU;
                    c0 =
                      GRN;
                    c1 =
                      RED;
                }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube ret;
            ret =
              splitChannel(
                splitChannel,
                c0,
                c1);
            if (ret !=
                  null)
                return ret;
            ret =
              splitChannel(
                c0,
                splitChannel,
                c1);
            if (ret !=
                  null)
                return ret;
            ret =
              splitChannel(
                c1,
                splitChannel,
                c0);
            if (ret !=
                  null)
                return ret;
            done =
              true;
            return null;
        }
        private void normalize(int splitChannel,
                               int[] counts) {
            if (count ==
                  0) {
                return;
            }
            int iMin =
              min[splitChannel];
            int iMax =
              max[splitChannel];
            int loBound =
              -1;
            int hiBound =
              -1;
            for (int i =
                   iMin;
                 i <=
                   iMax;
                 i++) {
                if (counts[i] ==
                      0) {
                    continue;
                }
                loBound =
                  i;
                break;
            }
            for (int i =
                   iMax;
                 i >=
                   iMin;
                 i--) {
                if (counts[i] ==
                      0) {
                    continue;
                }
                hiBound =
                  i;
                break;
            }
            boolean flagChangedLo =
              loBound !=
              -1 &&
              iMin !=
              loBound;
            boolean flagChangedHi =
              hiBound !=
              -1 &&
              iMax !=
              hiBound;
            if (flagChangedLo) {
                min[splitChannel] =
                  loBound;
            }
            if (flagChangedHi) {
                max[splitChannel] =
                  hiBound;
            }
        }
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube splitChannel(int splitChannel,
                                                                             int c0,
                                                                             int c1) {
            if (min[splitChannel] ==
                  max[splitChannel]) {
                return null;
            }
            if (count ==
                  0) {
                return null;
            }
            int half =
              count /
              2;
            int[] counts =
              computeCounts(
                splitChannel,
                c0,
                c1);
            int tcount =
              0;
            int lastAdd =
              -1;
            int splitLo =
              min[splitChannel];
            int splitHi =
              max[splitChannel];
            for (int i =
                   min[splitChannel];
                 i <=
                   max[splitChannel];
                 i++) {
                int c =
                  counts[i];
                if (c ==
                      0) {
                    if (tcount ==
                          0 &&
                          i <
                          max[splitChannel])
                        min[splitChannel] =
                          i +
                            1;
                    continue;
                }
                if (tcount +
                      c <
                      half) {
                    lastAdd =
                      i;
                    tcount +=
                      c;
                    continue;
                }
                if (half -
                      tcount <=
                      tcount +
                      c -
                      half) {
                    if (lastAdd ==
                          -1) {
                        if (c ==
                              count) {
                            max[splitChannel] =
                              i;
                            return null;
                        }
                        else {
                            splitLo =
                              i;
                            splitHi =
                              i +
                                1;
                            tcount +=
                              c;
                            break;
                        }
                    }
                    splitLo =
                      lastAdd;
                    splitHi =
                      i;
                }
                else {
                    if (i ==
                          max[splitChannel]) {
                        if (c ==
                              count) {
                            return null;
                        }
                        else {
                            splitLo =
                              lastAdd;
                            splitHi =
                              i;
                            break;
                        }
                    }
                    tcount +=
                      c;
                    splitLo =
                      i;
                    splitHi =
                      i +
                        1;
                }
                break;
            }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube ret =
              new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube(
              colors,
              tcount);
            count =
              count -
                tcount;
            ret.
              min[splitChannel] =
              min[splitChannel];
            ret.
              max[splitChannel] =
              splitLo;
            min[splitChannel] =
              splitHi;
            ret.
              min[c0] =
              min[c0];
            ret.
              max[c0] =
              max[c0];
            ret.
              min[c1] =
              min[c1];
            ret.
              max[c1] =
              max[c1];
            normalize(
              splitChannel,
              counts);
            ret.
              normalize(
                splitChannel,
                counts);
            return ret;
        }
        private int[] computeCounts(int splitChannel,
                                    int c0,
                                    int c1) {
            int splitSh4 =
              (2 -
                 splitChannel) *
              4;
            int c0Sh4 =
              (2 -
                 c0) *
              4;
            int c1Sh4 =
              (2 -
                 c1) *
              4;
            int half =
              count /
              2;
            int[] counts =
              new int[256];
            int tcount =
              0;
            int minR =
              min[0];
            int minG =
              min[1];
            int minB =
              min[2];
            int maxR =
              max[0];
            int maxG =
              max[1];
            int maxB =
              max[2];
            int[] minIdx =
              { minR >>
              4,
            minG >>
              4,
            minB >>
              4 };
            int[] maxIdx =
              { maxR >>
              4,
            maxG >>
              4,
            maxB >>
              4 };
            int[] vals =
              { 0,
            0,
            0 };
            for (int i =
                   minIdx[splitChannel];
                 i <=
                   maxIdx[splitChannel];
                 i++) {
                int idx1 =
                  i <<
                  splitSh4;
                for (int j =
                       minIdx[c0];
                     j <=
                       maxIdx[c0];
                     j++) {
                    int idx2 =
                      idx1 |
                      j <<
                      c0Sh4;
                    for (int k =
                           minIdx[c1];
                         k <=
                           maxIdx[c1];
                         k++) {
                        int idx =
                          idx2 |
                          k <<
                          c1Sh4;
                        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] v =
                          colors[idx];
                        for (int iColor =
                               0;
                             iColor <
                               v.
                                 length;
                             iColor++) {
                            org.apache.batik.ext.awt.image.rendered.IndexImage.Counter c =
                              v[iColor];
                            vals =
                              c.
                                getRgb(
                                  vals);
                            if (contains(
                                  vals)) {
                                counts[vals[splitChannel]] +=
                                  c.
                                    count;
                                tcount +=
                                  c.
                                    count;
                            }
                        }
                    }
                }
            }
            return counts;
        }
        public java.lang.String toString() {
            return "Cube: [" +
            min[RED] +
            '-' +
            max[RED] +
            "] [" +
            min[GRN] +
            '-' +
            max[GRN] +
            "] [" +
            min[BLU] +
            '-' +
            max[BLU] +
            "] n:" +
            count;
        }
        public int averageColor() { if (count ==
                                          0) {
                                        return 0;
                                    }
                                    byte[] rgb =
                                      averageColorRGB(
                                        null);
                                    return rgb[RED] <<
                                      16 &
                                      16711680 |
                                      rgb[GRN] <<
                                      8 &
                                      65280 |
                                      rgb[BLU] &
                                      255;
        }
        public byte[] averageColorRGB(byte[] rgb) {
            if (count ==
                  0)
                return RGB_BLACK;
            float red =
              0;
            float grn =
              0;
            float blu =
              0;
            int minR =
              min[0];
            int minG =
              min[1];
            int minB =
              min[2];
            int maxR =
              max[0];
            int maxG =
              max[1];
            int maxB =
              max[2];
            int[] minIdx =
              { minR >>
              4,
            minG >>
              4,
            minB >>
              4 };
            int[] maxIdx =
              { maxR >>
              4,
            maxG >>
              4,
            maxB >>
              4 };
            int[] vals =
              new int[3];
            for (int i =
                   minIdx[0];
                 i <=
                   maxIdx[0];
                 i++) {
                int idx1 =
                  i <<
                  8;
                for (int j =
                       minIdx[1];
                     j <=
                       maxIdx[1];
                     j++) {
                    int idx2 =
                      idx1 |
                      j <<
                      4;
                    for (int k =
                           minIdx[2];
                         k <=
                           maxIdx[2];
                         k++) {
                        int idx =
                          idx2 |
                          k;
                        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] v =
                          colors[idx];
                        for (int iColor =
                               0;
                             iColor <
                               v.
                                 length;
                             iColor++) {
                            org.apache.batik.ext.awt.image.rendered.IndexImage.Counter c =
                              v[iColor];
                            vals =
                              c.
                                getRgb(
                                  vals);
                            if (contains(
                                  vals)) {
                                float weight =
                                  c.
                                    count /
                                  (float)
                                    count;
                                red +=
                                  vals[0] *
                                    weight;
                                grn +=
                                  vals[1] *
                                    weight;
                                blu +=
                                  vals[2] *
                                    weight;
                            }
                        }
                    }
                }
            }
            byte[] result =
              rgb ==
              null
              ? (new byte[3])
              : rgb;
            result[RED] =
              (byte)
                (red +
                   0.5F);
            result[GRN] =
              (byte)
                (grn +
                   0.5F);
            result[BLU] =
              (byte)
                (blu +
                   0.5F);
            return result;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL0aC3AV1fW+JISQD/nwi3zCJ0EH1LyCWj8RKgm/wAPSBKkN" +
           "Qtjsu8lb2Le77t6XvITSCrWFyuhQQNBWmU6NBQHFcbS1U7W0Tv2M1o6faq0j" +
           "WOtYrHUq7VQ71daec+/u23373tuQaHwze3ffveece8//3L17/H0yyjJJDdVY" +
           "PeszqFW/RGMtkmnRaJMqWdZa6OuQD+ZL/9x4ZvWVeaSwnYyNSdYqWbLoUoWq" +
           "UaudTFM0i0maTK3VlEYRo8WkFjV7JKboWjuZoFjNcUNVZIWt0qMUAdZJZoRU" +
           "SoyZSmeC0WabACPTIrCSMF9JeJF/uCFCSmXd6HPBqz3gTZ4RhIy7c1mMVEQ2" +
           "Sz1SOMEUNRxRLNaQNMmFhq72das6q6dJVr9ZvcwWwYrIZRkimPVA+Ycf74lV" +
           "cBGMkzRNZ5w9q5VautpDoxFS7vYuUWncuoF8k+RHSIkHmJG6iDNpGCYNw6QO" +
           "ty4UrL6Maol4k87ZYQ6lQkPGBTEyM52IIZlS3CbTwtcMFIqYzTtHBm5npLgV" +
           "XGaweNuF4f0HN1Y8mE/K20m5orXhcmRYBINJ2kGgNN5JTWtRNEqj7aRSA2W3" +
           "UVORVKXf1nSVpXRrEkuA+h2xYGfCoCaf05UV6BF4MxMy080Ue13coOx/o7pU" +
           "qRt4nejyKjhciv3AYLECCzO7JLA7G6Vgi6JFGZnux0jxWLcSAAB1dJyymJ6a" +
           "qkCToINUCRNRJa073Aamp3UD6CgdDNBkZHJOoihrQ5K3SN20Ay3SB9cihgBq" +
           "DBcEojAywQ/GKYGWJvu05NHP+6uvvnWrtlzLIyFYc5TKKq6/BJBqfEittIua" +
           "FPxAIJbOjRyQJj62K48QAJ7gAxYwP/vG2Wsuqjn5tICZkgVmTedmKrMOeaBz" +
           "7AtTm+ZcmY/LKDJ0S0Hlp3HOvazFHmlIGhBhJqYo4mC9M3iy9cmv33iUvpdH" +
           "iptJoayriTjYUaWsxw1FpeYyqlFTYjTaTMZQLdrEx5vJaHiOKBoVvWu6uizK" +
           "mkmByrsKdf4fRNQFJFBExfCsaF2682xILMafkwYhZBxcpBouSsSP3xmh4Zge" +
           "p2FJljRF08Mtpo78W2GIOJ0g21i4E6x+S9jSEyaYYFg3u8MS2EGM2gPomVIv" +
           "CytxUH8Y1BEFnUTDzXBPNmNfPZqb8UVNlESOx/WGQqCMqf5QoIIXLddVQOyQ" +
           "9ycal5y9v+NZYWboGrasGLkc5q4Xc9fzuXnghLnr+dz1ztz17tx1TYlOSkIh" +
           "Pu94XIgwAFDfFggEEIlL57RtWLFp16x8sDyjtwBkj6Cz0jJSkxstnBDfIZ+o" +
           "KuufeWreE3mkIEKqJJklJBUTzCKzG0KXvMX27tJOyFVuypjhSRmY60xdplGI" +
           "WLlSh02lSO+hJvYzMt5DwUlo6Lrh3Okk6/rJydt7t6/71pfySF56lsApR0GA" +
           "Q/QWjO2pGF7njw7Z6JbvPPPhiQPbdDdOpKUdJ1tmYCIPs/yW4RdPhzx3hvRw" +
           "x2Pb6rjYx0AcZxL4HYTIGv8caWGowQnpyEsRMNylm3FJxSFHxsUsZuq9bg83" +
           "2Ur+PB7Mogj9shSuHbaj8juOTjSwnSRMHO3MxwVPGQvajLv+8Py7l3BxO9ml" +
           "3FMWtFHW4IloSKyKx65K12zXmpQC3Bu3t+y77f2d67nNAkRttgnrsG2CSAYq" +
           "BDF/5+kbXjt9auDlvJSdk2Q6b0UBvMEk57vLgECoQoxAY6m7VgOzVLoUqVOl" +
           "6E+flM+e9/Dfbq0Q6lehx7GeiwYn4Paf10hufHbjRzWcTEjGROyKygUT0X2c" +
           "S3mRaUp9uI7k9hen3fGUdBfkCYjNltJPebjN46znpRed6EZtiU6LcWyRka4v" +
           "efKX1t3vPCgy0qwswL40d+Rwkfx6/Mm3BcJ5WRAE3IQj4VvWvbr5OW4IRRgd" +
           "sB+FVObxfYgiHiusSGlqLCpmAlymrSnTb4XA2uzcocDD4aGf1D7/rUO1fwIR" +
           "t5MixYJwA7NmKQI8OB8cP/3ei2XT7ufeV4CLtxeeXj1lFkdpNQ/nqRybK4UN" +
           "XuV5rmbkquEEej2Bc3ISl2AUT8XyqWmxnG8b3HBy9KXLf3/4+wd6hdbm5Bac" +
           "D6/6P2vUzh1v/ZvbZ0b0zFIU+fDbw8fvnNy08D2O74YxxK5LZqZI0I2LO/9o" +
           "/F95swp/k0dGt5MK2S7T10lqAoNDO0jfcmp3KOXTxtPLTFFTNaTC9FR/CPVM" +
           "6w+gbmqGZ+ZYsIiZQpshwi1yGce4gLdzsblYuCCDDUWiE/ZlDAgrmqTa4ehT" +
           "+IXg+h9eaNzYIWqiqia7MJuRqswMqAsKVap1s5gVqL8WU4lDYO2xvTW8rer0" +
           "ljvP3Cf07leWD5ju2n/zp/W37hcxTZT5tRmVthdHlPrCd7GJoFvODJqFYyz9" +
           "y4ltvziybadYVVV60boE9mT3vfLf5+pvf/OZLNVRPvgc/llgJFNO4EQ7269E" +
           "nETVQ2GvaxRDrjMmiiNFr09tqmAwmcWdpqW50yru1q5tvjF2759/XtfdOJSq" +
           "CPtqBql78P90kMnc3Br2L+WpHX+dvHZhbNMQCpzpPg35Sd676vgzy86X9+bx" +
           "fZtwmoz9XjpSQ7qrFJsUNqja2jSHqRUOw7WX3VtC+LiCQ0T4WDilGWInc/xP" +
           "A8a6sZHA2WRUvbCUAPDNGb2Yaadnz+FL4gbjWbf/kUkPXX340CleZRhJYhgG" +
           "yWJD49Ozo/Cyxd8rf3RPVf5SMJ1mUpTQlBsStDmaLr7RVqLTky7dPa0rTNvf" +
           "MGowEpoLq7Cy52+fk89v2STvqmvh+RtJXC7oYNvqZwH/Gkk+dmmADHuwmW15" +
           "C+d0q/W8demQ97z8Qdm6Dx4/m5FS0uvEVZLR4IbZ85G7Sf6NzXLJigHcpSdX" +
           "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" +
           "jDlq8IhjZAuJwoaP8kd8OvZ/b87sT14uAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "sdQyP62BY31oqeubWOov3FiE0JFtXrZN55xVFik9dAWC7mD3Xe/Pt28usueF" +
           "cJisFLCoCPUAZl1NH5vqVg/GsqNbPy6rfCXDlOipm1vgc0fi+6VXZYHPvkoL" +
           "fK7s7NmXs8DPX1D3haJ4/tgCn73IAv/edRb4i/8fLPCLL2uB8gnsU7y8cIu8" +
           "PAaOzSEvm5vw8uLL8HKHBgLtjTzW3YrrWrrsnOPxS6+cx3K58jboguXKIY9f" +
           "vSCfOA4pxXOuw8eetXM8fe0W5fb6guaQp91NePr6y8jtTrVYIh3b/ylu/ukr" +
           "5+YNRxLKDrnJruPm4Hj1XyalA7AsW+nBQ3/691/8q49/sn2pWNnemRTrFpBF" +
           "PHhCx8bFY+df/MrnHnvN83/yXLngP+r61y+Y4PYZkV/me90bIfzGq0CYHyLM" +
           "b4CwuPiNI4X/5itnj+LZG7H3rVfB3ocO2fvQBeyVLHz7lbOHM7MbsfdvX5a9" +
           "/UQ8OABWVr+GXqsW///wxuNeLi7fe/3gj2ws9erRWnAOVvIgdb26sdCjtcwp" +
           "U9k/tT/HJPaKmQT2+cBJZ4zrrJ5+7ruf+d1fevI7wDjpI+MsqP8l0PD8Y0/9" +
           "9/Ix8nduDc+bCzxCGQAZOYxG5eMiXTuGdD7dAsuHVw8pevj9/UY4wI5+TFUm" +
           "EGxeMxYVeiBMurCzM5GcoKu9fo3JiMWmzQ9XNrzDxgI+3LKTaBPGbUupMzqK" +
           "Rq1lMpgKRLAgs3g9mbD4wp61WHzSJ1VFqM3QRXWa1Ec1t2XIfnWz4CIx6M98" +
           "dD5Ba5qsqxU4riMIikTxRO7vch0xjETXVb0NwwhTQ+F+Ncs2NN3V5uJYD3Of" +
           "XMA8NYq2tsPL9MhfaJLc4uJJtyIxcCdtSMlirsvCzhEzVtBEf6Ew7sxd+DM5" +
           "1qbkqGpWbXk6ROZWT+Td9mJLbuYoPVTcxSaWXHLDqjN2Lg0WUdUfzTBNoiWX" +
           "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" +
           "Cjlx0HFPENYEoQvOfLUxuL5j+mvYz7lK");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("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" +
           "AAA=");
    }
    static byte[][] computeRGB(int nCubes,
                               org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[] cubes) {
        byte[] r =
          new byte[nCubes];
        byte[] g =
          new byte[nCubes];
        byte[] b =
          new byte[nCubes];
        byte[] rgb =
          new byte[3];
        for (int i =
               0;
             i <
               nCubes;
             i++) {
            rgb =
              cubes[i].
                averageColorRGB(
                  rgb);
            r[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    RED];
            g[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    GRN];
            b[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    BLU];
        }
        byte[][] result =
          new byte[3][];
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 RED] =
          r;
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 GRN] =
          g;
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 BLU] =
          b;
        return result;
    }
    static void logRGB(byte[] r, byte[] g,
                       byte[] b) { java.lang.StringBuffer buff =
                                     new java.lang.StringBuffer(
                                     100);
                                   int nColors =
                                     r.
                                       length;
                                   for (int i =
                                          0;
                                        i <
                                          nColors;
                                        i++) {
                                       java.lang.String rgbStr =
                                         "(" +
                                       (r[i] +
                                          128) +
                                       ',' +
                                       (g[i] +
                                          128) +
                                       ',' +
                                       (b[i] +
                                          128) +
                                       "),";
                                       buff.
                                         append(
                                           rgbStr);
                                   }
                                   java.lang.System.
                                     out.
                                     println(
                                       "RGB:" +
                                       nColors +
                                       buff);
    }
    static java.util.List[] createColorList(java.awt.image.BufferedImage bi) {
        int w =
          bi.
          getWidth(
            );
        int h =
          bi.
          getHeight(
            );
        java.util.List[] colors =
          new java.util.ArrayList[1 <<
                                    12];
        for (int i_w =
               0;
             i_w <
               w;
             i_w++) {
            for (int i_h =
                   0;
                 i_h <
                   h;
                 i_h++) {
                int rgb =
                  bi.
                  getRGB(
                    i_w,
                    i_h) &
                  16777215;
                int idx =
                  (rgb &
                     15728640) >>>
                  12 |
                  (rgb &
                     61440) >>>
                  8 |
                  (rgb &
                     240) >>>
                  4;
                java.util.List v =
                  colors[idx];
                if (v ==
                      null) {
                    v =
                      new java.util.ArrayList(
                        );
                    v.
                      add(
                        new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter(
                          rgb));
                    colors[idx] =
                      v;
                }
                else {
                    java.util.Iterator i =
                      v.
                      iterator(
                        );
                    while (true) {
                        if (i.
                              hasNext(
                                )) {
                            if (((org.apache.batik.ext.awt.image.rendered.IndexImage.Counter)
                                   i.
                                   next(
                                     )).
                                  add(
                                    rgb))
                                break;
                        }
                        else {
                            v.
                              add(
                                new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter(
                                  rgb));
                            break;
                        }
                    }
                }
            }
        }
        return colors;
    }
    static org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] convertColorList(java.util.List[] colors) {
        final org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] EMPTY_COUNTER =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[0];
        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colorTbl =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[1 <<
                                                                           12][];
        for (int i =
               0;
             i <
               colors.
                 length;
             i++) {
            java.util.List cl =
              colors[i];
            if (cl ==
                  null) {
                colorTbl[i] =
                  EMPTY_COUNTER;
                continue;
            }
            int nSlots =
              cl.
              size(
                );
            colorTbl[i] =
              (org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[])
                cl.
                toArray(
                  new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[nSlots]);
            colors[i] =
              null;
        }
        return colorTbl;
    }
    public static java.awt.image.BufferedImage getIndexedImage(java.awt.image.BufferedImage bi,
                                                               int nColors) {
        int w =
          bi.
          getWidth(
            );
        int h =
          bi.
          getHeight(
            );
        java.util.List[] colors =
          createColorList(
            bi);
        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colorTbl =
          convertColorList(
            colors);
        colors =
          null;
        int nCubes =
          1;
        int fCube =
          0;
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[] cubes =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[nColors];
        cubes[0] =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube(
            colorTbl,
            w *
              h);
        while (nCubes <
                 nColors) {
            while (cubes[fCube].
                     isDone(
                       )) {
                fCube++;
                if (fCube ==
                      nCubes)
                    break;
            }
            if (fCube ==
                  nCubes) {
                break;
            }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube c =
              cubes[fCube];
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube nc =
              c.
              split(
                );
            if (nc !=
                  null) {
                if (nc.
                      count >
                      c.
                        count) {
                    org.apache.batik.ext.awt.image.rendered.IndexImage.Cube tmp =
                      c;
                    c =
                      nc;
                    nc =
                      tmp;
                }
                int j =
                  fCube;
                int cnt =
                  c.
                    count;
                for (int i =
                       fCube +
                       1;
                     i <
                       nCubes;
                     i++) {
                    if (cubes[i].
                          count <
                          cnt)
                        break;
                    cubes[j++] =
                      cubes[i];
                }
                cubes[j++] =
                  c;
                cnt =
                  nc.
                    count;
                while (j <
                         nCubes) {
                    if (cubes[j].
                          count <
                          cnt)
                        break;
                    j++;
                }
                for (int i =
                       nCubes;
                     i >
                       j;
                     i--)
                    cubes[i] =
                      cubes[i -
                              1];
                cubes[j++] =
                  nc;
                nCubes++;
            }
        }
        byte[][] rgbTbl =
          computeRGB(
            nCubes,
            cubes);
        java.awt.image.IndexColorModel icm =
          new java.awt.image.IndexColorModel(
          8,
          nCubes,
          rgbTbl[0],
          rgbTbl[1],
          rgbTbl[2]);
        java.awt.image.BufferedImage indexed =
          new java.awt.image.BufferedImage(
          w,
          h,
          java.awt.image.BufferedImage.
            TYPE_BYTE_INDEXED,
          icm);
        java.awt.Graphics2D g2d =
          indexed.
          createGraphics(
            );
        g2d.
          setRenderingHint(
            java.awt.RenderingHints.
              KEY_DITHERING,
            java.awt.RenderingHints.
              VALUE_DITHER_ENABLE);
        g2d.
          drawImage(
            bi,
            0,
            0,
            null);
        g2d.
          dispose(
            );
        int bits;
        for (bits =
               1;
             bits <=
               8;
             bits++) {
            if (1 <<
                  bits >=
                  nCubes)
                break;
        }
        if (bits >
              4) {
            return indexed;
        }
        if (bits ==
              3)
            bits =
              4;
        java.awt.image.ColorModel cm =
          new java.awt.image.IndexColorModel(
          bits,
          nCubes,
          rgbTbl[0],
          rgbTbl[1],
          rgbTbl[2]);
        java.awt.image.SampleModel sm;
        sm =
          new java.awt.image.MultiPixelPackedSampleModel(
            java.awt.image.DataBuffer.
              TYPE_BYTE,
            w,
            h,
            bits);
        java.awt.image.WritableRaster ras =
          java.awt.image.Raster.
          createWritableRaster(
            sm,
            new java.awt.Point(
              0,
              0));
        bi =
          indexed;
        indexed =
          new java.awt.image.BufferedImage(
            cm,
            ras,
            bi.
              isAlphaPremultiplied(
                ),
            null);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            bi,
            indexed);
        return indexed;
    }
    public IndexImage() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/namDMZ3ZPyxmT9btm1iD3dLQ/A4zsvweN4uwmaJcFt8PCmTNRb/KytiLD9P" +
       "kzQVylx41rX16i0T8TX3niLyiwZ/NtAJye6Db/z7lcht772UJ+xUMt04SaUj" +
       "VPWsiWVLky9SdPOkzkWrd2pv+uDx1mT74QQJ7Gs+RBjA33NBicWFQT8oygtX" +
       "/3n22nOHNhwG3s8NmDPI8v7uHS+tPF6+KcwzWAH1OZmvf1Kb17CwqEkhVddQ" +
       "Teyp4adlQdYBuBM0ExK2HSCcc1oEMOf3JgBBi9cPrkdxT6kqwjAAEWHOKezP" +
       "CHAD+9KDFkRvJQWIPmLnuKf2bJA3t/Z8KPzr2DwTBF3j9uh1697c+ArfiQrc" +
       "+qz+nm0HF/HEoXpsIujji4pUjH55opsa3h2+66MHhTzBBD1ATDdv+eGXkeu3" +
       "CN8XVcyCnELCO0dUMgHp5hdbhc9YsXfnpie2b7ombCNvFyMlil1goslD2SRs" +
       "ut+CQs7zr6178oaGkhVworpIRVpTLk/Trrjfq8qt9KDHpG7R4/qYLTGGQUZC" +
       "ixGffFcQ2S3jAUYsfcnU539l3fOnR4Q98zlEoOjZvq1Cfjv1/IeOqv1ZP1yC" +
       "bndyMccGcRYW3mmPVBP3LXj1yokFf+RBoUKxAC7AdfKUcZ45B3a8+/GumqaH" +
       "OCyVogfapvLXv7nlra9q5TrVYbNRnLBZjJxx+Ol5a0d6kBqGQYIugD9phq/y" +
       "7SKh28TmQkaqsGKDSrl3ZTunS2atPRVp64DjScLa4puR9V+x6kmOsGhC1Uej" +
       "a0FJLAbbTSoNW05RdTTZC4Pz+JG2n7PqzkHt5oGaT9rqPinUlb+iPIOmEofq" +
       "rh3cpU82FYMpWrJTG1FMXUvhYbDV/jqWESpfbMMOfl3ied7AwKnHGM3vUHmQ" +
       "Zo4viPNLRTfKPfD6Gb/bduMto+LYF4HfwLxZ/1yjDl79/uc5SSIPuHkQOTC/" +
       "P7rjrtkd537M57uVDs5uzeQW0HDu3bmnPpD6NNxS9uswKe8n9bJ9ibdOUtNY" +
       "ZPTDybacm70YqfGN+y+hxI1LWza8zwmGBM+ywRrLC8mlzAe/vKwaz4QIR7tr" +
       "8wfwME8HGTBVNEnl8yIQ01WqJcXlyQA2Y0YmJ1zbYCTqBNQDMkFdo1hyOGPi" +
       "MkDRI9n7QxjM9Q383S2E5YsJSbHp5PIUwaVbi4zdjs0WUE1GuYQaRcjvyk3A" +
       "saPdyJDCwMl7z8SmVzwvO8JcXywlTOHH1NPB2H12BOsrkpphszY3CSs0NWCJ" +
       "Ei5IiQD14F7kqI3t/bzhj9uLmHUHNvegS+lJJ2oEcWREV+KuJbceBUs24Nh8" +
       "MEPcNkf88C1ZaGpAea9XwxmYw8+AG5zb0wnMX+I8LPNVf1nEek9j8yhUvDKE" +
       "JYa1vG5i3Vcg+BZWzw1lz/Dq1wfGvdIor+IG5J8Oq8s/OfO+cwQOzy+Awy79" +
       "4xe+99rd4zt3iIwWkxxGTiz06iP3fQveRxXJwDyX4p+uPHty3wfrLnXSvFpb" +
       "FdvKtd5qXlyPvJh3R74v5tmg+HIxUMTmRwIRsbkui4bP5qIh/vwxNjcWgbdn" +
       "OLNnsbm5yJ7vKjK2G5vfYnOHkKQI7RuFAe1QYPbzo3AE+a3MCWCrO20fvfPw" +
       "j2ChqfmPIP6c5FzfL2KmD7F5h/EIDpU/K3TGanFGI3xMIYT4zn/G9uY+g5Oe" +
       "fSR5u57G+qCwL+91fHn/EfnyviP05b2c2b5D+fLfi4x9hs1fs768r5gvf/7V" +
       "gvOeo+DP83AsCvZ6zHbKx4r4c+FduShwcTKtCMeAgTz79QQ263HF0JTCZgyV" +
       "YycU43VJyriT2XGIs8iaK0T+H+bKQLXoOjJeZs7KeTMt3qbKD03UVcycuOhN" +
       "USo7bzyrY6QikVZVb4breS4zTJpQuJGrRb5rcB3rGDnhfzxojFQ4j6hFqFZw" +
       "aGCkuTgHSCr5t3dWIyOzCs1ipARaLzVmx/mogRJaL+VxAE1BSliff3vpmsHe" +
       "Lh0kXOLBSzIfuAMJPrYYDirVuwm8KEQy4pj7rpH5KWo8lFt4bokX+KI6/88F" +
       "5yIn3WMnDzsnLlh9xcHT7xXvdGRVGh9HLlNjpFy8OeJMS3ISES83h1fZqkVf" +
       "1D5cudDJD3zvlLyycecEiODvX2YHXnJYrdl3HW9tXfb0bzaX7YLMZj0JSVDo" +
       "rM8t2TJG2iRN62O5l2hQsvG3L22L7hg7d0nik7f5DT3JKYWD9APy7m2Xvn7T" +
       "rK3NYTK1C9wMTxCvJc8f03qpPGL2kxrF6syAiMAFqirfDV0tHh4J/6eB28U2" +
       "Z022F1/2MdKSe+eY+4q0StVHqdkO8SeObGqgvnZ7xM4E7pnThhGY4PbYW4kt" +
       "H41kcDfAHwdi3YbhvCmrPGBw9Chwq4COu5Q/4tPp/wUBB9zA1SQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9v/jBW1fKIrPF8U/2UtyAe0X81NB/+nX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4fflJZu3Ay1/8dBXfvH76velIiXB712gze8XxZfj8spAqoXxzRz7vqLHm8E3" +
       "3Au7/z3j2GWHovjKsf/88PeS2fhJkWbd3M2+cuRmf/g9udlXv0c3+0rJ7Kuv" +
       "5mbfuKDtj4vifx672VcvcrM/Ob++/KfX4WqPF5Wg/eCzh6722dfgaif2vDBz" +
       "L/5+prRySfWdC3T7s6L4NgBTQ4vLmT9E4ZLFicavvBaNc5DinnhRcSnqoetu" +
       "M+9v4CqfeuHynW95Yfp7+3T/6JbsXf3KnXriOKfvsJx6vj0INd0qxb9rf6Ml" +
       "KH/+Iq68/a/o5XHlzqPHUvw/LzkUV2Ieu5gDSErK39O9bo0rD92sF3hlAuVp" +
       "6jtASnUjakAJytOUdwMsOE8Jxi9/T9PdC+x9Qgdyhf3DaZIrgDsgKR7vD44g" +
       "4dRdmf1Vo3wfYw+d9txy+h94tek/9fr+5JnVrrztfvSCnAiHi+pLL3CDn3yl" +
       "+cn9rUTFkXa7gsud4DVuf0GyZFq8ZD9xU25HvG5nnv7ufZ++66mjdfO+vcAn" +
       "UXRKtrfe+Npf1w3i8qLe7rNv+dUf+aUX/qC8LPT/AXBQ1R2GMAAA");
}
