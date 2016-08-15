package org.apache.batik.extension.svg;
public class BatikDomExtension implements org.apache.batik.dom.DomExtension, org.apache.batik.extension.svg.BatikExtConstants {
    public float getPriority() { return 1.0F; }
    public java.lang.String getAuthor() { return "Thomas DeWeese"; }
    public java.lang.String getContactAddress() { return "deweese@apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "Example extension to standard SVG shape tags";
    }
    public void registerTags(org.apache.batik.dom.ExtensibleDOMImplementation di) {
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_REGULAR_POLYGON_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikRegularPolygonElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_STAR_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikStarElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_HISTOGRAM_NORMALIZATION_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikHistogramNormalizationElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_COLOR_SWITCH_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.ColorSwitchElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_TEXT_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowTextElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_DIV_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowDivElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_PARA_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowParaElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_REGION_BREAK_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowRegionBreakElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_REGION_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowRegionElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_LINE_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowLineElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_SPAN_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowSpanElementFactory(
              ));
    }
    protected static class BatikRegularPolygonElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikRegularPolygonElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikRegularPolygonElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "59fF+ufEKzbf+C88xEzCqhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8bee+05eoPtfCai31zsgAAA=");
    }
    protected static class BatikStarElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikStarElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikStarElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Kz6+/V9PaIe0lhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "IAAA");
    }
    protected static class BatikHistogramNormalizationElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikHistogramNormalizationElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikHistogramNormalizationElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FxkuZCdf/PkNsf5Z8YrNN/8DkAggmboUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "1/72s98uCnb/A457eshTIAAA");
    }
    protected static class ColorSwitchElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public ColorSwitchElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.ColorSwitchElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "8ec3xPpnxSs23/wv3GkicpoUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ZaawjWXWufj3d09MM0z37MGFWGsKM0atyeSk7zVZ22bV4" +
           "qbLLayXQ1GqXa3XtLjLJgMSSEAGCgRAJ5hcoCRoWRUGJFBENQQmDQJGIUDYp" +
           "gKJIISEozI+QKCQht8rvPb/3unvQKFIs+bp8655zz7nnnO+ee+5zP4TO+R5U" +
           "cB1zszCdYF9Ngv2VWdkPNq7q7zPdCid6vqo0TdH3R6Dvmvz4Fy/9+CcfXl7e" +
           "g84L0N2ibTuBGOiO7Q9V3zEjVelCl3a9LVO1/AC63F2JkQiHgW7CXd0Prnah" +
           "VxwjDaAr3UMRYCACDESAcxFgfDcKEL1StUOrmVGIduCvoV+BznSh866ciRdA" +
           "j51k4oqeaB2w4XINAIcL2f8JUConTjzo0SPdtzpfp/DHCvAzv/n2y793Frok" +
           "QJd0m8/EkYEQAZhEgG63VEtSPR9XFFURoDttVVV41dNFU09zuQXoLl9f2GIQ" +
           "eurRImWdoat6+Zy7lbtdznTzQjlwvCP1NF01lcN/5zRTXABd79vputWwnfUD" +
           "BS/qQDBPE2X1kOQWQ7eVAHrkNMWRjlc6YAAgvdVSg6VzNNUttgg6oLu2tjNF" +
           "ewHzgafbCzD0nBOCWQLowZsyzdbaFWVDXKjXAuiB0+O47Ssw6rZ8ITKSALr3" +
           "9LCcE7DSg6esdMw+P+y/8YPvtCl7L5dZUWUzk/8CIHr4FNFQ1VRPtWV1S3j7" +
           "k92Pi/d9+f17EAQG33tq8HbMH/zyi299w8PPv7Ad83M3GMNKK1UOrsmflu74" +
           "1qubT9TPZmJccB1fz4x/QvPc/bmDN1cTF0TefUccs5f7hy+fH/7Z/OnPqj/Y" +
           "gy7S0HnZMUML+NGdsmO5uql6pGqrnhioCg3dptpKM39PQ7eC565uq9teVtN8" +
           "NaChW8y867yT/wdLpAEW2RLdCp51W3MOn10xWObPiQtB0L3gC70JfP8E2n6+" +
           "kjUBJMNLx1JhURZt3XZgznMy/X1YtQMJrO0SloDXG7DvhB5wQdjxFrAI/GCp" +
           "HrwAQaPaPtAR9qMF3Mj6CMdqHfbuZ87m/v9Mk2TaXo7PnAGGePVpGDBBBFGO" +
           "qajeNfmZsNF68fPXvrF3FBYH6xRADJh5fzvzfj7z/tHM+2Dm/etmvgKs5Xh8" +
           "rAfyMkNHoFBbzOJ9A505k4tyTybb1h+ANQ2ACwAxb3+Cfxvzjvc/fhY4ohvf" +
           "AkyRDYVvDtzNHZLQOV7KwJ2h5z8Rv2vyq8getHcSgTN9QNfFjJzLcPMIH6+c" +
           "jrwb8b30vu//+Asff8rZxeAJSD+Ahusps9B+/PTKe46sKgAsd+yffFT80rUv" +
           "P3VlD7oF4AXAyEAEPg3g5+HTc5wI8auHcJnpcg4orDmeJZrZq0OMuxgsPSfe" +
           "9eQucUf+fCdY40uZz78efL96EAT5b/b2bjdr79m6UGa0U1rkcPwm3v3UX//5" +
           "P5Xy5T5E7kvH9kJeDa4eQ4uM2aUcF+7c+cDIU1Uw7u8+wX30Yz983y/mDgBG" +
           "vOZGE17J2iZACWBCsMzveWH9N9/9zqe/vbdzmgBsl6Fk6nJypOSFTKc7XkJJ" +
           "MNvrdvIA/zVBKGZec2VsW46ia7oomWrmpf916bXFL/3LBy9v/cAEPYdu9Iaf" +
           "zWDX/6oG9PQ33v7vD+dszsjZbrdbs92wLYTeveOMe564yeRI3vUXD/3W18RP" +
           "ATAGAOjrqZpjGpSvAZQbDc71fzJv90+9K2bNI/5x5z8ZX8eykmvyh7/9o1dO" +
           "fvTHL+bSnkxrjtu6J7pXt+6VNY8mgP39pyOdEv0lGFd+vv9Ll83nfwI4CoCj" +
           "DBDOZz0ARckJzzgYfe7Wv/3KV+97x7fOQntt6KLpiMoWUMA2ALxb9ZcAxRL3" +
           "LW/dGjfOzH05VxW6TvmtUzyQ/zsLBHzi5vjSzrKSXYg+8J+sKb377//jukXI" +
           "keUGm/EpegF+7pMPNt/8g5x+F+IZ9cPJ9fAMMrgdLfpZ69/2Hj//p3vQrQJ0" +
           "WT5IDyeiGWaBI4CUyD/MGUEKeeL9yfRmu5dfPYKwV5+Gl2PTngaX3bYAnrPR" +
           "2fPF43jyU/A5A77/k32z5c46tpvqXc2Dnf3Ro63ddZMzIFrPofvYPpLRvyXn" +
           "8ljeXsman9+aKXt8PQhrP89LAYWm26KZT/zWALiYKV855D4BeWq2Ba1MLGdz" +
           "L8jMc3fKtN/fJndbQMtaNGexdYnKTd3nF7aj8p3rjh2zrgPyxA/8w4e/+aHX" +
           "fBfYlIHORdl6A1Mem7EfZqnze5/72EOveOZ7H8hRCkDU5OnX/mueiHRfSuOs" +
           "aWVN+1DVBzNV+Twh6Ip+0MuBRVVybV/SlTlPtwD+Rgd5IfzUXd81Pvn9z21z" +
           "vtN+e2qw+v5nfv2n+x98Zu9Ypv2a65Ld4zTbbDsX+pUHK+xBj73ULDlF+x+/" +
           "8NQf/c5T79tKddfJvLEFjkWf+8v//ub+J7739RskKbeYzv/BsMHtl6myT+OH" +
           "n25xLqKxPEmmhbCEtRRrE2GaPmQ9UgmZALe7TWmNFwfsrFRGR7pPldcjnpo4" +
           "fVuxsUKF5Qg/tSRz5RWRjsTPxu1Oa4B4w76hupqnuwORD1qNsY6ArLc1TqaD" +
           "qd5ZOPjcgN0hNWyyRk1na6lnpH7aw6oIMtY8gi8xaL1eT1Iste2wXqsoxUJh" +
           "aLm9BTzYmLJWNnyshzKrjlBdLv2IpwdGKW1yA9NV1XW1X+c0YlgcVVbj1KUs" +
           "ihjbzHS9kQXDFWcsW+/p641orHsztuOPRqxFkPPNPG5vrEnf5nuKv7KGxWQi" +
           "GJFlmNbckelYbCpMhx1phtmbCcsOixuVcgtrDkJlSWvNRZljDH3lsmbXjpaW" +
           "Deu0FA/MWr0iMiCA9UkfWcjzoKtHyZJMN/GcaShhKPrucNJvVFaNYRlz1aQ0" +
           "o3DHl+BeQ0Oj4ahakXlsRpubWBfX68SZVCpW2xJ9p8lvFDphfWVcXKlcCy2M" +
           "Og4vdPqcxfSd2EQQwonI+YSaTY1aRwng1qQJ0umFmYad0J24SjyoJH63ONXH" +
           "Zc6iRuN07hcWzryMBU7EzFkUdbwpak7HFuf1MC0kK61NSVtvOkN22BkWJ7a8" +
           "WvBSuUvQFKGPKxOu16M1XhREla4i6wYVTskRM6mQYxuxUMtuj91gQ9Q8M4yR" +
           "ekegFQnR8EnS6Ps9vtARx6NBRMeECXc8pkMMuoEtVIPAma6sHkz2F4u4JvYI" +
           "fCazE3ZdQcfFdGxqcksaJuFiNsCbluQvUjtgO3xx6rUJl7ZiZLgUPaHQTPBR" +
           "DW2KNELixKBcFatOm0KDMWqpgmnwraE1sDCSGnTAgQ/v2HKfHrYbrEi3PGXB" +
           "ryplux9UfUIY1nlCdPXWvFd3Gd0qw2UkXo/kuDoiuj2aa7ASbvcXZcNeTxWp" +
           "EjOtuNukBu3ltDCnZphXiBlMDeQQTRmhKHSEkVtZtYw6s15HVt3jWQxb201J" +
           "GbmWbq5qLd9vVxU/WRpCl13hPabYXo0WcznWZkQEIyCLLsRwmWcWyMhtS3y7" +
           "6XMsuZ4E3Tjs1JKy0bF7DrMxGWRRH9d7q7m9aUo0UVp24k1YkqtG2hLsDTHR" +
           "Q31dlIeR3G6Rk06zS4YNZbJixUK1MrKXXNQQkAGyaHHhUFXthMBqyRy1W6vE" +
           "ZgRb5oHTTsRigd4sHa1oUY2F3ZCwfjJh8UJkldcTgxwQzZBUjHJjmBoW0cOX" +
           "ZdFlgsW8n6ib2pTyyfpsM0crEdEjLbhUmHbEZtFKBIIerFpFHe93qGaTsNyO" +
           "tTSZ6pwucpRUN1Ue6/ujeEosC+VwMPAam3RSrjLmlGubUzaW14lf4ZctPu1b" +
           "bXQcVgSci8VGoodKXZ8Pm3M9CkJCloiE6Ksq3qZZiZxJPY5K3Yrr1TqLziKa" +
           "GD1n3OVhpkX2VXa07NkVXvWmgTizseIMncXrQXWguAtm7q8tskCumnFsjUYR" +
           "xUlkuzMIu+W+X0PHgxGFkozXQlpt3RyxjLNWelOLpup2d4T1u6sKMa5vIopB" +
           "pzMNFtiSXg45KvLo0qjXMXmAsh5OFuKCkfLcpM07NXIzpeuR0LI52DOKU1kr" +
           "jlKx0zObUkT7VtlA67jWaNlDbrz05kOzzkVR25l09Tpl6co41cmY0evxaNKZ" +
           "kvZAmOmIOyj3UmtJ2rpTrnDr8kKVe5JCeS1+GbZVOMBpn6aCPheXOIaVNJ1E" +
           "ZEyZbjCpP1ilC2aq48kGq6aF2KoXaqKKLbuRIjS4ZDKw0hUOV5t4dRIMjLUI" +
           "TxZqbbgg2EEhIlZpneBm9ioOe7jPK9Vqad4YSS0eR5tNslwQw9moBMeFauhN" +
           "arSarkxDbfrt5aSzFMmBggbDWmvTXwZCSdVCgu7IuKoznjMezuLOVDEsk55T" +
           "6wQe2pKvwmgkFAOfaq4G5RrjpFVkonLFEsFwVGlVSlbF6pLRh8tFJNQqji14" +
           "XZhB0sQAaMDUi+0yzKFqpV6wughRwHtltAKwUGQWNJXgw4ArNWEP1aORH9dX" +
           "pq+4y0KNUdVusbY0hRE706xyVVlRUrE8CzdokHCbxF6Pqg6ORBI1nw6o4sxg" +
           "Yna86lGyrUajGZoMJxaGDz170Om1XDJhyVpTXQ4Zg+3TRbKEYcX1jDUK9Ymh" +
           "4WVxgiOWN6+0CHrmMKHA8oS6sDEYLwlxO6XkrsyMx5ZQmw7kakjCdYQumQpf" +
           "lSMtJbywpqmkba6NpiCF0bxsauWO0mLnXE9AhrDltsulPl5dk43hKBBFB18V" +
           "W7pnB5LrIhGM0vX+nNY1rW/3E81cpfx0hVkuDjKDwgph2uXhkKEHtbk1FRZx" +
           "j28VzI2xHCtiwM3aS2aEFcpptaKhxtpbjVqO68HYugTXu5SUEIWCb9TdtS17" +
           "06jUnnubkTmi1x1EZOtEJeJguE0hahpj04GEsWF9OMIapVJxEY8JE2tQ8iYI" +
           "OLhrYxsKrRiYOmQ5pxktNmuYk4xNoVYL270qlUimLyDpxvfWCEAlbQ2OnQuR" +
           "UMvNjmAxnJEuFSURhkV6uqjOKdt3WH1TCEdBGXf6XtTtSBRfxBuVJVmch8WG" +
           "3+JlUoc38xnAJbyA0og8xRic6o/H6KZF1UHQwSA1qPJoI24QLYNcIN3JRJIY" +
           "r5Y2/OUK4wiBwtQeUiAKKkD1ObII5VKbTBKqW/I1BV2ncxwOxY1eZeqh0Fan" +
           "cxusJSLD0gzXuFYTWaycdKJ3youwQMV6MfRbGz9qTBwETcJIF5ext6y40crF" +
           "XXEuG64aY3LPc7w0pvSOh2FCBSUdXLHlCb2KouLGZnrkKK40RQ8GhhSWo02z" +
           "6SFNuDLXNxiit8eEzeneslRqemHC2wVyQTODdpqU5P4aFZRahzJnhIHU5QhN" +
           "u3WnuOqMBpXpJGHmA8kzi2x7ANfqjifO2mixUdIUkaoGmqHN8ZnoRVMqIkks" +
           "cWZlutPuUnC/p/BcwwqYlc0VF/UaK3FpnS8Q5SFm0wPHpu1VtAhRjLeclp4s" +
           "0LDHrNCgriUks7H6cRFTp1gQjgpKFA1xNw0p0xM0y1DYqbks1Sta1FtPmgsJ" +
           "7JP9Ci5MrWavD3K+qtuoWIhDJ8OKa8jVGJ/Gg6Bnji2eQc3NWg76bps1SLHV" +
           "H0/UFlVJSn1zjPXGHeA+Bd+MCmwkkzyndtPGatolxkGnQdCo6rsFFW5Uxkm3" +
           "GPdGEVPRO/2oK43rHQeptzV7E3pTR14BhGFnWJFEYnCoG67gem1IGWQJbaYY" +
           "BeutMmeUuOUSwbqNKJkiqzSY1KZwOyTsaZubiJNRK12HeiQhHU0aFoYeSm3q" +
           "Cw6Vl7gozyweMZiiX1PlUsK5dsL7KIDaqEQauuw6Y3ACeFN2NHjbyzud3Zkf" +
           "RI+uHMChLHtBvYxTSXLjCfcC6DbXcwJwcleVfN5daSuvatxzWLw+/D1e2trV" +
           "O84cHonfcl1JV3Gs/YMCrmSqBNujLXdbus1rHFdO1nGz89xDN7uvyM9yn373" +
           "M88q7GeKewf1phk4vh9cIx2Xx4OevPmhtZff1eyKIF979z8/OHrz8h0vo7T7" +
           "yCkhT7P83d5zXydfJ39kDzp7VBK57hbpJNHVk4WQi54ahJ49OlEOeejIPPdn" +
           "1ngIfF84MM8LNy6v3tDuZ3JH27rXqVre3tYxcgc7tOo9mVXjkpwbk3DkMLNY" +
           "Th2/RCXwnVnjAfPInioG6iGzu48zO7D+zon9n3W0PlFyC6BX3fRK4HA+5OXe" +
           "MgDfeeC6i83tZZz8+WcvXbj/2fFf5dX0owuz27rQBS00zeNlrGPP511P1fR8" +
           "TW7bFrXc/Oe9AfTwSwsXQGdBm2vyni3NrwXQgzenAeF89Hyc6jcC6PJpqgA6" +
           "l/8eH/ehALq4GwdMt304PuQjQCYwJHv8qHuDSti2DpicORaNB+iT2/eun2Xf" +
           "I5LjZfosgvMr6cNoC7eX0tfkLzzL9N/5YvUz22sC2RTTNONyoQvdur2xOIrY" +
           "x27K7ZDXeeqJn9zxxdteewgtd2wF3sXRMdkeuXFNvmWBM3hWRU//8P7ff+Nv" +
           "P/udvDD3v1NwoMYrIAAA");
    }
    protected static class FlowTextElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowTextElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowTextElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "xPpnxSs23/4vIgb39ZQUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fLOzj2HZmX1vt+yTWdrdoM+J83DS5ZXEdmLH" +
           "sZ04cRK3MPgdO34/4sR0W0Di0VIBgoVSCfYvUFu0PFQVtVJFtVXVAgJVBaHS" +
           "ViqgqlJpKSr7R2lV2tJr53vPzKJVpUbKjXN9zrnn3HPu75577vM/gC5EIVTy" +
           "PXtr2F68r23ifcuu78dbX4v2KbrOSWGkqV1biqIJ6LuqPP75Sz/68QeXl/eg" +
           "m0Xobsl1vViKTc+Nxlrk2WtNpaFLx724rTlRDF2mLWktwUls2jBtRvHTNPSK" +
           "E6wxdIU+VAEGKsBABbhQAW4fUwGmV2pu4nRzDsmNowD6FegcDd3sK7l6MfTY" +
           "aSG+FErOgRiusABIuDX/LwCjCuZNCD16ZPvO5msM/kgJfvY333L5985Dl0To" +
           "kunyuToKUCIGg4jQ7Y7myFoYtVVVU0XoTlfTVF4LTck2s0JvEborMg1XipNQ" +
           "O5qkvDPxtbAY83jmbldy28JEib3wyDzd1Gz18N8F3ZYMYOt9x7buLCTyfmDg" +
           "RRMoFuqSoh2y3LQyXTWGHjnLcWTjlQEgAKy3OFq89I6GusmVQAd01853tuQa" +
           "MB+HpmsA0gteAkaJoQdvKDSfa19SVpKhXY2hB87ScbtXgOq2YiJylhi69yxZ" +
           "IQl46cEzXjrhnx8wr3v/29y+u1forGqKnet/K2B6+AzTWNO1UHMVbcd4+1P0" +
           "R6X7vvjePQgCxPeeId7R/MEvv/im1z78wpd3ND97HRpWtjQlvqp8Ur7j66/q" +
           "Ptk6n6txq+9FZu78U5YX4c8dvHl644OVd9+RxPzl/uHLF8Z/vnj7p7Xv70EX" +
           "SehmxbMTB8TRnYrn+KathT3N1UIp1lQSuk1z1W7xnoRuAc+06Wq7XlbXIy0m" +
           "oZvsoutmr/gPpkgHIvIpugU8m67uHT77Urwsnjc+BEH3gi/UAN+vQ7vPX+ZN" +
           "DCnw0nM0WFIk13Q9mAu93P4I1txYBnO7hGUQ9Ss48pIQhCDshQYsgThYagcv" +
           "wKLR3AjYCEdrA+7kfZjn4Ie9+3mw+f8/w2xyay+n584BR7zqLAzYYAX1PVvV" +
           "wqvKs0kHf/GzV7+6d7QsDuYphnpg5P3dyPvFyPtHI++DkfevGfkKYXvpBBDl" +
           "0AisIaR8sW+hc+cKPe7JFdsFA3DlCoACgMvbn+TfTL31vY+fB1HopzcBP+Sk" +
           "8I1Ru3sMI2QBlgqIZeiFj6XvEH61vAftnYbf3BjQdTFn53LQPALHK2eX3fXk" +
           "XnrP9370uY8+4x0vwFN4foAL13Lm6/rxs9MeeoqmAqQ8Fv/Uo9IXrn7xmSt7" +
           "0E0ALABAxhIIaIA9D58d49T6fvoQK3NbLgCDdS90JDt/dQhwF+NlCHxx1FPE" +
           "wx3F851gji/lAf8E+H7jYAUUv/nbu/28vWcXP7nTzlhRYPHref8Tf/0X/1Qt" +
           "pvsQti+d2Ah5LX76BFTkwi4VoHDncQxMQk0DdH/3Me7DH/nBe36xCABA8err" +
           "DXglb7sAIoALwTS/68vB33zn25/85t5x0MRgr0xk21Q2R0bemtt0x0sYCUZ7" +
           "zbE+AGpssA7zqLkydR1PNXVTkm0tj9L/uvRE5Qv/8v7LuziwQc9hGL32pws4" +
           "7v+ZDvT2r77l3x8uxJxT8q3ueM6OyXb4efex5HYYSttcj807vvHQb31J+gRA" +
           "YoB+kZlpBaBBxRxAhdPgwv6ninb/zLtK3jwSnQz+0+vrREpyVfngN3/4SuGH" +
           "f/xioe3pnOakr4eS//QuvPLm0Q0Qf//Zld6XoiWgq73A/NJl+4UfA4kikKgA" +
           "eIvYEODQ5lRkHFBfuOVv/+RP73vr189DewR00fYkdQcoYA8A0a1FSwBhG/+N" +
           "b9o5N83dfbkwFbrG+F1QPFD8Ow8UfPLG+ELkKcnxEn3gP1lbfuff/8c1k1Ag" +
           "y3V24jP8Ivz8xx/svuH7Bf/xEs+5H95ci80gfTvmRT7t/Nve4zf/2R50iwhd" +
           "Vg5yQ0Gyk3zhiCAfig4TRpA/nnp/OrfZbeRPH0HYq87Cy4lhz4LL8Z4AnnPq" +
           "/PniSTz5CficA9//yb/5dOcdux31ru7Btv7o0b7u+5tzYLVeQPbR/XLO/8ZC" +
           "ymNFeyVvfm7npvzx58GyjoqkFHDopivZxcBvikGI2cqVQ+kCSFLz/cey0ULM" +
           "vSAtL8Ipt35/l9ntAC1vkULELiTqNwyfX9hRFTvXHcfCaA8kie/7hw9+7QOv" +
           "/g7wKQVdWOfzDVx5YkQmyfPmdz//kYde8ex331egFIAo4e1P/GuRhdAvZXHe" +
           "4HlDHJr6YG4qX2QDtBTFwwJYNLWw9iVDmQtNB+Dv+iAphJ+56zurj3/vM7uE" +
           "72zcniHW3vvsr/9k//3P7p1Is199TaZ7kmeXahdKv/JghkPosZcapeAg/vFz" +
           "z/zR7zzznp1Wd51OGnFwJvrMX/331/Y/9t2vXCdDucn2/g+OjW+/vV+LyPbh" +
           "h64sJCSdVjazUlKtG71WHPaykpcqi1p3M+uhHsmXV5LD6ylehgUM6WIE091U" +
           "xRKcYH5D7c3kBOklriQypDBdCtOpT43MNbHebIhQp/jKwKQqOJ+Q1owq2xLh" +
           "xYNyN6hOudIKY6QlX/LYUhausigbolKN86xGrawi+prTdUVronXU1dnqWFuv" +
           "tuGEZCrD+qRXCrBhxgT0djALFjSGrKYMqxhyY9XqpQSsJ5S11ZNunQtm6mDh" +
           "laTaGC8jA2toy0qDp+1VhRWmtriqpXa0EKfpInMmBJdIWz9qjBkm0reJSdHD" +
           "JTwvGylh2bg1Ej2/XpOUyDJkZTNOy/6s7SoTYpKQWKr1S52BM2f61THegiN8" +
           "A28tqbOq2mu6Phj5yiJky6hFiPxMW+FVbZ5hpGxXJkTIDjYOG6U91rU5hO2m" +
           "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" +
           "L2whIAAA");
    }
    protected static class FlowDivElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowDivElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowDivElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m2L9c+IVm2/9F6GVJ5ySFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "QJa+aL2CE0ly4wn3QuQ2z3dDeGoHajbvrqyVVTTuOSxaH/4eL2vtah1nDo/D" +
           "b76ulKu69v5B4Va2QJ1j27a3Ldtm9Y0rJ2u46VnuoZvdU2TnuE+9+5nnVO7T" +
           "+b2DWtMUHt0Pro+Oy+MjT978wMpmdzS7AsiX3/3PD47epL/9FZR1Hzkl5GmW" +
           "v80+/9Xm65WP7CFnj8oh190enSS6erIIctEHYeQ7oxOlkIeOzHN/ao2H4Pc7" +
           "B+b5zo1Lqze0+5nM0bbudaqOt7d1jMzBDq16T2rVmFAyY9ZdJUotllHHL1MF" +
           "fEfa+NA8ig+kEBwyu/s4swPr75w4+EnH6hPlthC594ZXAYdz5V7pzQL0mweu" +
           "u8zcXsApn3vu0oX7nxv/ZVZFP7oku41BLswjyzpevjr2fN7zwdzI1uO2bTHL" +
           "y37eGyIPv7xwIXIWtpkm79nSfCBEHrw5DQzlo+fjVL8WIpdPU4XIuez3+LgP" +
           "h8jF3Thotu3D8SEfgTLBIenjR70bVMC29b/kzLFIPECezLZ3/STbHpEcL8+n" +
           "0ZtdQx9GWrS9iL6mfP65Tu8dL5Gf3l4PKJa02aRcLjDIrdubiqNofeym3A55" +
           "nW898aM7vnDb6w5h5Y6twLsYOibbIzeuxTdsL8yq55vfv/933/ibz30rK8j9" +
           "L4b75P0fIAAA");
    }
    protected static class FlowParaElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowParaElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowParaElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "i/XPiVdsvvFf6jrN75QUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7oOKHwyrkdPLFRp1NXA7S1vBW0CdDqRo4bdLdaGTm2GLrhFOpYoxEZrjrl+r" +
           "0ErS4cE0sKcqZTKcJxHYql72oqmkg5baorjqRhy19E5kdPiwNHR7cthtLHGp" +
           "W66bWL7dnqgLSvLZ/BjiThIEDOUVpg6zKW2CaFQeCX28j3e7rFuYmeOa2K7L" +
           "Um0K1n1XlvJuLegV7FbYcvvllmV3rcGoGebpMG91xSWv6FCMWdDkcLxhj1m+" +
           "0FT6gxnJhgYI7fVsHdQ6Ynm5ln1oqikeOTPCmheNVX4+pXuN1obbNNukIy5t" +
           "MBIFySQKeksYzopxrlajEnWE1yp+CYyX4dRVOzW8vqaX+QnTkacNYM35QUvH" +
           "anKbEVayJFSZUd0b2fIUtyiJ0qO1bjaWE19vdDYNYahOxZbR6LbHbVcX6E11" +
           "3KnlFJCfl7zhoFvnlbA3dNoogTcFEV8IlCRZHZfdFKkkKFNBVRRDjUsCq073" +
           "y/2gy21quRzgCzlexPzZxlzbeXlgK2tF0ju8UImkkqMUyBxOePGyMBxrruUy" +
           "dabMKg5DeyohoHKNJNXOFCvaZKOVj0uVsNduoxiXw6IhS68HY9OalPvMfNmc" +
           "CI2ibPRWvTlW0jucxLcFsiDCwEp4czaOJ2EXkxYiV3LYsbvmzbE3UtnJsrgA" +
           "xW4tWGLUkK10S+5YzZfZ9YI3UGD0+wtvTmsKqVTbCe9UyEHIea0BYMo105IN" +
           "W25763UoDjQj6Cw6vXohJ4utIVmdsYwwG/TmNiuykw7dIFdMrz2tk/Gmz8yo" +
           "RFbKjknzU5YoDgf+BtSnJJ/jK8EQU122UqLoequzsWvSkKNabbU5siVrSci1" +
           "HDdpVzx0WiR7Yjz2vUqR68/9Tmk9onDGGrQcq95dK8vmvMQv/WUFq62bPbPv" +
           "120LsHO4OH2jGra4VoGv1botpT6iayO7rLBaoV8csQ4ggpquSBVW6dcHkxUT" +
           "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" +
           "yNIX7VdwIkluPOFeiNzm+W4IT+1AzebdlbWyisY9h1Xrw9/jZa1drePM4XH4" +
           "zdfVclXX3j+o3M4sQHI92va2ZdusvnHlZA03Pcs9dLOLiuwc98l3P/u8yn0q" +
           "v3dQa5rAo/vB/dFxeXzkqZsfWHvZJc2uAPKld//Lg+Kb9Le/grLuI6eEPM3y" +
           "d3svfKX1OuXDe8jZo3LIdddHJ4muniyCXPRBGPmOeKIU8tCRee5PrfEQ/P7w" +
           "wDw/vHFp9YZ2P5M52ta9TtXx9raOkTnYoVXvSa0aF5TMmKSrRKnFMur4ZaqA" +
           "70gbH5pH8YEcgkNmdx9ndmD9nRMHP+1YfaLcFiL33fgu4HAy7JXeLUDHeeC6" +
           "68ztFZzy2ecvXbj/+eFfZ2X0o2uy2xjkghZZ1vH61bHn854PNCNbkNu21Swv" +
           "+3lviDz88sKFyFnYZpq8Z0vzayHy4M1pYCwfPR+n+o0QuXyaKkTOZb/Hx30o" +
           "RC7uxkG7bR+OD/kwlAkOSR8/4t2gBLYtACZnjoXiAfRkxr3rpxn3iOR4fT4N" +
           "3+wi+jDUou1V9DXlc8932He8RHxqez+gWPJmk3K5wCC3bq8qjsL1sZtyO+R1" +
           "vv3kj+/4/G1PHOLKHVuBd0F0TLZHblyMp2wvzMrnmz+8//ff8NvPfzOryP0v" +
           "Fc0u9yEgAAA=");
    }
    protected static class FlowRegionBreakElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionBreakElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowRegionBreakElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "LSQTLv78tlj/vHjF5jv/BXW1hoeiFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL05aczrWHV+31vmzWOY92afTpmVB+2M0efsifsokMR2Ysex" +
           "EztxlhYejrfY8RZvsU2nBSSWlgoQDJRKML9AbdGwqCpqpYpqqqoFBKpEhbpJ" +
           "BVRVKi1FZX6UVqVAr53v+/J931vQqFIj+frm+pxzz7lnueee+8L3oPO+B8Gu" +
           "Yyaa6QT7ShzsG2Z1P0hcxd+n6OpA9HxFbpui74/A2HXpqc9f/sEPP7i8sgdd" +
           "mEP3ibbtBGKgO7bPKb5jRopMQ5d3o7ipWH4AXaENMRKRMNBNhNb94BoNveIY" +
           "agBdpQ9ZQAALCGAByVlAmjsogPRKxQ6tdoYh2oG/hn4VOkNDF1wpYy+AnjxJ" +
           "xBU90TogM8glABQuZv8FIFSOHHvQE0eyb2W+QeCPwMhzv/WWK79/Fro8hy7r" +
           "Np+xIwEmAjDJHLrLUqyF4vlNWVbkOXSPrSgyr3i6aOppzvccutfXNVsMQk85" +
           "WqRsMHQVL59zt3J3SZlsXigFjncknqorpnz477xqihqQ9cGdrFsJiWwcCHhJ" +
           "B4x5qigphyjnVrotB9DjpzGOZLzaAwAA9Q5LCZbO0VTnbBEMQPdudWeKtobw" +
           "gafbGgA974RglgB65JZEs7V2RWklasr1AHr4NNxg+wlA3ZkvRIYSQA+cBssp" +
           "AS09ckpLx/TzPeb173+b3bX3cp5lRTIz/i8CpMdOIXGKqniKLSlbxLueoT8q" +
           "PvjF9+5BEAB+4BTwFuYPf+WlN73usRe/vIX52ZvAsAtDkYLr0icXd3/9Ve2n" +
           "0bMZGxddx9cz5Z+QPDf/wcGXa7ELPO/BI4rZx/3Djy9yfzF7+6eV7+5Bl0jo" +
           "guSYoQXs6B7JsVzdVLyOYiueGCgyCd2p2HI7/05Cd4A+rdvKdpRVVV8JSOic" +
           "mQ9dcPL/YIlUQCJbojtAX7dV57DvisEy78cuBEEPgAeqgefH0Pb3o6wJIAlZ" +
           "OpaCiJJo67aDDDwnk99HFDtYgLVdIgtg9SvEd0IPmCDieBoiAjtYKgcfgNMo" +
           "tg9kRPxIQ1rZGOZY+OHofmZs7v/PNHEm7ZXNmTNAEa86HQZM4EFdx5QV77r0" +
           "XNjCX/rs9a/uHbnFwToFEANm3t/OvJ/PvH808z6Yef+Gma8SprPhFA10W54i" +
           "rrIICYQixMznE+jMmZyd+zP+tjYBNLoCsQFEzbue5t9MvfW9T50FxuhuzgF1" +
           "ZKDIrYN3exdNyDxmSsCkoRc/tnmH8GuFPWjvZBTOZAJDlzL0QRY7j2Lk1dPe" +
           "dzO6l9/znR987qPPOjs/PBHWD8LDjZiZez91evU9R1JkEDB35J95QvzC9S8+" +
           "e3UPOgdiBoiTgQjsGoSgx07PccLNrx2GzEyW80Bg1fEs0cw+Hca5S8HScza7" +
           "kdws7s7794A1vpzZ/evA85MDR8jf2df73Ky9f2tGmdJOSZGH5F/k3U/87V/+" +
           "Szlf7sPoffnYfsgrwbVjESMjdjmPDffsbGDkKQqA+4ePDT78ke+955dyAwAQ" +
           "r77ZhFeztg0iBVAhWOZ3fXn9d9/65ie/sbczmgBsmeHC1KX4SMiLmUx330ZI" +
           "MNtrd/yAiGMCd8ys5urYthxZV3VxYSqZlf7P5dcUv/Bv77+ytQMTjBya0et+" +
           "OoHd+M+0oLd/9S3/+VhO5oyU7Xi7NduBbcPofTvKTc8Tk4yP+B1/9ehvf0n8" +
           "BAjIIAj6eqrkcQ3K1wDKlYbk8j+Tt/unvhWz5nH/uPGf9K9jmcl16YPf+P4r" +
           "he//yUs5tydTm+O67ovuta15Zc0TMSD/0GlP74r+EsBVXmR++Yr54g8BxTmg" +
           "KIEo57MeCEfxCcs4gD5/x9//6Z89+Navn4X2COiS6YjyNqCArQBYt+IvQSSL" +
           "3Te+aavcTabuK7mo0A3Cb43i4fzfWcDg07eOL0SWmexc9OH/Zs3FO//xv25Y" +
           "hDyy3GRDPoU/R174+CPtN3w3x9+5eIb9WHxjiAZZ3A639GnrP/aeuvDne9Ad" +
           "c+iKdJAiCqIZZo4zB2mRf5g3gjTyxPeTKc52P792FMJedTq8HJv2dHDZbQ2g" +
           "n0Fn/UvH48lPwO8MeH6cPbmfgd92Y723fbC7P3G0vbtufAZ46/nSfn2/kOG/" +
           "MafyZN5ezZqf26op6/48cGs/z00BhqrboplP/KYAmJgpXT2kLoBcNduGDLOe" +
           "k3kAZOe5OWXS728TvG1Ay9pSTmJrEtVbms8vbKHynevuHTHaAbni+/7pg1/7" +
           "wKu/BXRKQeejbL2BKo/NyIRZ+vzuFz7y6Cue+/b78igFQpTw9tf8e56M0LeT" +
           "OGvwrCEORX0kE5XPkwJa9IN+HlgUOZf2tqY88HQLxN/oIDdEnr33W6uPf+cz" +
           "27zvtN2eAlbe+9xv/GT//c/tHcu2X31DwnscZ5tx50y/8mCFPejJ282SYxD/" +
           "/Lln//h3n33Plqt7T+aOODgafeavf/S1/Y99+ys3SVTOmc7/QbHBXfd3Kz7Z" +
           "PPzRxZk62UhcPFHZMoLLVqLWVc1gSWvEUorGsng4ngftqoxN7EoZg8dMCV+v" +
           "2HQihAu4GlbqZTlVapI6nbkBJQybBXK5pDmmhwpIKLpNVywMCR7jkrXGLwSh" +
           "KTpWU1uuh3BPbnAY1+7ZMB54m7JfDutBSbLbNropgD/pIq420NqijKSKVY6W" +
           "nbUV0zKNya26oSdiOkv6NbvWm6QyhXW8aTBD21OBqq2dqFFDpS5enhA8WwhF" +
           "CR0qQs1gOHNiuUpx7q/KwmJcLS7l1cjoCXHsjohFZ8GMaxUR1lN3zJbiqAcc" +
           "zPe6xojDNG4w5t3WJPEs09XWkjFa9VjGmjTxSN+4dGXYbVcGBVwkJEZC+8My" +
           "3OC7arvvWKo68Q3T5efJspFySqXnTEY1rVRPUHFOoa5IBvNUacZCyMd91FlS" +
           "G66LV6T1MMDqUsgbnVhOaJ7ErZoedopJZV5opCUUsyYjt0Wa9UjvLxLUtBNB" +
           "6AlkK0A3bozjcE2XBK2AOWGtbLv8rFsYFTZRlRyzlU2xyASi2G7ZncQvJhTP" +
           "l0QZ5frtedAaxsWy2lJGG9mXqQlsmvE4HHh4pIaWO04KiNfucROO4lBuVeA2" +
           "uMG2N0l7Q5gwx6d1kihYa8HmRZ+10jJGU8K65vbSQqlUsoKxSzewUljqtlKH" +
           "pmi6YxFJNOMQjOnphuTjXjgf8ppNNIqdWdHayDKbFlW3whslrdJnesulNecN" +
           "LXVNfiCqa3FcK7VKylglY7g95LSaM2tUUssICL44WnewALdIkRgNYktqKrYz" +
           "4Tp+v9nDCF5VarzRnVDm1BKpmYnP8VbIr6otgi6Sy2ZlOWdZhzKGLToad2XN" +
           "LCNVyUqXDUTvonqrYpGLZjXlhkxdbpCrstNe1ebzpbnqp05HKjH6VKGoUmQ7" +
           "4aipkfKGx10pGURlGo2iArouoT2LL3oJnlip0Sao6kQQBv36pKKWymaJmAf8" +
           "fLku61VXrtKr+tzEBvw05VuzkUt3bHxT1WrhKEJ0bazAKVJRKK1ouMQsDnBS" +
           "kRh+3emao+J8WRyg7JwbmbRRJWruWunGA21WGmJRWxBs35aSVR2fd5OBYIX6" +
           "mpG4qE3gHaHTJjthSy6O2A5cqvL2chBx8/6woBGqtJQbg6SbNFK8ZLeN2KYI" +
           "WxLd4VSeMDDFmc4ABVrV7Naiy8QC24Q9q7Lghr7WwSSfpuK2YZD9idTEtPJo" +
           "oTbjhY/alcpgxpTSFYemSoekGWTQ8McFLmKSEj70mtyk0i84fZxiLcoRJzPT" +
           "HIfEZt716GShmksMm8FdXJ/3qQm2soRKjTInrAmejbSO9aqiO3M97vtJ0sDM" +
           "dT/VcVszWYPoIw1Ss4glBnIQCsFbbOp0u01s1R0YZXfVNaoVuFj0iRk2nK4t" +
           "vD6m+TKNrxhlONJ9u8orohWIE9suzthoWTCLmjdq8dpkPZMqc5+mm3N/LUlw" +
           "E4SUNhy1k2RTlYn+AGjEp/lhh/bmHNPlq4U4TVK/WhvJbqPLSFNdrMCBbWHT" +
           "gKqFUyKuoI3FGJtxZDiKga83i5vuqqYOPScqTJ0C31p6tVmhgfhEl07LVZ8l" +
           "OK64sqQl48TjtOCMJNLqtCqrladikdtrBJOuk9A+OsYCu09xLWbht8UqF69S" +
           "lPZDgy5PNakvbhrmCCNHagcbxXZnGChGoZWsy8uoVVzijZ4RLmHYToOVMIrT" +
           "gKG7wcpfdu3mpIET9kpPB5ZfRxAQ5iOcJUp4oY4Lid3vM/WITM1xUV84HjPB" +
           "6qMO3Z+3ACQ9lqtwBY2WlCZYwxI9nWgm4S8rmDRr+suUQJEGHNfV+rom6VO/" +
           "Mo8xU4dXDqGtTTfxh1VYXMDkyqMXXX8jk2Ot3xnKHG7AYXOUToyCO+o0OhhK" +
           "1el6pR0hLNPQJbHVMjahgSzkSWUgIHO32WhEoqsiEsnwOLGqD6f9AtrvRw1r" +
           "hLDNuUwQQW9QqdHRwrZr2EDzq62usRBcZeZ0SH22wnB3WeCRZWNYn5davoQa" +
           "PhqVtDrSUAdWby1yCQjh3REvwSpbqvm02OhEgwgdaUU4mTR8xhy1BoI8nJK1" +
           "YViQEqZUZaOuSVjlYsvSpdas0MPpPioOOxjhh8PK2JguBgaWFpFoMCiyxNAa" +
           "rLQF43RsSpu30SZT7qdat0r4xXq9yi7CCrYo85REcVNWKHOaRitRNB0bypyl" +
           "Z20Eddmgu6yiaqS7w/nKkSfIpjdIInFgbWAK8TCb4RemT7SIGdteB7OJKba7" +
           "PNYpl8cloR6wA74DM8Bj1LRvocRwtVoonDHynKbSLA6MsF8c8kPKHyFcw0la" +
           "nToVRIpLCt2ZZxSL4mjVgOUiNul3yiYhSSTBDBGYLXejSiwjEbMQa3x5slZq" +
           "KOezterEtLsEx0zXBbRcT+MF0mAoR46ooq+VC2jQ0Gy469cVpl1WoxlpRXRn" +
           "Vka8gT0f1CMuoMh6oAlaR5hWI4SclOsBbEybCY2btmWQHh/aMR+l8NrvGUSl" +
           "XdOcajQrJBxbrFV43XOGDONrBWbMcwNqzsuVthMY/rqG4bIodZJ2358pxbY/" +
           "nkiddlqY1emhvFFFXOzTcqK1LZ/tjFdYoz3qK2FzJVMLvNpaLnmnXwc2Pikl" +
           "ItLfLMgZvCFLMSzEtaihpmmxhFFLIsS6atCPk8XI3IToeKF10TSeCdzU7o2J" +
           "qmTIQpmOyw1bIsBGjw3bmtEnRmq/tWnCnUnA6EBgfF3s8l57pUjFpllmNpXR" +
           "eq0R85q0mg60IOigyHKjeWivrqLzeWlgaDReXcdMP4pT022wnDaBJ/S0NGwt" +
           "miSnNsc9b8ULUdsXhlVB6iEiXCnO69Oqp3sJO2z1OaGcljatqT1f1qkyrBj4" +
           "EJiXsqpP+jO3Y1YXeJFrhaHXW/WW5ZqtBGupPBW6gVl3ENuEg+KyhSZBwcKi" +
           "Xqcek9NG03BrFCtq9RU7CsS2PY3qcgLTgmqLAUoUjDLVNDm2JdkqJwcd3nKI" +
           "ptcEB6VRN0BqiO7wxbGKlC1pUkctFVYklePcFO7aHhxRVFXyUgypW5VwJqwJ" +
           "smS4uJg0YZ/FfREwVRnPUSvxNkW+6o6V2pCkHHJiTlzD7dW0dUmiF+1EJvsF" +
           "Uqx4EsnS+pJm3SIZCP22ghILFWWUCrsakFMLExxiwBccHNfEHmzXsQZpphLt" +
           "Lq1ZZTAZB14PLYBV6kcJk/QbYUBMmE2A+1JDiVSHkXlqXCmpcHmJqzw9p9xB" +
           "RRi06ZpaIeSxHbW5AGZLpKL0ojVT4CqqOHSqAsUNDDe0e0y4Sapct0oZC7Vn" +
           "kQhVw2E3ludgNxrRUb0RmAYSdQ2iakRIazopLh1FJ8AxIDsevPnlndDuyQ+j" +
           "R1cP4GCWfei+jJNJfPMJ9wLoTtdzAnB6V+R83l15K69s3H9YxD58Hy9v7Woe" +
           "Zw6PxW+8obQrO9b+QSF3YSoY2yctd1u+zescV0/WcrMz3aO3urfIz3OffOdz" +
           "z8vsp4p7BzWnKTjCH1wnHefHg5659cG1n9/Z7AohX3rnvz4yesPyrS+jvPv4" +
           "KSZPk/y9/gtf6bxW+tAedPaoLHLDbdJJpGsniyGXPCUIPXt0oiTy6JF6Hsq0" +
           "8SgQ9dxWO9v3jSXWm+r9TG5oW/M6Vc/b2xpGbmCHWr0/0+qmLOXKxBwpzDSW" +
           "Y29uUw18W9Z4QD2Sp4iBckjsvuPEDrS/M2L/px2vT5TdAujR214NHM5ZeLk3" +
           "DsB+Hr7hknN7MSd99vnLFx96fvw3eVX96PLsThq6qIamebycdax/wfUUVc/X" +
           "5c5tccvNX+8OoMduz1wAnQVtLsm7tji/HkCP3BoHuPRR/zjWbwbQldNYAXQ+" +
           "fx+H+0AAXdrBAfVtO8dBPgR4AiBZ98PuTSpi23pgfOaYRx5EoFzH9/40HR+h" +
           "HC/XZ16cX08fely4vaC+Ln3ueYp520u1T22vCyRTTNOMykUaumN7c3HktU/e" +
           "ktohrQvdp3949+fvfM1heLl7y/DOl47x9vjNa/O45QZ5NT39o4f+4PW/8/w3" +
           "8wLd/wLyR5E+NyAAAA==");
    }
    protected static class FlowRegionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowRegionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "EPufF6/4+OZ/AY+puxeYFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "pkXIkeUWe/Epegl54ROPkD//vZx+F+IZ9WPJzegMErgdbeEz9r/tPXX+T/eg" +
           "OyXoqnKQHYqyFWWBI4GMKDhMGUEGeeL9yexmu5VfP4KwV5+Gl2PTngaX3a4A" +
           "nrPR2fPF43jyY/A5A77/k32z5c46tnvqveTBxv7E0c7ueckZEK3nCvv4PprR" +
           "vynn8mTeXsua12/NlD3+DAjrIE9LAcXcdGQrn/jNIXAxS7l2yF0EaWq2Ay0s" +
           "PGfzAEjMc3fKtN/f5nZbQMvaQs5i6xLl27rPz25H5TvX5R2zrgvSxPf/w4e+" +
           "/sHXfBvYlIHOrbP1BqY8NmMvyjLn97zw0Udf9dx33p+jFIAf8R2v/dc8D+m+" +
           "nMZZ08wa6lDVRzJVhTwf6MpByObAoqm5ti/ryrxv2gB/1wdpIfLsvd9efuK7" +
           "n92mfKf99tRg7X3P/dqP9z/w3N6xRPs1N+W6x2m2yXYu9N0HK+xDT77cLDkF" +
           "9Y+ff/YPf/vZ926luvdk2tgEp6LP/uV/f33/49/56i1ylDss9/9g2PDSpXYp" +
           "oGuHny42lQuxIiZjOCriTdXerItxmSuZw4ixxkrARO5QpjYyFzpBoU0sGay5" +
           "WnJpNAxxtTg3C5LDpHUMx0XG7VSaLaNJ07IUjlcOXF4tScsf1ES61+6s6kwo" +
           "juorc0qSLa9RGiWlwUJqdBZIrVKu4mwabYIe1i7pwoRPwzKO+07R4TkVL2/w" +
           "LoYuVFmqw57TmRYTSSpIwYQbpVijLkmWYHjOkk2srsCmExSvKLDtu8Uh5zvC" +
           "ONJsjxV6qt1MGYHlRnBhU/GZleAmSmmVNDqVKSstmEVz0pFGBZUhChtbWLim" +
           "mTJzqttl6/1Sf4ouZVlTWsWuXDJTo8PVl1rCcE1Dccx+te2VNMGjHIFoifyc" +
           "Dvl5r1/UyzQ128DDJT5btmYeXUrkiTUxhN7a6qNCA1ebmJSaS3mBN81FGRs0" +
           "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" +
           "89/Ka3L/C+wQNNwlIAAA");
    }
    protected static class FlowLineElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowLineElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowLineElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f0G84uPr/wVIyHzJlBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/S/ENXIpISAAAA==");
    }
    protected static class FlowSpanElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowSpanElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowSpanElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "NbH/BfGKj6//F6RVFjiUFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "KziRrG8+4X4E3eEFbgRO7Yqcz7sra+UVjfuOqtZHvyfLWrtax97RcfhNN9Ry" +
           "Zdc+OKzcipbSZuiu7W3Ltnl94+rpGm52lnvkVhcV+TnuU+967nmZ+XRp/7DW" +
           "NANH98P7o5PyBNAztz6w0vklza4A8uV3/fPDozfqb3sFZd3Hzgh5luXv0C98" +
           "lXyd9OF96NxxOeSG66PTRNdOF0EuBUoUB87oVCnkkWPzPJhZ4xGgaunQPKWb" +
           "l1Zvave93NG27nWmjre/dYzcwY6sel9m1aQi5cZsu1KcWSynTl6mCvj2rAmA" +
           "eaRAESLliNm9J5kdWn/nxOFPOlafKrdF0AM3vws4mqz4Su8WgOM8dMN15vYK" +
           "Tvrc85cvPvj8+K/yMvrxNdkdFHRRjS3rZP3qxPMFL1BUI1+QO7bVLC//eU8E" +
           "PfrywkXQOdDmmrx7S/OrEfTwrWlALB8/n6T69Qi6cpYqgs7nvyfHfTCCLu3G" +
           "AbttH04O+TCQCQzJHj/i3aQEti0ArvdOhOIh9OTGvecnGfeY5GR9Pgvf/CL6" +
           "KNTi7VX0denzz/cGb3+p9unt/YBkCZtNxuUiBd2+vao4DtcnbsntiNeFztM/" +
           "uusLdzx1hCt3bQXeBdEJ2R67eTEet70oL59v/uDB33vDbz3/rbwi97+EliE6" +
           "ISAAAA==");
    }
    public BatikDomExtension() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UapvM8X1Phh0YmJQcL8nuti8/28vnChl7RoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "coP8QjT9vVf+zht+/elv5Jcy/wt/nRPp6CUAAA==");
}
