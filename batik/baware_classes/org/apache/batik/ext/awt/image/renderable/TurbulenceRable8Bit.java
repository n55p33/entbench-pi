package org.apache.batik.ext.awt.image.renderable;
public class TurbulenceRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.TurbulenceRable {
    int seed = 0;
    int numOctaves = 1;
    double baseFreqX = 0;
    double baseFreqY = 0;
    boolean stitched = false;
    boolean fractalNoise = false;
    java.awt.geom.Rectangle2D region;
    public TurbulenceRable8Bit(java.awt.geom.Rectangle2D region) { super(
                                                                     );
                                                                   this.region =
                                                                     region;
    }
    public TurbulenceRable8Bit(java.awt.geom.Rectangle2D region, int seed,
                               int numOctaves,
                               double baseFreqX,
                               double baseFreqY,
                               boolean stitched,
                               boolean fractalNoise) { super();
                                                       this.seed = seed;
                                                       this.numOctaves = numOctaves;
                                                       this.baseFreqX = baseFreqX;
                                                       this.baseFreqY = baseFreqY;
                                                       this.stitched = stitched;
                                                       this.fractalNoise =
                                                         fractalNoise;
                                                       this.region = region;
    }
    public java.awt.geom.Rectangle2D getTurbulenceRegion() { return (java.awt.geom.Rectangle2D)
                                                                      region.
                                                                      clone(
                                                                        );
    }
    public java.awt.geom.Rectangle2D getBounds2D() { return (java.awt.geom.Rectangle2D)
                                                              region.
                                                              clone(
                                                                );
    }
    public int getSeed() { return seed; }
    public int getNumOctaves() { return numOctaves; }
    public double getBaseFrequencyX() { return baseFreqX;
    }
    public double getBaseFrequencyY() { return baseFreqY;
    }
    public boolean isStitched() { return stitched; }
    public boolean isFractalNoise() { return fractalNoise;
    }
    public void setTurbulenceRegion(java.awt.geom.Rectangle2D turbulenceRegion) {
        touch(
          );
        this.
          region =
          turbulenceRegion;
    }
    public void setSeed(int seed) { touch();
                                    this.seed = seed;
    }
    public void setNumOctaves(int numOctaves) { touch(
                                                  );
                                                this.
                                                  numOctaves =
                                                  numOctaves;
    }
    public void setBaseFrequencyX(double baseFreqX) {
        touch(
          );
        this.
          baseFreqX =
          baseFreqX;
    }
    public void setBaseFrequencyY(double baseFreqY) {
        touch(
          );
        this.
          baseFreqY =
          baseFreqY;
    }
    public void setStitched(boolean stitched) { touch(
                                                  );
                                                this.
                                                  stitched =
                                                  stitched;
    }
    public void setFractalNoise(boolean fractalNoise) {
        touch(
          );
        this.
          fractalNoise =
          fractalNoise;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.geom.Rectangle2D aoiRect;
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null) {
            aoiRect =
              getBounds2D(
                );
        }
        else {
            java.awt.geom.Rectangle2D rect =
              getBounds2D(
                );
            aoiRect =
              aoi.
                getBounds2D(
                  );
            if (!aoiRect.
                  intersects(
                    rect))
                return null;
            java.awt.geom.Rectangle2D.
              intersect(
                aoiRect,
                rect,
                aoiRect);
        }
        java.awt.geom.AffineTransform usr2dev =
          rc.
          getTransform(
            );
        final java.awt.Rectangle devRect =
          usr2dev.
          createTransformedShape(
            aoiRect).
          getBounds(
            );
        if (devRect.
              width <=
              0 ||
              devRect.
                height <=
              0)
            return null;
        java.awt.color.ColorSpace cs =
          getOperationColorSpace(
            );
        java.awt.geom.Rectangle2D tile =
          null;
        if (stitched)
            tile =
              (java.awt.geom.Rectangle2D)
                region.
                clone(
                  );
        java.awt.geom.AffineTransform patternTxf =
          new java.awt.geom.AffineTransform(
          );
        try {
            patternTxf =
              usr2dev.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        return new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed(
          baseFreqX,
          baseFreqY,
          numOctaves,
          seed,
          fractalNoise,
          tile,
          patternTxf,
          devRect,
          cs,
          true);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CkH8k3XgYf6Kb4/8D8X1C/QoLgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e+zr1n2f7rV9r33t+F7bie14tmM7zsNWcilSlETCaRpR" +
       "EvUgKVEiJYpsUofiSxTfL5FS4yXNNidbNzdLnSYDWqN/pNhSpE0RtGiBrIWH" +
       "ZmuyFts6BN27CYoBzdZmaLCtK5pt2SGl3+P+7u/+bOfeYPqB3x95nt/POd8X" +
       "zzn84ndKd0Rhqex79sawvfiqlsVXV3btarzxtejqgK6xchhpasuWo4gHac8r" +
       "T/3q5b/43qeWV86XLkilB2TX9WI5Nj03mmiRZ681lS5dPkrt2JoTxaUr9Epe" +
       "y1ASmzZEm1H8HF26+1jVuPQ0fcACBFiAAAtQwQLUPCoFKr1JcxOnldeQ3TgK" +
       "Sn+9dI4uXfCVnL249OS1jfhyKDv7ZtgCAWjhzvx5BkAVlbOw9MQh9h3m6wB/" +
       "pgy9/Nkfv/Ll20qXpdJl0+VydhTARAw6kUr3OJqz0MKoqaqaKpXuczVN5bTQ" +
       "lG1zW/Atle6PTMOV4yTUDgcpT0x8LSz6PBq5e5QcW5gosRcewtNNzVYPnu7Q" +
       "bdkAWB88wrpDSObpAOAlEzAW6rKiHVS53TJdNS697WSNQ4xPU6AAqHrR0eKl" +
       "d9jV7a4MEkr37+bOll0D4uLQdA1Q9A4vAb3EpUdu2Gg+1r6sWLKhPR+XHj5Z" +
       "jt1lgVJ3FQORV4lLbzlZrGgJzNIjJ2bp2Px8Z/i+l37C7bnnC55VTbFz/u8E" +
       "lR4/UWmi6VqouYq2q3jPs/TPyg/+1ifPl0qg8FtOFN6V+Y2PfPcD73n81a/t" +
       "yvy1U8qMFitNiZ9XPr+49w8ebT2D35azcafvRWY++dcgL8Sf3ec8l/lA8x48" +
       "bDHPvHqQ+erkn4kf+yXtT8+XLvVLFxTPThwgR/cpnuObthZ2NVcL5VhT+6W7" +
       "NFdtFfn90kVwT5uutksd6Xqkxf3S7XaRdMErnsEQ6aCJfIgugnvT1b2De1+O" +
       "l8V95pdKpYvgKj0OrmdKu9+7chKXfGjpORokK7Jruh7Ehl6OP4I0N16AsV1C" +
       "CyD1FhR5SQhEEPJCA5KBHCy1fUaumXIaQ6YDph8C06ECKAtbg/gkXCR2Pj2T" +
       "/BkjTGCKgOT5/x/6zPJxuJKeOwem6NGTBsIGutXzbNDG88rLCdH57q88/3vn" +
       "DxVmP4Jx6UcAG1d3bFwt2CiMK2DjasHG1SM2rp7CRuncuaL3N+fs7IQDTK0F" +
       "jAQwn/c8w31o8OFPPnUbkEo/vR3My3lQFLqxFW8dmZV+YTwVINulVz+X/uTs" +
       "o5XzpfPXmuMcAki6lFdncyN6aCyfPqmGp7V7+RPf/osv/ewL3pFCXmPf93bi" +
       "+pq5nj91crBDT9FUYDmPmn/2CfnXn/+tF54+X7odGA9gMGMZCDiwRY+f7OMa" +
       "fX/uwHbmWO4AgHUvdGQ7zzoweJfiZeilRymFFNxb3N8HxvjuA41A9xpR/M9z" +
       "H/Bz+uad1OSTdgJFYZt/hPN//t/+i/9SLYb7wIxfPuYYOS1+7pjpyBu7XBiJ" +
       "+45kgA81DZT7T59jf+Yz3/nEjxUCAEq8/bQOn85pC5gMMIVgmP/W14J/980/" +
       "+vw3zh8KzbkY+M5kYZtKdggyTy9dOgMk6O2dR/wA02MDVcyl5ump63iqqZu5" +
       "COdS+r8vvwP+9T976cpODmyQciBG73ntBo7S30qUPvZ7P/6/Hi+aOafkru9o" +
       "zI6K7ezpA0ctN8NQ3uR8ZD/5rx/7B78r/zywzMAaRuZWKwzcud0YFMjfEpfe" +
       "WtTM1dPQPAf4CgXIm2FrSLuYVqgo92xBr+ZDUtQuFXnVnLwtOq4e12rgsSDm" +
       "eeVT3/jzN83+/Le/W+C5Ngo6Lg2M7D+3E8CcPJGB5h86aQt6crQE5dBXhx+8" +
       "Yr/6PdCiBFpUgA2MRiEwLtk1srMvfcfFf/9PfufBD//BbaXzZOmS7ckqKRdq" +
       "WLoLyL8WLYFpy/wf/cBu+tM7AblSQC1dB75IeOR6BcH3soOfriA5fTIn77he" +
       "7G5U9cTwXyw4uJg/VsDIPHNGABuaDtCn9d7pQy/c/03r5779yzuHfjJCOFFY" +
       "++TLf+f7V196+fyxMOrt10Uyx+vsQqkC55t24L4PfufA9X/zKweVJ+xc6f2t" +
       "vT9/4tCh+34+0U+exVbRBfknX3rhK//ohU/sYNx/bRTRAUHyL//h//n9q5/7" +
       "1tdPcUy3gQgxf2gXDDZz0tlNZRcYBNUDFqEoTJ2Wf3HhebYmF9ZpWOD8wBma" +
       "McnJc0UWmpP37dppvC7p2pV9uHi6dPYkk3mIfOQiHv6rkb34+B//5XUqVni2" +
       "U+b9RH0J+uLPPdJ6/58W9Y9cTF778ez6iAC8ThzVRX7J+Z/nn7rwT8+XLkql" +
       "K8r+XWUm20luuCUQn0cHLzDgfeaa/Gtj7V1g+dyhC330pOAd6/akczuacHCf" +
       "l87vL53wZ7cfqGt5r3Plk+p6rlTcfHCnsQV9OifvOjbFnRjYVPDOU0jUkX4X" +
       "0/2h15pu4Xpm3rNn5j03YEZ5DWYuAeEfAdu93jnxkyypPwBL792z9N4bsLR6" +
       "DZbuWsiRRoZaMC/U6gRH1g/A0dU9R1dvwFHwejkST+MofIMcvR1c0J4j6AYc" +
       "Za/B0Z1RbMYgVC7kaHiCoc0bZOhJcFX2DFVuwNBHX4Ohe/QQuEXZHnpmpJ3G" +
       "1MfeIFMPgQvZM4XcgKkXX4OpC6Fm7EPDygl2PvGa7OwM+TkQ9d2BXG1cLRr4" +
       "e6d3eFt++27QX1QsdoAauunK9gEbD61s5ekD5zXTwgjw9PTKbhzEUleKoCO3" +
       "Yld3KwYneO28bl6B2b/3qDHac43nfuo/f+r3f/rt3wS2eVC6Y53bTWCSj/U4" +
       "TPL1mBe/+JnH7n75Wz9VRLsgzJv9ze898oG81c+dhTgnfz8nnz6A+kgOlSte" +
       "LGk5ipkiQNXUQ7Qn3OPttncTaOP7391Do37z4MfMZHneVLLJPJlLiDDQ1ulg" +
       "Vt7Q40gpqwZM+BGaGpOFHbYUeNKjR3SHsR3V1WB1tcXqjFQNbHvRbCct3wiY" +
       "QZYOzXFq1srOqO+loybV4qyWMvb6SavlK61Jc2o1g0G566FkiyAG1Biv+o6K" +
       "SK5akaMWPJsO5arUcOvrKrSu4/NkrUEBgVccyZMYJwib4y4ueB3NHwuDstHd" +
       "8gJtJN1oPA+ISFgNFKo3whuJMGGs2nhobXzCUEHPYz6yqUhjmvyAnRqpQ7X6" +
       "sGaaw/5U0HkDCdppzEz9KcHYlU3iUzLdt7g6LK3IdhyR+rgfTBSxUp95ZtxJ" +
       "zLSzwjZ9g5OWdMduuAunTltdfwJPF3HDQ0aNBBmRyUaKGWXTpRy6QVDd5bxF" +
       "cfM+2l86ES0jvC95wWojWbY48xxvhmzkKGq1JXKWzIgKm6WNqab3lkGAZgRD" +
       "TiakNEtxccvAs54jZiZlwUEjtrouh3RG5cnUMyWaWjEbJraUjSFOjEq7P3Ri" +
       "etYw9DE861g2AgtJO4pTKlY7ZN+cLBc2M+x05tZSXrAmulWopWUndaVLT1Rr" +
       "OBfg9oDN1ERYGphenZHVwOOnbZ+QOc3uKdPx2Ig6RjNtglTZXwQbOhOWkTEc" +
       "h8zQxWcDpSNMgq0UhoRFUFRK9lNoYotRm7KnEsLKAkNiqVmvc84kmPvCmjeq" +
       "1CieC7NU6ATtsE3G8yk2HIVNhQw24zHfx2ixpwig74QTrYyJ8aGlCllNWI+b" +
       "UyO0/PEwUJ0lt5wSlGW2ZY7aeC2+BQlEnTOouh3YhtH2VtEWkfqxLPdHqNBx" +
       "x2NapWchhkeGXedHBNFPo2VF3eqjliD5sZMIPZbd6hFmE3VcGJo+0TFakghz" +
       "06neGIyHvNWPfQaFOTdq1pg08WyLY1urljIimg6xjYeqq1TKLJ418HBg87Km" +
       "M9CaodSWO2wEtOlkY5boqlhCK3gswgNu2fVlUe5YtfIqkTBbn0m0APttfsus" +
       "Wllv0czsroWvodhB5HLZbaTSYDZRfBKe1uzxuBEs9ZnfWgxmdFmh7PG824dh" +
       "a2pPzcV8i5s1rqlhE04mnYWAYQu7LUymvj23hQSLseZ0kon9zmSGtVBf4efb" +
       "0LAjky67w+mgT/AbqyXVBHGNxpnXn9DgeeDYYqc5I6fxJHXrdROyRJHtoNOI" +
       "qFATrBeoqDIcykK7JUozdtIR0ma9GwyFJgUzoih0/JbK6MvEAQrkTxxRrvrs" +
       "xOOihY+IG2jdyLRmorTtQMd7mMT00xo/SfuEQ1G1haEsUzyUAyZsinATc8lQ" +
       "V3R5mWrqEMUYUtz0+hvSG/cRjupoA1PpKZTocWi3RS5WZJNgpoaRdjTQNyVm" +
       "BsknWaIQvZVfjxflYLuI2SGhNG3ZX0l8a93klnJ1OIq7QZWdul1oXKYGWRxk" +
       "S7msKSQ/nvXl/hhpbUiqtWJI15XQZrxZJLEtldUJbzoEPCJXq1ZLkYj5ZOa3" +
       "6Y00g80sIbkghfmeZsnOiF9axrKS1BtENWhZHru18TK2hIU6LnU4nqg2zda4" +
       "JhNYhd2wa74h6JCGrkVlqa+E6rqNTDYa2yCHca/W560VNRn2MU4VlgiCKgvX" +
       "IrPNmF5WlI6Lh7MUaWnEClFaYcdO3Uo1YeYDZUauu1WZSWyZSOdDgTe8bNgV" +
       "NyEyaCWr2ICrvXZY1qMK018PnOkMsxZCvzzHI1cmlyOVqaj0eGtnIuZS2xhG" +
       "6zjuJdA8Wi23FqcJlk5VOrjkYOyiv2C6jVgPFgtW9WyGgtQ6Coy6gOB1SOST" +
       "qqCZWTBsNemZiRg1rU2NOXENVRU31nVtzXYorBu5Y0VcsvGUpClHJaVB2FJn" +
       "rBW25JG+wLxW1WbIhjcUKnOq29SnftaaKSodZBBcq1VTmV335HTbmLa6jpdK" +
       "9CTRjVkFkrdIDV9bam+rZkOjM/EawtBRq8N2k+QXSiNUyYo44V0OblQqDbTm" +
       "LgVmzDMtoov3xRqP1sQu3RwKuCURsjvplzmv63GpH/VxXx7XFW+ok/4cm6Oh" +
       "xlhLVOU6cb1KoKttO+GzzazeXDUyb9puVDdjpSq0ayi2geYDXt0ocNyM5S7i" +
       "NIVBpi9DcVvlGiGKtEDvOL0KVQURVJ31ebRtNHsdMLcVed1eo6krMI1ZUt6Y" +
       "MYThlCWNYCzqK+RoagrhOMh4lEnGfJNu+Jg41kajCh7P6e3I0gORM1dBTGE+" +
       "zwZY03dIHFVWCddNWJ7RF+J2hOtKBGXDhqXK/pZcsykcR+JmvRVIODMFs0GK" +
       "jlOuzQMu6cpbg7F1Y4sLtfayrMouFsgesbV94AY8Le51VbtaaWTjzlrvYVVM" +
       "molEM2SBsq/bQwTHVVWhdWo299brnrbceFnSU/rTFK12NmqgqC5GaM1aA0I9" +
       "NhNFTaTaGiykYd9wGqTX9X0ywDABeHYCo+vduLrQy7rc9g06WYGhcSYoqg+H" +
       "rieOelttFvohQmOrATtAEansh4E47A4rZrXSRWe8yjbsGt3oNXC4amzs2RhB" +
       "OTglG3ZThSAJm49DHWpYG2JNEZ0oFBNyawvD9sqo0lZGqn4qlhG2vRWmaoc2" +
       "6i1qRk3nslUfqAyn9jbDYDgbjjNhLta3XKIESa8z7lIZMRKb1GagmBYiIGtz" +
       "DUM9DcgF4ntU6Au1JaYpyNbpNTQiDTzwN630Mins8jZcKYdmMMrGCw0nptHI" +
       "2iYyhmeJMCQTRES27d68s5Fqo4XFVzF6gerrsr2ByjBf1Vl+YG5DmW0sQq+7" +
       "gnwb3OoQxLK0Pohq01Yt2Zi91ICUkR7h1lqv6RME8dpTWnOxjJhwdC1Ganp1" +
       "oKfcYlPDBpbnEVNTlYWyHBv+tiW20yZSGa8itNxdzGcjrVwXtvhWj7tz3gvd" +
       "BNfGIuwj6YhBKvZIEKUeknQqPJSok41hrVVoNWyW+4kktBpObdKP7FXkjpQk" +
       "gPvKzECaVLk6TKCFNK85kr3qqoISNjqbera0XbvPdsUGNOPKFtmYrkiOIMoO" +
       "KbZrUbhCqgGp6UZ9RYdKV9DQZd2Vy9485hieGYgV2eVZFbLaUceu67Wt1Z5Y" +
       "q8l8Y7FcM6xPNLhZG8SZwOGMaA5mlQ6PGzJVTpf1uYoNdMGUAp4TCaq94EbV" +
       "Sq2SjMfYjNKWLY2UxHG9mnZYrh/WCQ3uZ9OsOu+nKVeb1KaMYK1ErzKlRtlI" +
       "s1UppbZIh9VEEEWBsLs9UgdBim+cYO4wKp510jkXb9H51sna1nQDZdX2SBnQ" +
       "QxvWFQztNX1zumWZelNjBhvRxZcoEKakXO53DXLLwUajsp3ZUVxxGG8kasF4" +
       "WqlH9bLk6u7C0LosRc8hdDqNTZ0newS5mg8ZdNlk61obJkNzrqNqf71psLWq" +
       "BPRe7S7dzmKNl7n6tNraruvVhrEdzV2zoXTK467bBSLftqStqfobFDZnvG1T" +
       "s2qfDzszaVNp0gNrbdQXYuThcZyFi1jTKt11Z4lbwVgv02N8GU1Xq042nI7E" +
       "lO5FMNJcL2FCmwhQr05UmYksSq5Znwt20p9gHA1XdM93G5Ib9UzOUpzmpufB" +
       "vsIx9iRWODazmn7LyxaihJGZH8yHNjZdopbue+VKose+lmoEyqnTlsnWGAnh" +
       "TBBZdLxtf+pKgcVRGUrScF/nVSiV5xFt4ooYjDtTzR3wdJbQ8EZpmqkUpfCk" +
       "FS85UFtvmfikV62qGBI32qhVZuARK4NY2CHbJjPlWSKCeihW4c2U29gCS6La" +
       "oFevs5uMxxMoYpeNJr9BEr2NKk06dfp+jJXbkrxx4LhqYOuOiavj+rQccjOx" +
       "PHPbbW0MKWhlOI47RieddgYrau7gvlKtZuOeOSmby0UDZxBSjINJIPUngdJo" +
       "LxZEMLCaDGsO0K2Ptm1P7nGp1m7hnI1RI6wWzuajyOlVxoLY7tAdo7Ji8Z5B" +
       "UA3eUwfLmRhKUwbRKGo1Xng1ubxE457pradO2esvNyOriU+pBuEtF8tQGg0T" +
       "b+h0xcjujMXOokxHka6hQc/w1pV115DZESGaFSHY9NBu0DDqKW+hntWqdQZo" +
       "IxxVkgBHx3TWX4970tafa/Um03cDpYuYPbPbnJoRMZq2J0DmTZuOYJY0ygNy" +
       "tES9GWQ2MaMSlY2gGUUVchMrrpJY2MJxEY3tGtqArBsYxWbGcNKDWyjSMCh8" +
       "1fMmWmY0+pNVVuGJaBxo/gZRXRPV2ibEYRox1rW2aGDTZOJ4RNtW+6pFbbQU" +
       "+CNxFs9R2gWjP3e0/hLj+nG76YKoZtVHk6yH0hnvM1UMXgR+tuzJdZTV4pnJ" +
       "NHuByRuzLi8MBpww7jpJJG9GGYh3q+imIlYhcYa5XsfyopbdZTMBqS2rc6yM" +
       "iRuxrNIbREkWGQU3bALWJQ1pzzqzvsRjzgarJB20ASsVxFZQf8gv5vU5OoS6" +
       "zZWSVdZBbVWOxJ7h2/q63VdldlATpK6z3tQYsu9IepueErDpD7u06Xc4aoDg" +
       "C2RmCUFPqxBDSsKw1WrI1TSMRiG6vK1miLHCEdYC4UWmujafNEdzvQ07AzGz" +
       "qAarN+o1GgRic6odB95mLk9WM3G2qCESCNYcW8azjWvrTRxe89mqFdNomBmG" +
       "Q6ebeksaY92pNoEr03ZW00mWhQV1XkVgTSFIWxRSJpnm8haCdxjYNQ2NboEY" +
       "T5qbswWyxVUmbFtYg+4xPcFJ6UW9Wh+t1WV/VM+MtgLX4mSNLPEutx7zm7Jn" +
       "0+56WzN0am6YXApeFzsCQS+wBkT7C2HKJ1K8Kk8gVkWDOpvJnL0O8Yq4nk8W" +
       "EIJAtcZ4ZuoOotVxGJr2trYbxNo6mGcTcjTmR2irjE4kDmLY5TLu2go87Q3F" +
       "HteHLZWaEJMRCPzn9MgvW37C9jsqkSpkuh45ThrPPdz02y4UVLdlf9EPhAmy" +
       "HK3Kxngrwh2elsIV6WbuFHHwfoVESVWsVGx7nXreNhlGabfLEisfDnnGF4UN" +
       "v+UToyHOWlYPs6pzQ9Tr1AKFsDY2h1vQ2KONZrHs9Pk3tpR1X7Fqd3joZ2U3" +
       "8oyX38BqVXba1l3xu1DaHxA5+H9scfPYNs7hbiv+Ax+OyPfHHrvRaaBib+zz" +
       "H3/5FXX0i/D5/bppLy7dFXv+e21trdnHmMl36p+98Z4SUxyGOtrY+d2P/9dH" +
       "+PcvP/wGjku87QSfJ5v8AvPFr3ffqXz6fOm2w22e645pXVvpuWs3dy6FWpyE" +
       "Ln/NFs9jh3OTrzmXngUXs58b5uTC89HsXydH5wo52knPGXt8//iMvN/OyW/E" +
       "pQcMLT42j0eL2Edy95tvZGuwSPi1a2E+BS5+D5O/9TC/dkbeP8/J78SluwFM" +
       "wktcNULaJ+B99SbgXc4THwTXB/fwPnjr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4X3jjLw/zMm/jEsXATzuYKvvCNq/ulloj4JL3UNTbz20b52R98c5+Q9x6U0A" +
       "2vDajcMjgP/xJgDenyfmG2T2HqB96wH+2Rl5/y0nfwKMfy6a+02/BCjhZrcX" +
       "eQTy27cCZLwHGd96kH95Rt5f5eS/nwJSPAHyf9wEyAfyxMfA9ZE9yI/ccpDn" +
       "bj8j70Ke+P04P0DAHd8rPUR3rnSz6PJ90xf36F689eiunJF3f07ujkv3mhF5" +
       "cuP1COE9N4GwOJ3UBNdLe4Qv3RqE544KVAooj54B8/GcPAQcYnS9Qzx1P3Ht" +
       "meoR/odvFn8+w5/d4//sLcdfHJU7Vz4D/3tz8k7gSqJDV3LuiSN877pZfPkR" +
       "jV/Y4/uFHxK+xhn48JwgwJ9EJ/zJcZTVm0VZBdcX9ii/cMtRUgWS1hkoOzl5" +
       "P7C30SlO5TjSH70VSL+8R/rlHxLS0RlIxzkZnIJUPIGUuhWS+5U90q/ccqTF" +
       "Ub1zP3YG0g/lZAZi2Fwzj/zLcYzCzWKsgeure4xf/SFhNM7AaOZkEZcuA4wn" +
       "vMxxnMpN4HxrnvhucH19j/PrtxRn8Qzen991eFr5uvflSXG7/z6pgB2dMSRp" +
       "TlwwJEqoybG2q2y6xkFHj57oaFdAU/v509GQeW/oYCfwf6d88pCf3374uq+x" +
       "dl8QKb/yyuU7H3pl+m+KU/+HX/ncRZfu1BPbPn7c8dj9BT/UdLMYz7t2hx/9" +
       "AvTH4tIzr3sBIs5fsg8eClP+0V0rfyMuPX52K3HpDvNgnA5qvRiXHr5Rrbh0" +
       "G6DHS//tuPTm00qDkoAeL/l349KVkyVB/8X/4+V+GuA5KheXLuxujhf5NGgd" +
       "FMlvf8Y/EIT+61+xaS6iONeulmfnX3fEWghmtVgr2a3g7KT44eMKVETn97+W" +
       "EB1WOf7FQ85G8anfwSJLsvvY73nlS68Mhj/x3fov7r64UGx5u81buZMuXdx9" +
       "/FE0mi/UPHnD1g7autB75nv3/upd7zhYVLp3x/CRMh/j7W2nf97Qcfy4+CBh" +
       "+5sP/dr7/uErf1ScTft/PO2CpIM5AAA=");
}
