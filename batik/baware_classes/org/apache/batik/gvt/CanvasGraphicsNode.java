package org.apache.batik.gvt;
public class CanvasGraphicsNode extends org.apache.batik.gvt.CompositeGraphicsNode {
    protected java.awt.geom.AffineTransform positionTransform;
    protected java.awt.geom.AffineTransform viewingTransform;
    protected java.awt.Paint backgroundPaint;
    public CanvasGraphicsNode() { super(); }
    public void setBackgroundPaint(java.awt.Paint newBackgroundPaint) { this.
                                                                          backgroundPaint =
                                                                          newBackgroundPaint;
    }
    public java.awt.Paint getBackgroundPaint() { return backgroundPaint;
    }
    public void setPositionTransform(java.awt.geom.AffineTransform at) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          positionTransform =
          at;
        if (positionTransform !=
              null) {
            transform =
              new java.awt.geom.AffineTransform(
                positionTransform);
            if (viewingTransform !=
                  null)
                transform.
                  concatenate(
                    viewingTransform);
        }
        else
            if (viewingTransform !=
                  null)
                transform =
                  new java.awt.geom.AffineTransform(
                    viewingTransform);
            else
                transform =
                  new java.awt.geom.AffineTransform(
                    );
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getPositionTransform() {
        return positionTransform;
    }
    public void setViewingTransform(java.awt.geom.AffineTransform at) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          viewingTransform =
          at;
        if (positionTransform !=
              null) {
            transform =
              new java.awt.geom.AffineTransform(
                positionTransform);
            if (viewingTransform !=
                  null)
                transform.
                  concatenate(
                    viewingTransform);
        }
        else
            if (viewingTransform !=
                  null)
                transform =
                  new java.awt.geom.AffineTransform(
                    viewingTransform);
            else
                transform =
                  new java.awt.geom.AffineTransform(
                    );
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getViewingTransform() {
        return viewingTransform;
    }
    public void primitivePaint(java.awt.Graphics2D g2d) {
        if (backgroundPaint !=
              null) {
            g2d.
              setPaint(
                backgroundPaint);
            g2d.
              fill(
                g2d.
                  getClip(
                    ));
        }
        super.
          primitivePaint(
            g2d);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZfWwUxxWfO38bf/NZPgwYQ4Ihd5BCCTKlMcYGw9k+YYPU" +
       "I+EY783dLd7bXXbnzmcnbpNILbQViBKHUJSgVgLRIj6iKFE/0qREUQtR0qpJ" +
       "aJM0CmnTP0qboga1JW1pm76Z3b3d2/tAluqTdm5v5r03771583tv5s7dQGW6" +
       "hpqJTH10VCW6r0umQazpJNIpYV0fhL6w8GQJ/uue633rvag8hOriWO8VsE66" +
       "RSJF9BBaIMo6xbJA9D5CIowjqBGdaClMRUUOoZmi3pNQJVEQaa8SIYxgF9YC" +
       "qBFTqolDSUp6TAEULQiAJn6uib/DPdweQDWCoo7a5HMc5J2OEUaZsOfSKWoI" +
       "7MMp7E9SUfIHRJ22pzW0QlWk0ZikUB9JU98+aa3pgm2BtTkuaHmm/tbtI/EG" +
       "7oLpWJYVys3TdxBdkVIkEkD1dm+XRBL6fvQlVBJA0xzEFLUGrEn9MKkfJrWs" +
       "talA+1oiJxOdCjeHWpLKVYEpRNHibCEq1nDCFBPkOoOESmrazpnB2kUZaw0r" +
       "c0x8YoV/4sk9Dc+WoPoQqhflAaaOAEpQmCQEDiWJIaLpHZEIiYRQowyLPUA0" +
       "EUvimLnSTboYkzFNwvJbbmGdSZVofE7bV7COYJuWFKiiZcyL8oAyf5VFJRwD" +
       "W2fZthoWdrN+MLBaBMW0KIa4M1lKh0U5QtFCN0fGxtbtQACsFQlC40pmqlIZ" +
       "QwdqMkJEwnLMPwChJ8eAtEyBANQomltQKPO1ioVhHCNhFpEuuqAxBFRV3BGM" +
       "haKZbjIuCVZprmuVHOtzo2/D4YfkrbIXeUDnCBEkpv80YGp2Me0gUaIR2AcG" +
       "Y01b4Bie9eJBL0JAPNNFbNB8/+Gb969svnTFoJmXh6Z/aB8RaFg4NVT3xvzO" +
       "5etLmBqVqqKLbPGzLOe7LGiOtKdVQJhZGYls0GcNXtrxsy8+cpZ85EXVPahc" +
       "UKRkAuKoUVASqigRbQuRiYYpifSgKiJHOvl4D6qA94AoE6O3PxrVCe1BpRLv" +
       "Klf4b3BRFEQwF1XDuyhHFetdxTTO39MqQqgCHlQDzyJkfPg3RSF/XEkQPxaw" +
       "LMqKP6gpzH7dD4gzBL6N+4cg6of9upLUIAT9ihbzY4iDODEHYinq78RyCutb" +
       "NKzGRUHvA0TysRhTp1R6mtk2fcTjAbfPd296CfbLVkWKEC0sTCQ3dd28EH7N" +
       "CCi2CUyvUHQXTOgzJvTxCX0woS93QuTx8HlmsImNpYWFGYYtDhhbs3zgwW17" +
       "D7aUQEypI6XgVUbakpVrOm0csMA7LFxsqh1bfG31K15UGkBNWKBJLLHU0aHF" +
       "AJSEYXPf1gxBFrKTwSJHMmBZTFMEEgEsKpQUTCmVSoporJ+iGQ4JVqpim9Jf" +
       "OFHk1R9dOj7y6K4vr/Iibzb+synLALoYe5ChdgadW937Pp/c+gPXb108Nq7Y" +
       "CJCVUKw8mMPJbGhxR4LbPWGhbRF+PvzieCt3exUgNMWwowD8mt1zZAFMuwXW" +
       "zJZKMDiqaAkssSHLx9U0rikjdg8P0Ub+PgPCYhrbcQvgWW9uQf7NRmeprJ1t" +
       "hDSLM5cVPBl8fkB9+p1f/PGz3N1W3qh3JPwBQtsdWMWENXFUarTDdlAjBOje" +
       "Px58/IkbB3bzmAWKJfkmbGVtJ2AULCG4+StX9r/7wbVTV712nFNI1skhqHnS" +
       "GSNZP6ouYiTMtszWB7BOAkRgUdO6U4b4FKMiHpII21j/rl+6+vk/H24w4kCC" +
       "HiuMVt5ZgN3/mU3okdf2fNLMxXgElmttn9lkBoBPtyV3aBoeZXqkH31zwbcu" +
       "46chFQD86uIY4YiKuA8QX7S13P5VvF3jGlvHmqW6M/iz95ejJgoLR65+XLvr" +
       "45ducm2ziyrnWvditd0IL9YsS4P42W5w2or1ONCtudT3QIN06TZIDIFEAYBW" +
       "79cAGtNZkWFSl1X85uVXZu19owR5u1G1pOBIN+abDFVBdBM9DqiaVr9wv7G4" +
       "I5XQNHBTUY7xOR3MwQvzL11XQqXc2WM/mP3chjMnr/EoUw0Z8zh/CQP6LFTl" +
       "pbm9sc++te5XZ755bMRI7ssLo5mLb86/+qWhxz78R47LOY7lKTxc/CH/uafm" +
       "dm78iPPbgMK4W9O5yQlA2ea992zi796W8p96UUUINQhmKbwLS0m2TUNQ/ulW" +
       "fQzlctZ4diln1C3tGcCc7wYzx7RuKLOTIrwzavZe60KvOraEq+C529zYd7vR" +
       "y4P4Sw9nuYu3bay5xwKLKlVTKGhJIi68qC0ilqJGC9EGNSzrDHY59xw4R/Fg" +
       "wiPUFyNKwtcRjYLjM1QGmrL2PtZsMyZtLxi7ndm2+s3Hes9n66BhK2sCuSYV" +
       "4oZzWkokI1B6Z+kadCm8c5IKt8KzxpxyTQGFdxdVuBA3YM8QFCQxTUnKkSBE" +
       "N7VWoC6zArzbZcEDRSxI25qsyGjCP+XIVaU6s4eNB4iB3oJCBwl+CDr12MTJ" +
       "SP/p1QYiNGUX511w9jz/6/+87jv+21fz1IZVVFHvkUiKSI45K9iUWRjUy89Y" +
       "9oZ+v+7o73/YGts0maKO9TXfoWxjvxeCEW2FYc2tyuXH/jR3cGN87yTqs4Uu" +
       "d7pFfq/33KtblglHvfxAaSBNzkE0m6k9G1+qNQInZ3kwC2WWZNdIG+DZbAbA" +
       "Zncg2yHmip1M5VGI1ZWjPQYssZ97udRkkSQ+whqIiiY4c21ybYWiuSaoiQkA" +
       "r5R5SPWPN30w/NT180ZEuhOLi5gcnPj6p77DE0Z0Gsf+JTknbyePcfTnGjcY" +
       "jvkUPh54/sseZg7rYN9gS6d5/lyUOYCyjKuhxcXU4lN0/+Hi+AvfHT/gNd0T" +
       "p6g0pYgRe+vvvxN4Fa8UWEeHyvulzAo3srEl8Gw3V3j75IOjEGuRtf9GkbFD" +
       "rPkq+DKWExc8sGyHHJgCh/Ddch88/aZV/ZN3SCHWwrslyKUeL+KVE6x5HE6a" +
       "sFuC7uTNxh62/TIxBX6Zx8ZY1pVM46TJ+6UQaxGzTxcZO8Oab4NLYgVcErRd" +
       "8p2pCpV18KimXerkXVKI9U6h8mwRvzzHmvMUZiZ0V56iyBEpF6YqUnzwHDJt" +
       "OzR5txRiLWL1T4qMvcyaH4FHYvk94giUF6YqUJhHTphmnZi8Rwqx5g8Uq5ac" +
       "nqklrbu3ezfzyV4v4q1fsuYyFKKqlaQy4OsInSv/D0elWcrMuRtkh9o5OX86" +
       "GBflwoWT9ZWzT+58m1eDmcvsGqjroklJch67HO/lqkaiIreuxjiEqfzrHUCP" +
       "fBeWFJVAy7V+26B8D04YbkqKyvi3k+4aRdU2HUXlxouT5HcgHUjY64eqtVJt" +
       "+e9NoZxgyEac7kl7skv2zJLMvNOSOKr8JVn1Ff8jyCpQk8ZfQWHh4sltfQ/d" +
       "/Nxp43pMkPDYGJMyLYAqjJu6TJG7uKA0S1b51uW3656pWmqVN42Gwnbgz3NE" +
       "YAeEsMqiYK7r7khvzVwhvXtqw0s/P1j+JlRyu5EHQ6zvzj27p9UknC52B+zz" +
       "heOPRH6p1b78xOjGldG/vMdvR5Bx0zy/MH1YuHrmwbeOzjnV7EXTelAZVG4k" +
       "zS8VNo/KO4iQ0kKoVtS70qAiSBGx1IMqk7K4P0l6IgFUxwIWs7+IuF9Md9Zm" +
       "etnlKkUtuRVp7pV0taSMEG0TK46YmFo4kNg91mEn65yQVFUXg92TWcoZubaH" +
       "hc1fq//xkaaSbth0WeY4xVfoyaHMGcT5pxXvMApo1oyn2TrDHggHelXVqp29" +
       "KdXYC38zaFg/RZ42s9eVBD/h4m7xV9b883/rhjmYjx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
