package org.apache.batik.gvt.filter;
public class MaskRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.gvt.filter.Mask {
    protected org.apache.batik.gvt.GraphicsNode mask;
    protected java.awt.geom.Rectangle2D filterRegion;
    public MaskRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                         org.apache.batik.gvt.GraphicsNode mask,
                         java.awt.geom.Rectangle2D filterRegion) { super(
                                                                     src,
                                                                     null);
                                                                   setMaskNode(
                                                                     mask);
                                                                   setFilterRegion(
                                                                     filterRegion);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.awt.geom.Rectangle2D getFilterRegion() {
        return (java.awt.geom.Rectangle2D)
                 filterRegion.
                 clone(
                   );
    }
    public void setFilterRegion(java.awt.geom.Rectangle2D filterRegion) {
        if (filterRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          filterRegion =
          filterRegion;
    }
    public void setMaskNode(org.apache.batik.gvt.GraphicsNode mask) {
        touch(
          );
        this.
          mask =
          mask;
    }
    public org.apache.batik.gvt.GraphicsNode getMaskNode() {
        return mask;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return (java.awt.geom.Rectangle2D)
                 filterRegion.
                 clone(
                   );
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        org.apache.batik.ext.awt.image.renderable.Filter maskSrc =
          getMaskNode(
            ).
          getGraphicsNodeRable(
            true);
        org.apache.batik.ext.awt.image.renderable.PadRable maskPad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          maskSrc,
          getBounds2D(
            ),
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        maskSrc =
          new org.apache.batik.ext.awt.image.renderable.FilterAsAlphaRable(
            maskPad);
        java.awt.image.RenderedImage ri =
          maskSrc.
          createRendering(
            rc);
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed maskCr =
          org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed.
          wrap(
            ri);
        org.apache.batik.ext.awt.image.renderable.PadRable maskedPad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          getSource(
            ),
          getBounds2D(
            ),
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        ri =
          maskedPad.
            createRendering(
              rc);
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              ri);
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            convertToLsRGB(
              cr);
        org.apache.batik.ext.awt.image.rendered.CachableRed ret =
          new org.apache.batik.ext.awt.image.rendered.MultiplyAlphaRed(
          cr,
          maskCr);
        return ret;
    }
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
       "neVCbC+svlajVivZWMzMpjiwyPZqkgzn2nRIT9exvqfn7ny4JRnL0WawuLUQ" +
       "wg2HEtUT+zUGm/cGDvDWoUhrVsygFoervsY0ad9WG5y3ZjSz7u7sOtcQQp6K" +
       "e17Y12YMV28obbNjDHFWoOZ9tIm2WhwThzAm4hNFKHCx4Udeu++Ta6RTb1GU" +
       "rIzRpax0dbzvD3FrP/abiacvCFvf7gk05erDrMYVKgxjVIudZkwTEREEpHEz" +
       "K62vB1sjtKKcQIohY5CdupVS+K4BZ92hgGK8utlw/HJV2AstSAWyMez1LMmg" +
       "ls2B6dqSVvMiqrPQ4VSeTeZao9h2aKG9iA1MwuLFPjDIjOjLeOgvJH5pJYbY" +
       "WqkzOjCFWZIaTSwrtJa37Am9JJE6TlPz5WIdUq7SXBFbBu9TG9Lb2HCGuVNu" +
       "FHoCtauHcTcKvEXYj5B+nfGNlbSOtuFugCe7IlMaFoDoqMXOJTtdfTMsuh2N" +
       "l8KiPhraO8umuEYLZvYDdBnbvK/yCtMQc9TcERpZDBu5SIRFV91ZSLRQVZ40" +
       "VQ4EWzb22kuvyBk9qAkMnNEdWO+gUxFZB308GfUWSw8P5AEu57vId2f5MhJ6" +
       "GLaId1N1jTp5c5SpvYmzyvrNmWjlBbaW6GhaG+5mU2IYDli+Mco1YZEnpCDu" +
       "KF2b7xLOJjpsYdh1WbTqVqvTt5S2nvPdKTLkrU2xaiOLAUj8RFVp0n0CbY4D" +
       "ZkbXO1wQbKigCbIfZrto+VY/5JuNrjQbMO4WnY5mmhfGM5omaKw2b+G1upI6" +
       "/UG4cZXCnbHthaw5gkbazJ7ciISkplM7NQ19msNTSuwVKr0im21llnod3p4B" +
       "wRCLkTKK8vA1yzHByHUiS52nYdg0lJ01ydm23fEtgVy1ppMJwUhMEgLcbmPY" +
       "9HSy37PRJFeQ2aCBTJqwnNfZSX0hxJogJIlmKsJiw1NyX0f7iqEtgLOlMNuq" +
       "zfGaktWoXc9tpk3ba8SLDbEWl6giiVl3vg+suW7PVYzbjLoc1+JB+EgWGQIr" +
       "pElKgwY/lEw014U97IwmCIzv2y1zO94ahpF1Gxmp8ou4sRDpuSqN023SEIqM" +
       "1lTaqQcLYaTUNW0F86lgs7u4bvV38Jh1jPpwv9ZIzKEpelTr7+T12KbgkT1J" +
       "I7Du7+X2vJ01+shg69abKCW1jT6Vdhdyd6eb6sbnRgqMNwwMR7LJsghWwzUf" +
       "N/sCh45MCW/zhGm2plYx5jCcT/YyvIc9REjCttZZTkkMVrzMD3AzM11V67e3" +
       "W47cszN2RUmjeTOOC5QUWLCMc4E77wC5/SbVCub8YGH32MGuhTqFYCidwaIY" +
       "iCSvNNWkH2PbQkf9zGfwbGe1BZeqUYTv+IRssVNuvzIbNZHVGTHiUTblUQVr" +
       "dGZmlC3izFbFWjqnTXzPNzBSbEuzWqsg2uQQQ0N32LCDNr6Y2M4oj2h0JvZ1" +
       "ls069pIfTxC54XdtmlZyfSt3J0rPssYhroj7SHLxOi52htbQrhsjV6fmKYWk" +
       "eqK7q2ww80LCg+txDfZanXlHprbtyKJXg+0ma3C+zzXzsIaMB82lsFs16GE6" +
       "d0zOtdvxKkMYZL8dDxxS3aGTfJfVxCBqrJKkpRZw0+zT9ZW9Zumip+2UodWX" +
       "WyQrhJIW+INkl3ctmeil2oqQdpMYx1ojhOCxLu3CvTlYJdpEbStKa6xpgi/k" +
       "7y0/naPvbPfikWqj5vRs1Harfdsf/A6+2g9NT5fFh063tqq/+07O0U7+n9+U" +
       "P9skvXKyKfTUG501lVsW73+9s9Fqu+JLn37xJZ3/MnL1eBfaS6AHkyD8btfI" +
       "DPfcmA8ATh97/a0ZtjoaPtsd/fVP/9cnpt+3+cR3cPD0gUtyXmb5N9iXvz74" +
       "sPaXr0LXTvdKbzu0vtjpuYs7pNcjI0kjf3phn/T9Fw9/PgQe8ngKyMu7i2eT" +
       "fOetxY8ejOTSJv+VM4J6RfATdzkF+Itl8WNgEmIjOeyRVWSbc0YFcN+TBZZ+" +
       "Zm0//kZ7ROdHqSo+fYr60bLyveBhjlEzbw3q86B+5i5tP1sWLwLA6xPAlaLO" +
       "wH3hTYB7rKz8MHikY3DSWw/uy3dp+4Wy+KsJdAOAoy7vNp9B/GtvAmJlteUJ" +
       "3uoY4uott9pmRfA374Lzb5fFywBnfDvOz53h/MqbxVm2O8c4nbccJ1oRfO0u" +
       "OP9hWfxqAr0N4Czja3n0dwnj33sTGMuTZ+iD4EmPMaZvvbl+/S5t3yiLfwLg" +
       "rS/CQ8/g/dqb9cZnwPPJY3iffOvh/cu7tP12WfzzA7xekPp6jJKXPPGbbwLe" +
       "e8rKj4LnU8fwPvWWWujJov+R0yPm206tJ9Xr8d2zite/v4s6/lNZ/DvgtFpk" +
       "KIlx6Gz565OB3ndpoAOBoY/KX2cq+53vRGV5Ar39wiWY8kT/8dvu2B3uhWm/" +
       "9NKNBx57Sf7t6h7I6d2tBxnoATN13fNnn+fe7wsjw7QqhA8eTkLD6t9/T6D3" +
       "3iVfSsqbdKeH/t8+9Hk1gd55pz4JdA2U5yn/RwLdvEyZQPdW/8/T/XECXT+j" +
       "A4MeXs6T/AngDkjK19fCk8nA/+x3F7pqnESKllQ6zq+cS+KOTbaatkffaNpO" +
       "u5y/e1IOWl2cPEnS0sPVyee1r75Ecz/8auvLh7svGvhSLUouDzDQ/YdrOKeJ" +
       "3tOvy+2E133DZ197+Jcf/NBJUvrwQeAz9zkn2wfufNGk74VJdTWk+NXH/s73" +
       "/MJLv1udWv4/SNIrG9EqAAA=");
}
