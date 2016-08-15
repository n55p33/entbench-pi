package org.apache.batik.apps.rasterizer;
public class SVGConverterFileSource implements org.apache.batik.apps.rasterizer.SVGConverterSource {
    java.io.File file;
    java.lang.String ref;
    public SVGConverterFileSource(java.io.File file) { super();
                                                       this.file = file; }
    public SVGConverterFileSource(java.io.File file, java.lang.String ref) {
        super(
          );
        this.
          file =
          file;
        this.
          ref =
          ref;
    }
    public java.lang.String getName() { java.lang.String name = file.getName(
                                                                       );
                                        if (ref != null && !"".equals(ref)) {
                                            name +=
                                              '#' +
                                              ref;
                                        }
                                        return name; }
    public java.io.File getFile() { return file; }
    public java.lang.String toString() { return getName(); }
    public java.lang.String getURI() { try { java.lang.String uri = file.
                                               toURL(
                                                 ).
                                               toString(
                                                 );
                                             if (ref != null && !"".equals(
                                                                      ref)) {
                                                 uri +=
                                                   '#' +
                                                   ref;
                                             }
                                             return uri; }
                                       catch (java.net.MalformedURLException e) {
                                           throw new java.lang.Error(
                                             e.
                                               getMessage(
                                                 ));
                                       } }
    public boolean equals(java.lang.Object o) { if (o == null || !(o instanceof org.apache.batik.apps.rasterizer.SVGConverterFileSource)) {
                                                    return false;
                                                }
                                                return file.
                                                  equals(
                                                    ((org.apache.batik.apps.rasterizer.SVGConverterFileSource)
                                                       o).
                                                      file);
    }
    public int hashCode() { return file.hashCode(
                                          ); }
    public java.io.InputStream openStream() throws java.io.FileNotFoundException {
        return new java.io.FileInputStream(
          file);
    }
    public boolean isSameAs(java.lang.String srcStr) {
        if (file.
              toString(
                ).
              equals(
                srcStr)) {
            return true;
        }
        return false;
    }
    public boolean isReadable() { return file.
                                    canRead(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZbXBU1fXuhnyHfEEAgQQIwTaou6KCo0EqxASSbkImwcy4" +
       "qOHu27vJg7fvPd67myxQWj/agTpTBy2i7Sg/OjhaquK0dbQfOlimVap1qtJa" +
       "a0XHdqa2ylTGqW2l1Z5z79t9b99+MOmY7sy7+/bec8493+fcu4+cIeW2RdqY" +
       "zkN8l8nsUI/Oh6hls3i3Rm17C8yNKfeW0Q9vfnfwqiCpiJL6CWoPKNRmvSrT" +
       "4naUtKq6zamuMHuQsThiDFnMZtYk5aqhR0mLavclTU1VVD5gxBkCjFIrQpoo" +
       "55YaS3HW5xDgpDUCnIQFJ+H1/uWuCKlTDHOXC77AA97tWUHIpLuXzUljZDud" +
       "pOEUV7VwRLV5V9oiF5mGtmtcM3iIpXlou7baUUF/ZHWeCtofb/jo3IGJRqGC" +
       "OVTXDS7Es4eZbWiTLB4hDe5sj8aS9k7yZVIWIbUeYE46IplNw7BpGDbNSOtC" +
       "AfezmZ5KdhtCHJ6hVGEqyBAny3KJmNSiSYfMkOAZKFRxR3aBDNIuzUorpcwT" +
       "8Z6Lwgfvvbnx+2WkIUoaVH0E2VGACQ6bREGhLBljlr0+HmfxKGnSwdgjzFKp" +
       "pu52LN1sq+M65Skwf0YtOJkymSX2dHUFdgTZrJTCDSsrXkI4lPOrPKHRcZB1" +
       "niurlLAX50HAGhUYsxIU/M5BmbVD1eOcLPFjZGXs+CIAAGplkvEJI7vVLJ3C" +
       "BGmWLqJRfTw8Aq6njwNouQEOaHGysChR1LVJlR10nI2hR/rghuQSQFULRSAK" +
       "Jy1+MEEJrLTQZyWPfc4Mrr1zj75JD5IA8Bxniob81wJSmw9pmCWYxSAOJGLd" +
       "ysghOu/p/UFCALjFByxhnvzS2Wsvbjv+vIRZVABmc2w7U/iYciRW//Li7s6r" +
       "ypCNKtOwVTR+juQiyoacla60CRlmXpYiLoYyi8eHf3HDLUfZe0FS00cqFENL" +
       "JcGPmhQjaaoaszYynVmUs3gfqWZ6vFus95FKeI+oOpOzmxMJm/E+MksTUxWG" +
       "+A0qSgAJVFENvKt6wsi8m5RPiPe0SQiphIesh2cZkR/xzcn28ISRZGGqUF3V" +
       "jfCQZaD8dhgyTgx0OxGOgdfvCNtGygIXDBvWeJiCH0wwZ4Gaph22qA3uo+5m" +
       "VnhkdCPE0iQ4E7N6gbMRgRhCnzP/r7ulUfY5U4EAmGWxPyloEE+bDC3OrDHl" +
       "YGpDz9nHxl6QDodB4miNkyuBgZBkICQYCCEDIZeBUGEGSCAg9p2LjEhXAEPu" +
       "gJQAObmuc+Sm/m3728vAB82pWWCFIIC259SmbjdvZJL9mHKsefbuZadXnQiS" +
       "WRHSTBWeohqWmvXWOCQxZYcT53UxqFpu8VjqKR5Y9SxDYXHIXcWKiEOlygCh" +
       "cJ6TuR4KmdKGQRwuXlgK8k+O3zd16+hXLg2SYG69wC3LIdUh+hBm+Ww27/Dn" +
       "iUJ0G/a9+9GxQ3sNN2PkFKBM3czDRBna/Z7hV8+YsnIpfWLs6b0dQu3VkNE5" +
       "hQiEZNnm3yMnIXVlkjvKUgUCJwwrSTVcyui4hk9YxpQ7I1y2SbzPBbeozYTp" +
       "CidkxTeuzjNxnC9dHP3MJ4UoHteMmA/87qW/XC7UnakzDZ4GYYTxLk9uQ2LN" +
       "Ios1uW67xWIM4N68b+ib95zZt1X4LEAsL7RhB47dkNPAhKDmrz2/8/W3Th85" +
       "Fcz6eYBDcU/FoEdKZ4XEeVJTQkjY7UKXH8iNGmQM9JqO63XwTzWh0pjGMLD+" +
       "3bBi1RPv39ko/UCDmYwbXXx+Au78BRvILS/c/I82QSagYG12deaCyYQ/x6W8" +
       "3rLoLuQjfesrrd96jj4ApQPStQ15QmTggNSBkHwBJ3UCUzVCmDaEJVeLpUvF" +
       "eAVqQSAQsXYVDitsb0TkBp2nsRpTDpz6YPboB8+cFSLkdmZeBxigZpf0ORwu" +
       "TAP5+f6MtYnaEwB3xfHBGxu14+eAYhQoKpCd7c0W5M90jrs40OWVv3/2xLxt" +
       "L5eRYC+p0Qwa76Ui8kg1uDyzJyD1ps0vXCstPlUFQ6MQleQJnzeBWl9S2J49" +
       "SZMLC+x+av4P1z50+LRwPVOQaM0Pq07H4zoLhxWOn8PhonxnLYbqs2BQpnf8" +
       "uSZj90bBO7ZfIdl+ie36Sth+AIfrxNLVOPRIpVzzP+oPJ7pNubAoW38W59Qf" +
       "cehxU+DRV6/8zUN3HZqSbVNn8bzvw1vw8WYtdts7/8zzQ5HxC7R0Pvxo+JH7" +
       "F3ave0/gu6kXsTvS+WUdypeLe9nR5N+D7RU/D5LKKGlUnEPGKNVSmNCi0Fjb" +
       "mZMHHERy1nObZNkRdmVLy2J/2vds60/6bjsB7wiN77N9eV7YpR6edser2v0O" +
       "GSDi5Qbpk2JcicMlXiNnSc0qQYq7/eIa182FW0XP51Yjuds0wLPc2WZ5EY6p" +
       "G0U35jNZDJuTMosl8LXfx2OsBI/pQhErPhXE1/b6I3ZRbmq+fFptn2z5MHm2" +
       "FjvViBPZkdsOHo5vfnCVDKLm3JNCDxyEH/3tf14M3ff2yQKNaDU3zEs0Nsk0" +
       "D7/VuGVO2A6IA58bA2/W3/3HH3WMb5hOx4hzbefpCfH3EhBiZfFM4Gfludv+" +
       "unDLuolt02j+lvjU6Sf53YFHTm68ULk7KE63MjjzTsW5SF25IVljMTjG61ty" +
       "AnN51nma0VcugCfkOE9o+pWiGGqJfL+nxNpeHCY5qRxnfNARpN+Nj6nPojSI" +
       "eSsrikCfD88aR5Q109dCMdQSku4vsXYHDrdLLfRm0pmrha/OgBaELyyE52pH" +
       "lKunr4ViqCUkvafE2r04HOCkihuyk/A5w10zpYYF8KxzZFk3fTUUQy0h6ndK" +
       "rB3B4QE4WoAzXD/c51PC4RlQwhxcw7zQ70jSP30lFEP1Ceo7NHiaR9mWiJ2O" +
       "ldDOD3A4CtphOyH527k3DVgLRlIxmw9ZahIOgZPOVdplQ9uU/R1Df5Kl6oIC" +
       "CBKu5eHwN0Zf2/6iSOpVWEWyqdRTQaDaeM63jVIXn8InAM8n+CC3OIHf0Hx1" +
       "O/diS7MXY6aJ9bVE4+kTILy3+a0d97/7qBTA32X6gNn+g3d8GrrzoKy78nZ1" +
       "ed4FpxdH3rBKcXB4CrlbVmoXgdH752N7f/Lw3n1BxzY6ZLCYYWiM6nkGh0N9" +
       "rtolr9d9veGnB5rLeqGi95GqlK7uTLG+eG5Vq7RTMY8d3AtZt8Y5XKPOOQms" +
       "NJ3jgIiY781AxGCvKGrIsOP2w9OPmGKoJZz/pRJrv8bhJGTPCTizdoOCBdQT" +
       "jjnx68ee92egJ1Wd/yg8ZsKfJzy6++UM6A7VJtrWUUcBo9PXXTHUEvp5u3Qm" +
       "avVeXwwavNdI6fGetMJM7OoEhXdweIOTGsNkOlQo5vR2gD0ng92nmynuWRNa" +
       "/MNM5exF8EQdVUSnr8ViqIU1JQqRoHq2hJo/xOF9cEPVHoEQXi+AnnR1cWam" +
       "dNEKT8wRKDZ9XRRDLSHqJ8XXAoLEvzieyocZjeONnE8RH38mtx6czCt8ZY/X" +
       "Sgvy/juU/3cpjx1uqJp/+PrXxDkq+59UHdS8RErTvGd8z3uFCYdYVUheJ0/8" +
       "phC1ipOl5ztggiLcHyhMoFIi13LSUhAZDvb45YWth37BD8tJufj2wjVhiGbh" +
       "oFWQL16QuZD+AARfW8zizYjMDou8RhC2azmf7bIo3qtlLPLiT99MFUzJv33H" +
       "lGOH+wf3nF3zoLzaVjS6ezdSqYXaJ2/ZnX7DW5T91DK0KjZ1nqt/vHpFpig3" +
       "SYbdCFjkceFuiGsTXWWh797X7she/75+ZO0zv9pf8Qq0E1tJgEKy25p/m5Q2" +
       "U3B43xrJr/Fw3hYX0l2d39617uLE394Ql5hE9gSLi8OPKaceuunVuxccaQuS" +
       "2j5SDv0GS4trrut26cNMmbSiZLZq96SBRaCiUi2ngahHr6Z4ihB6cdQ5OzuL" +
       "f4xw0p7fFuX/nVSjGVPM2oAFAclAC1LrzkjL+I7hKdP0IbgzntbxZ7IgozXA" +
       "H8ciA6aZ6RrJs6YI8ROFKzQ67ufFK751/hemISy9ECIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zr1n0f77WvfX3j+F7bje26sePHTTdH3Y8UKT5UJ1kk" +
       "6kFSlCiSIiVxWxyKD5ESX+JDoth5a4NtCZYiDTqnzYDU/yzFsiBtgqHdBnQd" +
       "XGzrA80GZCv2XhMUA9YtDZAMWFssXbtD6ve6v/twXRsTwCPynO/38Ps538f5" +
       "8pzz5W9DV5IYqkWht196YXpk5enRysOP0n1kJUccj4/1OLFM2tOTZALqXjFe" +
       "+Or13//eZ5wbl6EHNOhxPQjCVE/dMEgkKwm9rWXy0PWz2q5n+UkK3eBX+laH" +
       "s9T1YN5N0pd56F3nWFPoJn8iAgxEgIEIcCUC3DqjAkzvtoLMp0sOPUiTDfTX" +
       "oEs89EBklOKl0PO3dhLpse4fdzOuEIAerpbPKgBVMecx9Nwp9gPm2wB/tga/" +
       "9tMfvfEP74Oua9B1N5BLcQwgRApeokEP+5a/sOKkZZqWqUGPBpZlylbs6p5b" +
       "VHJr0GOJuwz0NIut00EqK7PIiqt3no3cw0aJLc6MNIxP4dmu5ZknT1dsT18C" +
       "rE+cYT0g7JX1AOA1FwgW27phnbDcv3YDM4Xed5HjFOPNASAArA/6VuqEp6+6" +
       "P9BBBfTYQXeeHixhOY3dYAlIr4QZeEsKPX3XTsuxjnRjrS+tV1LoqYt040MT" +
       "oHqoGoiSJYXec5Gs6glo6ekLWjqnn2+PPvjpHwmY4HIls2kZXin/VcD07AUm" +
       "ybKt2AoM68D48Af4n9Kf+OVPXoYgQPyeC8QHmn/8V7/7kR969o1fP9D8wB1o" +
       "hMXKMtJXjC8sHvn6e+mXmveVYlyNwsQtlX8L8sr8x8ctL+cR8LwnTnssG49O" +
       "Gt+QfnX+o1+yvnUZusZCDxihl/nAjh41Qj9yPSvuW4EV66llstBDVmDSVTsL" +
       "PQjueTewDrWCbSdWykL3e1XVA2H1DIbIBl2UQ/QguHcDOzy5j/TUqe7zCIKg" +
       "B8EFtcD1PHT4Vf8ptIKd0Ldg3dADNwjhcRyW+BPYCtIFGFsHXgCrX8NJmMXA" +
       "BOEwXsI6sAPHOm7QoyiBYz0B5uMWVgzLah/40hYYkxX3gGRyxXhU2lz0//Vt" +
       "eYn9xu7SJaCW914MCh7wJyb0TCt+xXgta3e/+/Ov/OblUyc5HrUUIoEARwcB" +
       "jioBjkoBjs4EOLqzANClS9V7v68U5GAKQJFrEBJAsHz4JfmvcB/75Av3ARuM" +
       "dvcDLVwGpPDdYzZ9FkTYKlQawJKhNz63+zH1ryOXocu3Bt9SeFB1rWQflyHz" +
       "NDTevOh0d+r3+id+9/e/8lOvhmfud0s0P44Kt3OWXv3CxWGOQ8MyQZw86/4D" +
       "z+m/+Movv3rzMnQ/CBUgPKY6MGcQeZ69+I5bvPvlk0hZYrkCANth7Ote2XQS" +
       "3q6lThzuzmoq/T9S3T8KxvhdJzb//mP7r/7L1sejsvy+g72USruAoorEH5Kj" +
       "n/kP//p/YNVwnwTt6+emQdlKXz4XKMrOrlch4dEzG5jElgXo/uvnxn/ns9/+" +
       "xF+qDABQvHinF94sSxoECKBCMMx/89c3//Ebv/2F37p8ajSXUjBTZgvPNfJT" +
       "kGU9dO0eIMHbfvBMHhBoPOB+pdXcVAI/NF3b1ReeVVrpH11/f/0Xf+/TNw52" +
       "4IGaEzP6oTfv4Kz++9vQj/7mR//g2aqbS0Y50Z2N2RnZIXo+ftZzK471fSlH" +
       "/mP/5pm/+2v6z4A4DGJfApyuCmeXDmNQIX9PCj1ccbrhUemDlSbhqukDVXlU" +
       "jkLFAFVtWFm8LznvEbc63bks5RXjM7/1nXer3/ln360g3JrmnDeAoR69fLC5" +
       "snguB90/edH9GT1xAF3jjdFfvuG98T3QowZ6NECoS4QYBKP8FnM5pr7y4H/6" +
       "lX/+xMe+fh90uQdd80Ld7OmV50EPAZO3EgfEsTz6ix85aHx3FRQ3KqjQbeCr" +
       "iqdv94mXjs3lpTv7RFk+Xxbvv93S7sZ6YfgvHwJd+YicKO1GBbVMRI4OiUj1" +
       "uo/cQ3Gdsni5amqUxQcPiMg/FfgD7VPVU5klv3T3iNsrU7SzoPXU/xG8xcd/" +
       "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");
}
