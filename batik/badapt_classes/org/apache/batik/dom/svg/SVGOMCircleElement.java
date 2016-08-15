package org.apache.batik.dom.svg;
public class SVGOMCircleElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGCircleElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_CX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     org.apache.batik.dom.svg.TraitInformation.
                       PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_CY_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     org.apache.batik.dom.svg.TraitInformation.
                       PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_R_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     org.apache.batik.dom.svg.TraitInformation.
                       PERCENTAGE_VIEWPORT_SIZE));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      cx;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      cy;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      r;
    protected SVGOMCircleElement() { super(
                                       );
    }
    public SVGOMCircleElement(java.lang.String prefix,
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
        cx =
          createLiveAnimatedLength(
            null,
            SVG_CX_ATTRIBUTE,
            SVG_CIRCLE_CX_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        cy =
          createLiveAnimatedLength(
            null,
            SVG_CY_ATTRIBUTE,
            SVG_CIRCLE_CY_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        r =
          createLiveAnimatedLength(
            null,
            SVG_R_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              OTHER_LENGTH,
            true);
    }
    public java.lang.String getLocalName() {
        return SVG_CIRCLE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getCx() {
        return cx;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getCy() {
        return cy;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getR() {
        return r;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMCircleElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "60i0hJ+kxfwVm6v/D6zlhAsOIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JCAH3cTzzE4FLGVjiSaDXqnWHsgdjhqUKVGztqxLjO2+J3kJlg4bImwo6HhF" +
       "CPhADpQmKRqWvHK3qK0Mt6Wys5Bq6yaNup4lB/F40iW5Rq9DowPgdzNPNgWV" +
       "2YbLsuaYmUxTIzeszamK58oeC2Q7pdSgNs2VUgkxkm+1jKjTd41V18qyjqI7" +
       "WY/HSwmPE5P1sN8azB0jMKvRbBhN0gXSmjaSLt2DTdyNrCbjIXqXw3mFSZrM" +
       "0pkMCXjoaFR1UTNQMSGng/GwMkIibhgt4LUGuKazwFczfFKzp5UBq0Q9t+Gy" +
       "eG3IG7oeau2olMD4yk1dQ5hvI7HLl8M+K+sRvF3A+mrSqliJ6Ch0Lw5lpln3" +
       "JXm8YsblsMOE8rKMUMlsKdds8J7rbiSitxH6dn+uzKkmSU+GuBPbdXo29IV5" +
       "1814BJkL5TEr1Jp9EDPUYK1rSctxMsTIZCyCiKVJpgRnV4aGOR9FZKKYA70W" +
       "0VK7DreZAYwumca0TmEbf6A3OAnWK5zO0jJBNbRKv1NpovMUMYeawMSbaJDM" +
       "FcMWvP7EEfXV2EOzqD2sOGXdhoOJPp6jDTEkVXIsiXiYuIsA6yU+OrQdi3JW" +
       "TispB6ut7Gx0vTLZBKqG2ki1bY5baMnuLkCjZtSvu/JmtoT7kdag4i2IyBq6" +
       "ZSuRLtSxuh6tQMkW2aAlsx1Lcpqaa8pdj3SuUukFmOq6aNC3TKvpd+l2sO7D" +
       "mDxy5qxNradE02JH9MhVtBE+BLzCly0uUKgYnXrbit/qOwO4JWc9vyevQUSa" +
       "qhxd2TILSSgz1WWC4PF8UDNW02ktqvYX5agWkJpSSaNZTMzFZFKix51WfU6i" +
       "ihsYdcteb8eKpLs1L5llsUuQOmfX0elkkVTFUVZxEDJluIiX8aqlqE3D4oZj" +
       "HoSMdhmd8lsixQOO7vT9qA+PBDoug4Am6Tu0UyuZJaMPW2s9mzq1FOnUtuBz" +
       "O+KoJV5s8nz69e2uPFxsGh2f8n8f20W7qmfy7H3H+2rF32VofyJ89P/Uvtqp" +
       "7fJLR3uQT+d7kFlFOb31eOaYNN9SeeJep/zFdsqXPv7yKyr3c+WD/Z7+J2Po" +
       "Wuz5f8HWUs0+NeZV0NPz9946YopLDif75F/7+H96fPzDxodfx+HpU+f0PN/l" +
       "32K+/OvkDyp/9QC673jX/I7rF2cbvXB2r/x6qMVJ6I7P7Jg/cXZrswTSYj8F" +
       "i/NbmyeTfOG+5gVHJl+6oO5v5NnPxtAPmK4ZF1ddNNy2aTMFn4hxaMpJrO32" +
       "OD9+ysN+IobuTz1TPXG9v/56TmGKgi8em+DBvBAGSdqbQHo9JoihK35oplKs" +
       "vaYdfvmCur+TZ1+JocdO7HDWCHn9z58A/uobAHwrL3wSJH8P2H+9c/7+18T6" +
       "6gV1/yjPfjWGHlxqMe0pks3u3RU/wff33wC+/DQSejav3uPL3nx837ig7jfz" +
       "7Gsx9ADA1z4+O3nmLrx19sDkBP3X3wz0H92j/+ibj/73Lqj713n2z/foi5OX" +
       "3zoB9rtvFNgzIH1iD+wTbz6wf39B3bfy7N8C6gHARudw/eEbwPVIXvg4SJ/e" +
       "4/r068X12hT83y6o++959m3AY66WsZ6qHTnszdMOe1xRwP0vbwBuPoNQE6TP" +
       "7eF+7k2Hewm6oK444/0uYFowjefPaI/PXecnWP/0dR3wx9CtOy9u5VdQHrvj" +
       "dujuRqPylVduXH3HK5N/UdxdOr51eI2GruqJbZ8+9T71fNkPNd0s7HBtdwbu" +
       "F+CuAVz3OqONoftAnqt86epO+sEYetvdpIEkyE9L3ti7w2lJsMSL/6flbsXQ" +
       "9RO5GLq8ezgtAjzrPiCSPz7qH/nahdfgyFDyDVOJjuK7S6dCtL17FTN167Vm" +
       "6rjJ6dtReVhXXPA9CsGS3RXfF5WvvtJnP/Kd2s/tbmcptrTd5r1cpaEru4ti" +
       "x2HcM/fs7aivy713f/ehX7r23FHI+dBO4RNXP6XbU3e/B9V1/Li4ubT9e+/4" +
       "5ff9zVd+vzgz/X93jHxteS0AAA==");
}
