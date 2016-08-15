package org.apache.batik.dom.svg;
public class SVGOMFETurbulenceElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFETurbulenceElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_BASE_FREQUENCY_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_NUM_OCTAVES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_SEED_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_STITCH_TILES_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_TYPE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      STITCH_TILES_VALUES =
      { "",
    SVG_STITCH_VALUE,
    SVG_NO_STITCH_VALUE };
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_FRACTAL_NOISE_VALUE,
    SVG_TURBULENCE_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedInteger
      numOctaves;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      seed;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      stitchTiles;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected SVGOMFETurbulenceElement() {
        super(
          );
    }
    public SVGOMFETurbulenceElement(java.lang.String prefix,
                                    org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        numOctaves =
          createLiveAnimatedInteger(
            null,
            SVG_NUM_OCTAVES_ATTRIBUTE,
            1);
        seed =
          createLiveAnimatedNumber(
            null,
            SVG_SEED_ATTRIBUTE,
            0.0F);
        stitchTiles =
          createLiveAnimatedEnumeration(
            null,
            SVG_STITCH_TILES_ATTRIBUTE,
            STITCH_TILES_VALUES,
            (short)
              2);
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              2);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_TURBULENCE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBaseFrequencyX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFETurbulenceElement.getBaseFrequencyX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBaseFrequencyY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFETurbulenceElement.getBaseFrequencyY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getNumOctaves() {
        return numOctaves;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSeed() {
        return seed;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getStitchTiles() {
        return stitchTiles;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFETurbulenceElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
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
      ("H4sIAAAAAAAAAL17eazs1nnf3CfpSXraJdtSZUt+kp4cy+Nczj7DyIu4zcZl" +
       "OCSHwxlbeeZwG85wG+5DV7VjNLXbALbRyrEDJEJaOKnrKnZaNGmA1oWLuk0C" +
       "BwESuEtaJE7bAE3qGrD/SFLUSdNDztzl3ffelZ4l9AI8l3PW7/d93/md75CH" +
       "r363dEfgl8qea20Nyw0PtTQ8XFnNw3DracHhkGqysh9oKmbJQSCAvKvK07/8" +
       "wJ/94LPLBy+ULs5Lj8iO44ZyaLpOwGmBa8WaSpUeOMklLM0OwtKD1EqOZSgK" +
       "TQuizCB8nirdc6ppWLpCHYkAAREgIAJUiAAhJ7VAo/s0J7KxvIXshMGm9DdK" +
       "B1Tpoqfk4oWlp67txJN92d53wxYIQA935b9FAKponPqly8fYd5ivA/y5MvTy" +
       "53/8wX96W+mBeekB0+FzcRQgRAgGmZfutTV7ofkBoqqaOi895Giaymu+KVtm" +
       "Vsg9Lz0cmIYjh5GvHSspz4w8zS/GPNHcvUqOzY+U0PWP4emmZqlHv+7QLdkA" +
       "WN92gnWHsJvnA4CXTCCYr8uKdtTk9rXpqGHpnWdbHGO8QoIKoOmdthYu3eOh" +
       "bndkkFF6eGc7S3YMiA990zFA1TvcCIwSlh6/aae5rj1ZWcuGdjUsPXa2Hrsr" +
       "ArXuLhSRNwlLbz1bregJWOnxM1Y6ZZ/vMu/79EedvnOhkFnVFCuX/y7Q6Mkz" +
       "jThN13zNUbRdw3vfQ/20/LavfepCqQQqv/VM5V2df/7Xv//Ce5/8+m/s6rz9" +
       "BnVGi5WmhFeVLy7u/513YM/Bt+Vi3OW5gZkb/xrkhfuz+5LnUw/MvLcd95gX" +
       "Hh4Vfp37d7OPf1n7zoXSpUHpouJakQ386CHFtT3T0vye5mi+HGrqoHS35qhY" +
       "UT4o3QnuKdPRdrkjXQ+0cFC63SqyLrrFb6AiHXSRq+hOcG86unt078nhsrhP" +
       "vVKpdCe4Ss+C60dKu7/8vhSWVGjp2hokK7JjOi7E+m6OP4A0J1wA3S6hBfD6" +
       "NRS4kQ9cEHJ9A5KBHyy1fYHq2lAQA1cSeyO6SwiRv4is3Cg5VYBODnNv8/4/" +
       "jZPmeB9MDg6AKd5xlggsMIf6rqVq/lXl5Qglvv+Vq9+8cDwx9poKS1Uw9OFu" +
       "6MNi6EMw9CEY+vBmQ5cODooR35KLsDM8MNsaEACgxnuf418cfuRTT98GPM5L" +
       "bgc6vwCqQjdnaOyEMgYFMSrAb0tf/0LyE+LHKhdKF66l2lxskHUpb87mBHlM" +
       "hFfOTrEb9fvAJ//4z7760y+5J5PtGu7ec8D1LfM5/PRZBfuuoqmAFU+6f89l" +
       "+Veufu2lKxdKtwNiAGQYysB5Ac88eXaMa+by80e8mGO5AwDWXd+WrbzoiMwu" +
       "hUvfTU5yCsvfX9w/BHR8f+7c7wKXvvf24n9e+oiXp2/ZeUputDMoCt59P+/9" +
       "3H/67T+pF+o+ougHTi16vBY+f4oW8s4eKAjgoRMfEHxNA/V+/wvs3/vcdz/5" +
       "ocIBQI1nbjTglTzFAB0AEwI1/+RvbH7v23/wxW9dOHaag7B0t+e7IZgzmpoe" +
       "48yLSvedgxMM+K4TkQCzWKCH3HGuTBzbVU3dlBeWljvqXzzwbPVX/tenH9y5" +
       "ggVyjjzpva/dwUn+X0NLH//mj//5k0U3B0q+sp2o7aTaji4fOekZ8X15m8uR" +
       "/sTvPvEzvy7/HCBeQHaBmWkFf5UKNZQKu0EF/vcU6eGZsmqevDM47f/XTrFT" +
       "EchV5bPf+t594vf+1fcLaa8NYU6bm5a953celieXU9D9o2cne18OlqBe4+vM" +
       "hx+0vv4D0OMc9KgAMgtGPiCd9Brn2Ne+487//K//zds+8ju3lS50S5csV1a7" +
       "cjHPSncDB9eCJeCr1PvgCzvjJneB5MECauk68EXG48eecU+e+Qy4nL1nODee" +
       "AXn6VJFeyZMfOfK2i160sEzljKtdOqfDM0a5sCe7/PdbQchYYM+jjsNd1HFU" +
       "8OwN+RZZAMoBqsBdJco5tpD2hXPs3s0TuCiq5cmP7SRvvi7d7eo+Vvy6BIz7" +
       "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" +
       "0AjqNh1C8zZlkcym3nFZH7WVai1c+VSd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("QjNpOQM7sKo8kCR+MiSmmtWq9Cr1OVyuxP2qD9VIqGYNE3INIzXDVA3YX3Ss" +
       "+mBOjaseTM0b0KZqxi08oxIQw4eNph7YcpOBtYZc5k1pTUWqCUEtvNGIer4U" +
       "mvVGF8XtrkDwVI9ot51GrUMyjY47Jd32BmlxJB26WQAIDdXJxMFiSg65JiLC" +
       "rtJNghEZbX3dSLE1x5UXOgiVocSi402PmdQ3PbDIJpsOTKbJdJ0NNazVrzTB" +
       "mq9hwNkporNuBMPVwMVFXE8k0/HCdcwrHslMG1jsTas4sxCpKbQm/bIktru1" +
       "FtQBw27VpD7wEQQpnp5949Yerz1UPDU8PpT4QzwvTE+98zh+sFr85S8Vnt3f" +
       "P3vmweqpd/kHR09+35U/+U3qyukHvjc4yZW/DnviZkcTi1dhX/zEy6+oo1+o" +
       "Xti/H9mEpbtD1/tRS4s169TI9xT32bWPgys5vr3UydnHwSd6OfdZ8Dnvan7v" +
       "nLL/kiffCktvNx0zLF6kaYhlUWasIWHom4so3D8mP/vQM3ZN9cRa//5WTlWc" +
       "UcG9eWYZXB/bq+Bjt6KCsHSn55uxHGqvqYc/OafsO3ny38PSYyd6uFYJefnv" +
       "nwD+ozcA+OE880lwfWYP+DO3avP3vybWPz2n7M/z5Hth6V5DCylXkS1m/7oR" +
       "OcH3/TeA74k8My///B7f5990fAcH55QVxPMXgGgAPlQOtK6vbSIwm7fS0bR/" +
       "6gbT/trXVSea+Ms3QxM/v9fEz7/5mnjgnLKH8uTSDTQxywvuOAZ5cM8bAJl7" +
       "cjF/v7QH+aU3H+TbzynLX4YfvC0s3QdAMte9Z336HFPvX66eqOHRN2rrK+D6" +
       "6l4NX33z1fDcOWXlPLkC6BCogdc09YyFn30D0J7OM/NF6lf30H71zYfWPKcs" +
       "DxAOKmHp/hza9a9vb7SI3+Cd7Ykuqm9UF8+B62t7XXztzdcFdk4ZkScf2Jl5" +
       "fyjk4OR448EH3wC0R/LM/JTVN/bQvnGr0F4zFjkYnVM2zpMhgOZoCeOqx2d9" +
       "Hjxt3+OCAi75BuA+lWfC4PrmHu4333y4L55TdjVPJBBy5JY8c/jw+EChdIJ1" +
       "dksnV0G/N/suIT9h/dh1n0PtPuFRvvLKA3c9+srkP+7O7x19ZnM3VbpLjyzr" +
       "9KHOU/cXPV/TzUIbd++OeBYH5w50IMXNzlaEpdtAmgt+oO1qm2HpLTeqDWqC" +
       "9HRNa+8Up2uGpTuK/6fruWHp0km9sHRxd3O6ig96B1Xy28A78rgPvsa3HqYV" +
       "av7xeTg+lB1V9tWTYDHdhSePnXa8Iph4+LVseNzk9AcB+cm14iu3o1Nm0e47" +
       "t6vKV18ZMh/9fusXdh8kKJacZXkvd1GlO3ffRhSd5ifVnrppb0d9Xew/94P7" +
       "f/nuZ4+2MPfvBD6ZBKdke+eNj/4TthcWh/WzX3v0n73vH77yB8VRjP8HilNk" +
       "/X44AAA=");
}
