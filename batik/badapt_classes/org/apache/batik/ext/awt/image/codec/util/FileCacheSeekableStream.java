package org.apache.batik.ext.awt.image.codec.util;
public final class FileCacheSeekableStream extends org.apache.batik.ext.awt.image.codec.util.SeekableStream {
    private java.io.InputStream stream;
    private java.io.File cacheFile;
    private java.io.RandomAccessFile cache;
    private int bufLen = 1024;
    private byte[] buf = new byte[bufLen];
    private long length = 0;
    private long pointer = 0;
    private boolean foundEOF = false;
    public FileCacheSeekableStream(java.io.InputStream stream) throws java.io.IOException {
        super(
          );
        this.
          stream =
          stream;
        this.
          cacheFile =
          java.io.File.
            createTempFile(
              "jai-FCSS-",
              ".tmp");
        cacheFile.
          deleteOnExit(
            );
        this.
          cache =
          new java.io.RandomAccessFile(
            cacheFile,
            "rw");
    }
    private long readUntil(long pos) throws java.io.IOException {
        if (pos <
              length) {
            return pos;
        }
        if (foundEOF) {
            return length;
        }
        long len =
          pos -
          length;
        cache.
          seek(
            length);
        while (len >
                 0) {
            int nbytes =
              stream.
              read(
                buf,
                0,
                (int)
                  java.lang.Math.
                  min(
                    len,
                    bufLen));
            if (nbytes ==
                  -1) {
                foundEOF =
                  true;
                return length;
            }
            cache.
              setLength(
                cache.
                  length(
                    ) +
                  nbytes);
            cache.
              write(
                buf,
                0,
                nbytes);
            len -=
              nbytes;
            length +=
              nbytes;
        }
        return pos;
    }
    public boolean canSeekBackwards() { return true; }
    public long getFilePointer() { return pointer; }
    public void seek(long pos) throws java.io.IOException { if (pos <
                                                                  0) {
                                                                throw new java.io.IOException(
                                                                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                                    getString(
                                                                      "FileCacheSeekableStream0"));
                                                            }
                                                            pointer =
                                                              pos;
    }
    public int read() throws java.io.IOException {
        long next =
          pointer +
          1;
        long pos =
          readUntil(
            next);
        if (pos >=
              next) {
            cache.
              seek(
                pointer++);
            return cache.
              read(
                );
        }
        else {
            return -1;
        }
    }
    public int read(byte[] b, int off, int len)
          throws java.io.IOException { if (b ==
                                             null) {
                                           throw new java.lang.NullPointerException(
                                             );
                                       }
                                       if (off <
                                             0 ||
                                             len <
                                             0 ||
                                             off +
                                             len >
                                             b.
                                               length) {
                                           throw new java.lang.IndexOutOfBoundsException(
                                             );
                                       }
                                       if (len ==
                                             0) {
                                           return 0;
                                       }
                                       long pos =
                                         readUntil(
                                           pointer +
                                             len);
                                       len =
                                         (int)
                                           java.lang.Math.
                                           min(
                                             len,
                                             pos -
                                               pointer);
                                       if (len >
                                             0) {
                                           cache.
                                             seek(
                                               pointer);
                                           cache.
                                             readFully(
                                               b,
                                               off,
                                               len);
                                           pointer +=
                                             len;
                                           return len;
                                       }
                                       else {
                                           return -1;
                                       } }
    public void close() throws java.io.IOException {
        super.
          close(
            );
        cache.
          close(
            );
        cacheFile.
          delete(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xwYPVteF9kGRnfwRn6R/A2koeerIJwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7C8zk1nUed1faXa0eu5JsS1Gsh6VVGmns5Tw5M1hXzpBD" +
       "DsnhzHA4M5wZts2a7+Gbw9eQk6pxDLQyasA1EslxkERoAadxA8VOixgpkKZQ" +
       "0UcSJAiQ1GjTAI3cJmjTOkbtAk2COk16yfnf+/+rXUhof4CXHPKcy+/ce853" +
       "z728/1vfgu4PA6jke3am2150Q02jG6bduBFlvhreoJkGKwahqmC2GIZTcO+W" +
       "/PwvXP2T735+de08dFGAHhdd14vEyPDckFNDz05UhYGuHt7FbdUJI+gaY4qJ" +
       "CMeRYcOMEUY3GejBI6oRdJ3ZhwADCDCAABcQ4M6hFFB6WHVjB8s1RDcK19Df" +
       "gs4x0EVfzuFF0EeOV+KLgejsVcMWFoAaLue/eWBUoZwG0HMHtu9svs3gN0rw" +
       "6z/+g9f+yQXoqgBdNdxJDkcGICLwEgF6yFEdSQ3CjqKoigA96qqqMlEDQ7SN" +
       "bYFbgB4LDd0VozhQDxopvxn7alC887DlHpJz24JYjrzgwDzNUG1l/9f9mi3q" +
       "wNYPHdq6s5DI7wMDrxgAWKCJsrqvcp9luEoEPXtS48DG630gAFQvOWq08g5e" +
       "dZ8rghvQY7u+s0VXhydRYLg6EL3fi8FbIuipMyvN29oXZUvU1VsR9ORJOXb3" +
       "CEg9UDRErhJBHzwpVtQEeumpE710pH++Nfz4537IJd3zBWZFle0c/2Wg9MwJ" +
       "JU7V1EB1ZXWn+NDLzBfED/3KZ85DEBD+4Anhncwv/c3v/MBHn3n713Yy33uK" +
       "zEgyVTm6JX9JeuS3P4y91L6Qw7jse6GRd/4xywv3Z/ee3Ex9EHkfOqgxf3hj" +
       "/+Hb3L9Zfurn1G+eh65Q0EXZs2MH+NGjsuf4hq0GPdVVAzFSFQp6QHUVrHhO" +
       "QZfANWO46u7uSNNCNaKg++zi1kWv+A2aSANV5E10CVwbrubtX/titCquUx+C" +
       "oIfBAT0Gjpeh3V9xjqAIXnmOCouy6BquB7OBl9sfwqobSaBtV7AEvN6CQy8O" +
       "gAvCXqDDIvCDlbr3II9McRPBhgO6H5Y90GG7hiEALCwXnKiqJUq2CpxNFZ0b" +
       "uff5/5/em+btcW1z7hzoqg+fJAobxBjp2Yoa3JJfj1H8O1+59RvnDwJnryUj" +
       "qAOg3NhBuVFAKUgWQLlRQLlRQNl1/xlQoHPnCgQfyCHtJEE3W4AwAJU+9NLk" +
       "b9Cf/MzzF4CH+pv7QB/lovDZjI4dUgxVEKkM/Bx6+4ubH+F/uHweOn+cmnMz" +
       "wK0ruTqbE+oBcV4/GZKn1Xv1tT/6k69+4VXvMDiPcf0eZ9yumcf88ycbPPBk" +
       "VQEselj9y8+JX7v1K69ePw/dB4gEkGckAmcHvPTMyXcci/2b+zya23I/MFjz" +
       "Ake080f75HclWgXe5vBO4QmPFNePgjZ+MA+G58HB7EVHcc6fPu7n5Qd2npN3" +
       "2gkrCp7+qxP/p3/3t/5brWjufUq/emSQnKjRzSM0kld2tSCMRw99YBqowFGi" +
       "//hF9sfe+NZrf61wACDxwmkvvJ6XGKAP0IWgmf/2r63/wzu//6Wvnz90mgiM" +
       "o7FkG3J6YGR+H7pyByPB277vEA+gIRuEZO4112eu4ymGZuROnHvpn199sfK1" +
       "P/7ctZ0f2ODOvht99N0rOLz/PSj0qd/4wT99pqjmnJwPg4dtdii249bHD2vu" +
       "BIGY5TjSH/mdp3/iV8WfBiwNmDE0tmpBduf2AicH9cFoT9PwblCuH0e7ICw6" +
       "FC4kXi7KG3fSG+GprPo5lkKvlhfPhkeD5nhcHklzbsmf//q3H+a//c+/U1h5" +
       "PE866iMD0b+5c8u8eC4F1T9xkiFIMVwBufrbw79+zX77u6BGAdQoA4YMRwFg" +
       "rvSYR+1J33/p9/7Fv/zQJ3/7AnSegK7YnqgQYhGc0AMgKtRwBUgv9T/xAzun" +
       "2FwGxbX8KoUOGgYqGgZKd870ZPHrQQDwpbN5icjTnMPQfvJ/j2zp0//5z25r" +
       "hIKRThndT+gL8Fs/9RT2yjcL/UNqyLWfSW9nc5ASHupWf875X+efv/ivz0OX" +
       "BOiavJdv8qId5wEngBwr3E9CQU567PnxfGmXHNw8oL4Pn6SlI689SUqHowi4" +
       "zqXz6ysneOihvJWfBcfH9kL0Yyd56BxUXGCFykeK8npe/JX9sL/kB0YCkom9" +
       "uP9L8HcOHH+RH3ll+Y3d0P8Ytpd/PHeQgPhggLsYFgGSa5d3rJeXSF50d5W2" +
       "z/SVV45b8r3gKO9ZUj7DksEZluSXvaJ5yAh0eD6M5uPpfmw+tB+bxF76cwTm" +
       "8B5hvgCO2h7M2hkw+buBeX8Bcx/ik/sQOdFVPKdThOkpcOf3CPcZcCB7cJEz" +
       "4N66G7gXpVhjVPfOccwGhgMGrWQvy4Zffewd66f+6Od3GfTJoD0hrH7m9b/7" +
       "lzc+9/r5I/OWF26bOhzV2c1dCoAPFyhzGvzInd5SaBD/9auv/vKXX31th+qx" +
       "41k4DiaZP//v/s9v3vjiN379lITuAphhneiRT95jj+S5dHuvR9pn9Ih7Nz1y" +
       "AfQIMPjFs7ujGPp2rfvmP3zht374zRf+UzEKXDZCQD6dQD9ldnVE59tvvfPN" +
       "33n46a8UGdZ9khjuaOjktPT2WeexyWQB96GDNvhwbvJzwJZ/tmuC3TmC5PeY" +
       "40uBoYDkHgUoJ3JggPHX1XE3MQLPdUAd+1OJ/xev2TmEsueS+WkVgfbLIvXU" +
       "5OGVvEj2u/7V07v+fH75/YA1NMMV7YOgtFVX383c9LyI/fTgFed3esfzk3xk" +
       "AhNoz1Xz5Gr/2Qf2yedg8QI8TG8DG0Avn+1rg6LLD8fRX/30f39q+srqk/cw" +
       "q3j2hCuerPIfDd769d73yT96HrpwMKretrJxXOnm8bH0SqBGceBOj42oT+/a" +
       "v2i/XePnxYtFE5/I+fZTm/z35+7w7PN58dmc4/Om3vXMHcR/LIVOkIp3j6SS" +
       "R9XH90jl42eQyhfuiuZ3HnWqBwNb9BM4f/wecT4Njk/s4fzEGTj//t3gvOR7" +
       "Be3kP3/yBKh/cI+gXgQHugcKPQPUz94NqMuaF7sKPiJOa75LkufZquieAPvl" +
       "dwW7q+YcSNfur95o3ijyrH98OpwLeywB0rJ8oTL/9al9cE+Ytnx9P4vj1SAE" +
       "wXjdtJv7JHDtkCB2S30ngJJ3DRQQxSOHlTHAa25+9g8//5t/74V3wOhDQ/cn" +
       "ebIM4v3IG4dxvpD6d9564+kHX//GZ4upKWhc/lMv/o+C3H75TubmxdeOmfpU" +
       "buqkoHBGDKNBMZtUldza0/zl7i2LHv1Fsh5Snf2/wUwUax2F11zZKUkcS/uk" +
       "2+SGVWPpV31JnVeahGXR/tjqd4fVqtNf8AN9MU1q7mgqaVrMBIlLmyqR9die" +
       "uJj10AAnFKxb8oZYfzWhTK+OdHhhSuqD7WaGY9a6j2G2QK4NauOVyJrbHDba" +
       "NSasbed6ZVCLqs22m4xKSpNtNZ2MjK1al6axNr80qbJUofyKiKTawKiKiE3Z" +
       "WdvryWU2I+eLyQJplwR4hPT71pJmhj26H7H5KOBVOhVhXJ0I1nzr9Kd0ZegP" +
       "xLGXlqzKerYYzpbeOu4K/YYRzaUBzxG8bWjumqJCopzhCMctw3Rm2XZPLZWJ" +
       "Xs8edTA+nVp2awmjFa7OzLLAS5selbQotKYqdV0YSEpW7VuURDA9f2HMRdFr" +
       "LTkjXCLyhF8KsemVgpEXcu4gjKywXUsltLF0t1h5Oi7Z3TaawsooYjrcFJXK" +
       "5kSRNTEMlOmkwvfEiY8iSlOQfM4NeglFzPylPuQaOhd50+1aSKvd8cjZBnJs" +
       "ox2Nq/Ghb8WuxHZderbuoha9dCaClhLdwXo+SGYb2E/t+bpHVZvpRoiJqtio" +
       "CJu53DV0fpHCC0WuaeimJ1oazc77Q69rZXgH18vl3ljslC1k4kTTHu+tbbS8" +
       "NtBQV731zFiHoTZX6JHd7YWTrM4gpETqwlDU6Qie2tzCwxf6Ntwy0+00bYrz" +
       "xri9hrMI84YdBN4uiDqx2pbr3U0675expSNIHeAFs54U8oy8oCwD7bmhVt1u" +
       "qI5HCE4fTbhWJRmWscmSwmsYR3B0r15n9ZHtbzaoGHgD1PE2YZcoz4R5hWo5" +
       "Dd/pICtuLOmlcBbodECjS9wzB5uhnvT4MR4ynUqQISO1vVWjJOYlycd5Gu2t" +
       "RjPeJkpO2FlP5p2InjvrmYt2N5zRlAO8qfRbKSwQ2JjU4zGhdzRWQcoNMLhL" +
       "TCjKxLZPGQMinsSIOVjFk27GWwkzaoihWB9kop4peIQ2tLDeqDTnUhP2M9Qa" +
       "L1XJ5luTxUDV7FCssFqC9Eolh+733Zjm5lngLLdLXB2Gfj0l6LloV3pDZ9U3" +
       "13w9s6prn0mQkl2ZYnKZ4da0qVhWQ7LZ+aQ3WWvrqNuQUpTr+UIH5xfdEOnb" +
       "iqoJ1lCntFZdWNEdJMb16QKL6dJoWOPsVYsbwOMY4xhnzfitRWPKwUg0wicy" +
       "PVhVabqOr9stJYInIeiKZaVVW8UdrjrAmYgoGUJ5ZTD91B5rlawnYmNmo407" +
       "c75MjfCuLxmOPzM71b7DGyJZ68FVVyMHvtm2dauz9kWys5n1E3NJ25UhiFeq" +
       "5sNRs9ts1IfYdqObnDxP6UFAcRPKomdOXybQxlwXxks6W/QmHLnuZj2Cw/qy" +
       "btqU5XXwoVrq6R2ci2sSsSHmi2Z7u5jry7nobYcdtLwS+2Ei1+aNmQz6fcZm" +
       "ZVFEWDkeuXAFtwcpZWECLdg2nc4m5TKX9XBMS6L1sCNxdOb4kWi7/gQrCfis" +
       "ofiYQUtzap3yiDvhEIdu1beDlrjV6W6j3Fqs6lXD7rNbu9poG8Mq0tbwjOe0" +
       "rYQycrjCMRphS2JH66dJtyxyyziZN2s1V0dGtWlpFbNsz6YzNSCcjtFFKmhv" +
       "4/RBQ6sxzyHCyEiNxTJu+9a42bBwWHdWETavr7K2rEyNFVlz/I4nTWPf4Xhy" +
       "a2eMIZqCiTjdpGtKKse2WmiIrFC4WiX6Vbw5ZGCzWrN6ZgLSAnGkoJKpr9W5" +
       "0VHZmG+04XZlE0uGzFQWSX+1IfsjM+O6qRLUzV5cni4kabIkqlUhqQ1BK47Z" +
       "pKnUUIlb6lXPj6pUwyTK49YM61GlZcQuYFZ0WjKbrNJKU0hRJGw53pLpNwQX" +
       "V3la0S132ZxlC9Iz5L415iI6qPa3k800m0fesLRawtWtlriCCW99WxdWaBYM" +
       "Rj2hXInGTMwOXYWmJDeoIc2s0nKWxsBRYt4Zh045JEKlNB/6hjOk0mqjV2mH" +
       "cORPy1F1PMew5bzlqVk83KasUKF7HhpucZ5VxKDHWw5g/QXCWvJSL2vbLCYi" +
       "ZNakK4OuqBJ1pIYuJddR0ri0cEM/nDDNSkPTgiiA4RLujnypVG61fcqtcmWM" +
       "YfG6vJGZbgvuDcGgpSypDV2pSeyI76rr1Kx2iTG/4lZrNJam+Ko6ElqEw3ft" +
       "ilZqWQq7HSaN8cqh2z665gVlwnJ0bWpS04SiRSrFXLkl9iZ1jjOJBVqmUHYk" +
       "UIvuqIdRkoNh/HRgxdS62aovTSzyt7DmaFWt7cmuWet6w1BeGqZdItbyYGEu" +
       "nG69I+KlSgmpj1QycZmmg+kp73HkZtxVdbcdzoRBDdakbscntyVCteCOq3db" +
       "Iltj5hukRE3JYWvIUabiGtFASbuDhZJumyHcYhRfbCkDb81trK5EK1avtKhg" +
       "GdLOOjNPEKb+jOWabpIw2YpoKxOu25wwepkch9XyBmV8n/DrgNfgoGP3EsKe" +
       "19F+k1csdEkuUwSXKa1kmn0fNuq4p/FTH/OH+IZwzKVodKkKzYkgj+FSosVp" +
       "YpmX0wXe7voJMQbRE4DoZOE5Uyd8U2qOnRUbRLrrySU9obuDoeORcjhsdmO5" +
       "Q2MBNxir8SYrz9hGAxFolYvkRttvummElXiUzsLRpjdxXbsbzZga5tUM3+9P" +
       "q1trqTLUahu62JJkFlgUze1lr8WgE9wabYIuytGMMBxyGOx4wz7SR6VhH8us" +
       "gB5jlBIJMS/Dfi1LErHUbs1nan9A6Tomxc1VaVCTFm23QuLwlOeNprQYtDaV" +
       "EWDJmrvmcBEdzrUN0cIDD07Hjp92YlgP7Uq10cTLtZqv21goBDo1SDFVrEVp" +
       "u7INWawjYuHE6kxZLYJhMFflk6rR3gSlSK3qK2liZENkPsBHXT9DBJGv1jm9" +
       "rW11pLVku3gtJPhZrSStUymrLtXSYA67XqKU1Mg1VtOqsPTbaEwM15VOu7SY" +
       "mT0mKE/gOVuL/FlFH/KLrORnTtAf8mBeDDNkiHuBA4+9rFRlatLKCetifzmZ" +
       "ZLg7Hoe9tu0k4nCqlJFqmVmsFODOk0U02mykRoetNqdtPGuHa6aK4EIfCVWt" +
       "T1bMKqxVVp5H6y46DKqburpuDOXttEazG7paZvEqYy0ntkfxJDpzja1ntsim" +
       "OJrwQ3osw0tMrpcpOuxXcFOUGRmMxgZiWwTSHDcrWhMfzpNFJtPwNiMXWRIA" +
       "Omq0w9KmmriIN8NSylfJKuelY3abRGTN3KZLu7bVm5uasyTRTVMg4NSeAS+f" +
       "NksTSkRm6qpWw3rmqDouMcN2N2MH0cpyhz0dL5EsUqOIIFwM+SwN5iWpVDet" +
       "puG10glK+JwwnE11xPPLfbsadOp12QQszq6kFc6rLGL0OvFsTqtrMR0Haqwp" +
       "JKZNGx24Ue/NVuFE8Nsrvq3xaUfSF5V0vZVqiV8q1bquwviJ24sFL4B7tXLU" +
       "yTIwrkw4KrMBJyzIVeRFpGIhpsXXJ2Gf1K0IDkcwMxDmWj8qLxojkfKa42BE" +
       "whWK1Br6vFeZ2OasosGrAG8HbtUddcvGOq7jmFRPp0mJjUt43BrVax3WXo08" +
       "sYcvaBmDeUVX6vikVp9blkYsZWPQAnw4KC3LK0kqa8v2hExLgBJbU2swKrXG" +
       "s6bnYT2pbtNms21OBLEO3L5cU1errkMaNXqB6lUiLiNmham3GnjHXbaHVqtp" +
       "y+RCHNXmvTJr45Np0A1Rx5/EkcAo87Y/l9dDfuwofNW2XKHvJCsaGze2/pJy" +
       "uq5aN8dNeJy69a4HuIbUxcWy31hP3dClG4v5RkmqZkmoukxSnTXXpDcAmajb" +
       "E/35aBbNtzzGw7AlqiYuyJpByPp2KehlPIrBlGg96QwizUyxriwl8TrZ6Hjc" +
       "6HRJeaETI4ooMbU5gXozk6uJfEv1Zw1bQto4idt1FBfiQVPqtxyJWTq+36XW" +
       "IWWGZneGx2RS45hkGnc3Q2MwnLGwDuLTFRg8zTiO2CijeEQ2ar1wipYlYlGt" +
       "JtuI1JC6vuoyMpmh2ULVlmZ3MhOcLj/qmXMDplOksUlMRuTQnjkZDTpbgUSR" +
       "ZWJ2u7O+tLFnpkhE5Wm/pRFmhnlzBzc5pTta9zN7MaZLMqqTfH2blL3BoGrX" +
       "VZdBOpsKiTHGIFMnprCVBZ2gQpTSoyGy0BGuFA38VVMJhQgRk9UWm3VGLdsl" +
       "MOCi7iKsC+TWXEzAVG0CSNqorxlBI/2WDzfGOD0LMDcupzTT73l0q6K3bW5r" +
       "jMhUtPvr1qAezWKPXraU1pijwHsmpEax+FjDSTQpr6ktnGR6g63w2gCkH2Ds" +
       "omojGl6JIp5M5vyiQgJ8rhEOLGTJM2EkynMTTJIGBrHFsro/hp0lzdc7ZcFY" +
       "b/gSKmdlt74uYSsqIaOUAfNNfzqOl2yvSZTCCbcS8eWUmKDrwSLWIyTrMeNO" +
       "xzGJJkVajjXGE8lVQC7IZCzPrDazdsygWKPfqYxxnIRjPJkNglLDnsJbJhrW" +
       "BTkl4FpDZCu1vhOWicE6SiyEZ5vsyKrXHG4BB+bAIhvVlsaOKnRbU/vbOpKt" +
       "12VhU4pn/kC3VQbkQ63ZqE3bnhg2xAofzhOSCyjFYVwgXhbQcJQwxnYrxGnY" +
       "2pYxaZGadcpRK40tPEgWwgZWB3C1oqVLn8NBZk2lAzMkl7w2dOkesQ4Mculi" +
       "4zLp1RLH3Xh1MIMtwSVQs1uB3VodoUbddEl26jDNtFtIf72Q7GgTYnxfdAOU" +
       "ZGazrUawjK+OxErssz1vZJkBgYR11JCwPrV2SnhLERC6PoFXIWvXw2gbBC2G" +
       "RDJhPam0GKzSwodwJK7ZmTSY9tKV7BsNVIw2gifYnVmjVTE7GDaqjgI8VAJu" +
       "5nSqOtYkZ0G5txS2hFnbppsly0cq0bZ6nKttOBfh4E7V8lQ1oOhNp5Mv3/yr" +
       "e1tCerRYLTvYJbe3cvRL97BylN5pIX/3roNlyOIvX4s8tuHqyDLkkU/pUP6V" +
       "6+mz9sQVX7i+9OnX31RGP1M5v7e+bETQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("A5Hnf8xWE9U+UtWl4vozBzAKKE+BQ9iDIZxcDT20/45LoadvlSjW3gqB3z1b" +
       "oF4I/F5e/FsAO1BFZeZGRrGx7ycPW/7r77Zmd3SN/YSZj+c38++4r+6Z+eq9" +
       "mvn9p5p5dEn/D+/w7L/kxTsRdE0W3Xy3FyrK1kYMdt/L3jq08RvvwcZCLP/4" +
       "+9qeja+9/zZ++w7P/mdefDOCHtHVKP+MzR5Zrj+08I/fg4UP7lv4xp6Fb7w/" +
       "Ft7mrH/+bs76F3nxpxF0Xwg689QvJ4lnKIdW/9l7sPoqtOfAX96z+svve7+e" +
       "e/BdDD6Xf20/dxHYlUdnfls/MO7cpffDuD/YM+4P3h/jLhxSfVzALYrClCfe" +
       "zdbvyYvHTrf18ffqvk+AV53f6e7O729HvvBuxuUfOc89s/tOWXzdPwcdWvfs" +
       "vViXRtATZ2xhzffjPXnbTvvd7nD5K29evfzEm7N/v9tjsL+D+wEGuqzFtn10" +
       "G9SR64t+oGpGYf4Du01RfmHORyPopbvecQu6ND/llpwr7fThCLp+N/p5g+Xn" +
       "o7rVCHrmzrpAqzgf1WpE0JNnaUXQBVAelW5F0AdOkwaSoDwqeROMLiclwfuL" +
       "81G5VyLoyqFcBF3cXRwV6YDagUh+ifr7Hwtbd7+x+bgzpOeOpzIHpPjYu3nb" +
       "keznhWPbEIr/9djfMhDv/tvjlvzVN+nhD30H+ZndNlvZFrfbvJbLDHRpt+O3" +
       "qDTfdvCRM2vbr+si+dJ3H/mFB17cz6ce2QE+DNAj2J49fU8r7vhRsQt1+0+f" +
       "+MWP/+ybv1984/y/EW05HoQzAAA=");
}
