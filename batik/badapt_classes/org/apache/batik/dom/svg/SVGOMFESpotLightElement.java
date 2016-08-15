package org.apache.batik.dom.svg;
public class SVGOMFESpotLightElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGFESpotLightElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Z_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_X_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_Y_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_Z_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_SPECULAR_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      z;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtX;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtY;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtZ;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      specularExponent;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      limitingConeAngle;
    protected SVGOMFESpotLightElement() {
        super(
          );
    }
    public SVGOMFESpotLightElement(java.lang.String prefix,
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
        x =
          createLiveAnimatedNumber(
            null,
            SVG_X_ATTRIBUTE,
            0.0F);
        y =
          createLiveAnimatedNumber(
            null,
            SVG_Y_ATTRIBUTE,
            0.0F);
        z =
          createLiveAnimatedNumber(
            null,
            SVG_Z_ATTRIBUTE,
            0.0F);
        pointsAtX =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_X_ATTRIBUTE,
            0.0F);
        pointsAtY =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_Y_ATTRIBUTE,
            0.0F);
        pointsAtZ =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_Z_ATTRIBUTE,
            0.0F);
        specularExponent =
          createLiveAnimatedNumber(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE,
            1.0F);
        limitingConeAngle =
          createLiveAnimatedNumber(
            null,
            SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_SPOT_LIGHT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getZ() {
        return z;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtX() {
        return pointsAtX;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtY() {
        return pointsAtY;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtZ() {
        return pointsAtZ;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSpecularExponent() {
        return specularExponent;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getLimitingConeAngle() {
        return limitingConeAngle;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFESpotLightElement(
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
       "FYu7/gekbdNwxCoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17ecwkx3Xf7JJccikeS1IUGVqkRHJpixx5+5g7lBzN0ef0" +
       "dE9Pd8/Rtkz1OdMzfV/TPQoTSYAiJQZkIaEUKbAJ/yFBsSBLhhEhAeKDiZDI" +
       "Ao0Aso04FhDJzoE4VgSbCOI4URylema+c7/9yCUXGaBreqpeVf1+r169el1d" +
       "85UflO6IwlLZ9+x8bnvxNSOLry3t2rU4943oGs3UhkoYGXrXVqJIBHkvaE/9" +
       "6v1/8cNPL65cLF2SSw8pruvFSmx5bjQyIs9ODZ0p3X+Ui9mGE8WlK8xSSRUo" +
       "iS0bYqwofp4pve1Y1bh0lTmAAAEIEIAAbSFA7SMpUOlew02cblFDceMoKP2t" +
       "0gWmdMnXCnhx6cmTjfhKqDj7ZoZbBqCFu4rfY0BqWzkLS+8+5L7jfB3hz5Sh" +
       "l/7hz175tdtK98ul+y1XKOBoAEQMOpFL9ziGoxph1NZ1Q5dLD7iGoQtGaCm2" +
       "tdnilksPRtbcVeIkNA6VVGQmvhFu+zzS3D1awS1MtNgLD+mZlmHrB7/uMG1l" +
       "Dri+44jrjiFe5AOCd1sAWGgqmnFQ5faV5epx6V2naxxyvNoHAqDqnY4RL7zD" +
       "rm53FZBRenA3drbiziEhDi13DkTv8BLQS1x67IaNFrr2FW2lzI0X4tKjp+WG" +
       "uyIgdXmriKJKXHr4tNi2JTBKj50apWPj8wP2fZ/6sEu6F7eYdUOzC/x3gUpP" +
       "nKo0MkwjNFzN2FW85znms8o7fuOTF0slIPzwKeGdzD/9m6994L1PvPLbO5kf" +
       "O0OGU5eGFr+gfUG979vv7D7buq2AcZfvRVYx+CeYb81/uC95PvPBzHvHYYtF" +
       "4bWDwldG/3r2kS8b379YupsqXdI8O3GAHT2geY5v2UZIGK4RKrGhU6XLhqt3" +
       "t+VU6U5wz1iuscvlTDMyYqp0u73NuuRtfwMVmaCJQkV3gnvLNb2De1+JF9v7" +
       "zC+VSneCq3QVXM+Udp+niyQuadDCcwxI0RTXcj1oGHoF/wgy3FgFul1AKrD6" +
       "FRR5SQhMEPLCOaQAO1gY+wLdc6AoBaY0JrgBjgm+FzPWfBEXngK0ca0wNv//" +
       "TzdZwfbK+sIFMBDvPO0GbDCDSM/WjfAF7aWkg7321RdevXg4LfZ6iksw6Pna" +
       "rudr256vgZ6vgZ6v3aDn0oUL2w7fXiDYjToYsxWY/cAv3vOs8EH6Q5986jZg" +
       "bv76dqDwi0AUurF77h75C2rrFTVgtKVXPrf+6PhvwxdLF0/62QI1yLq7qD4s" +
       "vOOhF7x6en6d1e79n/iTv/jaZ1/0jmbaCce9dwDX1ywm8FOn9Rt6mqEDl3jU" +
       "/HPvVr7+wm+8ePVi6XbgFYAnjBVgucDJPHG6jxMT+fkDp1hwuQMQNr3QUeyi" +
       "6MCT3R0vQm99lLMd+Pu29w8AHd9X2pu5vTf17XdR+pBfpG/fGUoxaKdYbJ3u" +
       "+wX/F//dv/mvla26D/zz/cdWPMGInz/mE4rG7t/O/geObEAMDQPI/fvPDf/B" +
       "Z37wiZ/eGgCQePqsDq8WaRf4AjCEQM0f/+3gD7/33S/8/sVDo7kQly77oReD" +
       "GWPo2SHPoqh07zk8QYc/fgQJuBUbtFAYzlXJdTzdMi1FtY3CUP/P/c8gX/9v" +
       "n7qyMwUb5BxY0ntfv4Gj/L/WKX3k1Z/9n09sm7mgFcvakdqOxHa+8qGjltth" +
       "qOQFjuyjv/v457+p/CLwusDTRdbG2Dqv0lYNpe24QVv+z23Ta6fKkCJ5V3Tc" +
       "/k9OsWPhxwvap3//z+8d//lvvrZFezJ+OT7cA8V/fmdhRfLuDDT/yOnJTirR" +
       "AshVX2F/5or9yg9BizJoUQOuLOJC4HOyE8axl77jzu/8i2+840Pfvq10ES/d" +
       "bXuKjivbeVa6DAzciBbAXWX+3/jAbnDXd4HkypZq6Try24zHDi3jbUXmU1v/" +
       "vvvEZ8+AIn1ym14tkp84sLZLfqLalnbK1O4+p8FTg3Jx7+yK3w+DeHHLvQg5" +
       "ru1CjoOCZ850t20VuBygip6nJYWP3aL9wDnjjhdJa1uEFslf3yGvvSHd7WQf" +
       "3f66Bwzuszd2z3gRuh15uEf/N2erH/sPf3mdAW0d8xkRy6n6MvSVX3is+1Pf" +
       "39Y/8pBF7Sey69cwEOYe1UW/7PyPi09d+lcXS3fKpSvaPoYeK3ZS+B0ZxI3R" +
       "QWAN4uwT5SdjwF3A8/zhCvDO0975WLenffPR2gnuC+ni/u5T7vjhQsvvA9dz" +
       "e9t57rQxXihtb4Zn2+PF4vY9wCijbaS+N8ofgc8FcP3f4ioaLDJ2lvlgdx9X" +
       "vfswsPLB0v5Q5thiqFgx5W6XlMORAnb4nuvscDtRex6YBznl6kZm6GLh647m" +
       "zdbQ+NcztP7JVakIwHp7NfRuoIafucG03Kphq1sJRB3ZAfT3nh+xtF3LKTTA" +
       "JsVjzSn4H3wT8Kk9fOoG8I03BD8vbpRTcMw3AYfdw2FvAMd+Q3A2Z8FxbhLO" +
       "e8El7OEIN4ATvRE4l30PPPVF7Xh6Fqz4TcCa7mFNbwBrc1OwZmfB+vCbgPXB" +
       "PawP3gDWR28KlnwWrI/dJKwKuNQ9LPUGsD75RmBdiXxDS2wlxDLfc8Eqdha6" +
       "v3uT6Krgmu/RzW+A7uffCLoHbMsB0asL4k7XaLvznWc7De/Trwtv21x2AcQM" +
       "d6DXGtfg4vdnzwZwW3H7/iIRgbRpuYp9gOaRpa1dPfDaYyOMgGu+urQbRXH7" +
       "FCbpDWMCa/l9R4EH47nz53/uP336d37+6e+BBZcu3ZEWiyFYZ49FJzsv+Xe+" +
       "8pnH3/bSH/3cNgIHmht/5Jk/2z5Kv/y6zIrkHx3QeqygJWwfaRkligfbiNnQ" +
       "C2bnxxnDcDs66X5nA3rxwe+tfuFPfmW3a3E6qDglbHzypb/3o2ufeunisb2i" +
       "p6/brjleZ7dftAV9717DYenJ83rZ1sD/y9de/Of/+MVP7FA9eHLnA3MT51f+" +
       "7V/9zrXP/dG3znjMvt0Go/GmBzZ+wCarEdU++DCIYk7WWjaamFzTNPU0H21y" +
       "dSaM1i4t1avCOpAoT5OyDMKq5mbEYWKHmpJoK1E5C9JRthFvWktXivsdojvi" +
       "F0REkxgmNjHZQ+dzAVmaYWeB9G0c7/RpaanwVlCe2ON2f9b3GAXu20y1klSM" +
       "RgwuWJpUbVdOhubQ2JAJZIBvp2a3oDYrKIm1cgQvyrozRPGEOi7OvHpbYXUt" +
       "6M4mOZEsyGw+YhaNTWo01GZdGAREDlitjbnYmQ1RARc4QuNWwpga0NbcYk3P" +
       "Xwok6WFVNvCajIj3xzORJgduIDpWTmNJLM4yno7ni/qix1NLzhbYwdgLW1KH" +
       "guHRqisOaN6uJHSqUvURMWbGtFPJy/PGRoRnfUmYRtG8RtbzQaWbdDrcQFpx" +
       "o1zoxYqORDYt1jQHCxmKF9UhvzH7Y3zOqxRiOrzey2W2Qrqt9WYSNRdOV/Ks" +
       "KKga0cxRgmXOUQgu0IiO5hXRZwimgvl9KhAVXssoJec3SmdO9DRuTkyQuO93" +
       "y7YV+HLf7CMTQnYjD8b4sSVjdkLXgnkXdkIHxpIBNOLXwkbnRNZLNhZ4nrRt" +
       "1wsrIb82DaJDQrNWX2DhdSBzEjUakZ0uNuv1qMGcpVc25xOjPCNmTW7Fz0ia" +
       "DPp1erAUVCdxiDXse/w86uicOeelUMrCcVmeo+Nld+jRiYH5TiC3JoxW5XLI" +
       "Stgcpro6jYR11A9Qaoh4RHfcoRhf48lo4/TlgTDzB9JskohOzoWy0VuL7Ylf" +
       "X6m4yPaW4x6mdLss7TnUPO5TyzXmB9pqzoykDj+UiLE7RwXbCnkQ09HdOYVa" +
       "Iyb0O9Ha8frLFZ8PGIrsaXJjbTvKDA/txWbThEkIDeNUArbGj6i2M2ElGyfL" +
       "itMJ9CUeey4RSMicpB2WnZRH5ZlR3ZSrfaw9xDS8gdPNFpu6YQsdm0Mah3Nl" +
       "wY+9TkBVpBrBWpSxHCDlsk8OcUSQvJE3cYgFzZlewzFpiZ1YlVjh4eaGzaJl" +
       "az7Ll4JRGYoh0Wi1wJwxaXzS8rFMqo15odFfdMY0p9D4sMUFPj+dtGFkFQUB" +
       "YFjj0Jbf2RhUje5u9KBjsPk8pM3BirTHjhZCnerSgtvj7rg9TVcLejool5U1" +
       "ptYMxFsuaLHHI+FiIqmDtD6eDbp9YtSSVj0+sTzM6hOLhjTWRbNLDUmL76Ne" +
       "GfMmQ2SG4h2R8xdzoC5xBsZuRo+UnoghhKgSa1lApz2TR1qDlt9fRZQ1JgjT" +
       "I3RG91Q2hOTaHFaWcUgtum1LXWINXl5NMEwd92yiNSIznvBbLcheUnWdxZqs" +
       "PTNILCe8GTcROJKjlgu0t8KotdZcWHKnTTfX7Mqbi244IPRlNAw7kK5EBBuU" +
       "NcMo2wtqzaKI1Zm3jQ7bn7i9nqSoCbXEmyY2a1aQpGY0I0WRYCynYErpyITd" +
       "6ThLwTOMNtm0l7bNJNas39YCDqtGusZTPbdf77NtOcmt2JgwiBRwrJRVfEJe" +
       "xvUc47Npv7VoZAtBImt5MyJotCE3lcqE75Bsr72uyV27yqK8CcxB0/V6qtIj" +
       "MYjRRppkTTOttPqxjPTEYEMvBvOmGAuLbAILqrsgMkbF154zkuuywhn5uMrk" +
       "cpuKWIjob4zqWqu0OKNpcJ6wljwSNxG/21lKa3XZXypBkLFoTzXHnbRaJpqZ" +
       "RYf4xHfyWEzrTDgdIAxnyLGHoLW4382qdrgIR+Q0rcRGTd8kvcHC1+qj7job" +
       "AX2tZ62FTFX0WU9VZTWe+R01nJJZ3mw1qsOW01iy80gS1hGLUr5NN+apg/Xb" +
       "htZkEqTWaFYrPbnKyty6uZYC1+97LC46Qz+kG7NRMe4U37FbkTUXDMnjNdhl" +
       "Zyre64z6QpWWZNdC0wBWY0fBKuVG0qrCnZEdDHwFrkeUjg7H5mRVLpvTkExr" +
       "fo1dYyOqgbEOjDhJqst61NQTqzbwFhsfRWo+l1rNZnuOdd0etwgFVXNbDNfO" +
       "sU0rGU+H0DhlNl1kOhvjUTTwoYrLLHEyW/JWxR2iXsuLyQ3ScFeJ6lSomt+I" +
       "hzDrs90maxmjoO6WTVTMImyWiV64XMomwrXMISXWSWxmLMROOfN6XLikdaqW" +
       "TVjBrhl62ZiEycbXGYHpkuOBE2BcNCr3vKU96c2Rzhzv1dJJ6tZjTl2J+Lgn" +
       "aciYdlO6hvPLtRfRIlKrSERbb7SakANNxHglsamGDUWjo7MTgwsyp6YYOL+B" +
       "kOViNBNtu+LKi2hsE7NBDCP0KGdbOmKHNlzHw6nHTaymCdXgQb7xp51RN17R" +
       "diAvHAmfwxmJM+uJxzq2ZTkDBt8o0wUkElrHGk6gOrFQdD8RY3y9gsbuyJMj" +
       "tju1HXou8u5kSLIrDk6XtXqt7upk6prQgra50GxzmFUHg9eUV32uApVd05io" +
       "gzXMdcYDCB9mWRniMNw1UqMG5agLqwnijspNSp/JEFuuTZa52yQmUWJ0fTKf" +
       "IVQ6qTkcQ/VNvrxGemsHWemWsOY129/AqLGR8mw4SkjGJcnuwFg35osFnVXW" +
       "y1isTpOo33XZ9TRWuzCqyNNaqrpzDkvRdaiydMdso53pKG5aZS6vt1ZlUhzk" +
       "/RoqseWkm5HemIzyPFoPHQN1jLJJ4Wh92m16REuZ5c5sWh5MY9lQ43VZbQS8" +
       "qdd5Yt3MJmU0p7lNLvWQJPAaeJ6uvWoTrBHjqO414QCq5ilfIwSHDit+paPW" +
       "WRCxjTClNfby1tT3/KEf1AYSS6wqVl5bMHwCWzSXV7JkWVmBRW8MU6nqd9Z6" +
       "jtF0NZC0jtTkW7MZn1UFMbX79cGE7c+iPoqiyzkKxzTnxHhO+mMnicJRXTAj" +
       "fSpZrWRR5yu4T8MbeEwlMawojYT0WQixdYFBgbzWxelG7gtwlC6ssb8cifCq" +
       "YjTDYKRVMiLueSjdx1MxifuzABtq/e40S1c8vbQwZMbns2an1/D6jfaUzQds" +
       "5AuYidc7Ip4vSCnstphFYo2gfCUu4mUr10nZhewRGVrd3qaeLeWVQGGa21cs" +
       "LcZ9yBxUcmRJx+FKN1UgAHOVSmMuEZt5JI4dISZmRq0hhIogiNCmHLXKGOlu" +
       "wozvqy04cBTfpHV60+/N7VDTLI3uK0OymsqERoYDyITKhhFb5hRXGSUL01UX" +
       "Rd2mmWEebCg63rBxw2ygad6YpUQNljOyUVtJCcciOhT20ubISCd5I+lB1Ibv" +
       "seNcjBobYhxsYIQPXLEvhUHOCWDOyn5YC9KFozIDWfPjWih3jNip4vV42Erj" +
       "pduYiZMOIN4nVuth2PaQVKG0aKTImSO2Ina90RekLtbgRVDZLNSeVEXS5bLS" +
       "bCw4Z6wGGynTssrUnG+iVk/PmmtG55vhGFV0tBfUevhQZVyvJcyqbpM123QD" +
       "qnpsfcZPy/y8oSgjWGWiukGgnsIEa9t0mIyahgYnNhCkXXZAOBO7TGOYU1k2" +
       "noXyJmGqeIMgq0MwPRqsBmwsrOr2cmNSBrke+FG3GSKVkU+yI5hWe+PhslJH" +
       "B7LvNpRpNJyPKYiNk+YKIZwNtJhVJlqLa48tDmU1dgOzTFxtTyZSRUsYXCqH" +
       "vXqQlkNRn9eZQXUj0V2LCfrUvIWk3EwZsJlu+/M+RaM1td2sW/amPsT5MonX" +
       "g2EyrWyUSkRazHiOtgfTichlqmT10JpRVVV6Y7irura0l33SWhl03pqQOQgH" +
       "9SE6GM1MZ7nM8KHUIqr9ob/gurPazMiqAbmm0vGkibTXfSPudCOIFbCZviLX" +
       "6HTUidp9AwNy9F5u1ETloVNBJrigLJ0hn6iT3OMXkihokoikACncxPF6NEy8" +
       "pEXY4dqhE2YhJIsRMWNrCO8yDMyNpb2Mb4DVgoBFdM12tD6ypugYq05x2vLc" +
       "UAVyB22FdXdYJZtDHoroYDThe7hEkbq/5kaszuF5x69u7EXgCisDEwDnemVa" +
       "boyQ2RRjqcYgQ3ILTqfjduRUFYp2cJVP59zE9HWj2l11xNlmamXlYN6qskO0" +
       "J6xRflGPYMouo7juwF6tLreCkWr0qGmvyeZEB6bHZq/ZUOxKnOJUeViMS6vn" +
       "l1F3vNS6w1WdoNJG3PMb7QWKzEZumXdqFEG7blPE2lOHZDdQ1M7NzBstMzTo" +
       "16xKgKlQ1B0SKmXG8QgTMKlJaynXXZOkUXMcuLHEVgqchWsNBnPZ63MIog0Q" +
       "qivznml1FpIHdQzLx3ryiOes1Tiv55pN5VLTbroVoUYEzro+isIBnmv0vFXv" +
       "dPCWOIlkp4u0WrIEqYOmjsl2HYF7K3FIlBWtjtEbhqoy9VqmN8sQGUXaShEH" +
       "jaZOZBxHsqlqamk9XNZW01qdihqc7CKsNJKchlE1Wa4pL2xroqeO2uizwaYq" +
       "c4poa1HulCNCQjsNSchhRtbh9aA24SusXGV8gbWDDdtMUnLcaDSwtJHbVXoV" +
       "tVFs0Z4LzoZJK7W+kjs6S6AM2tW1ZdAclsdIpQzsko6Br3Oh6qhS84W0N2AS" +
       "XdnAMET51VaUVgZQ6pBOlVsBc5ME11quyxCeWMpYHPMaUtXpcDKCfRjH6u0J" +
       "mqvoigrA2oH0YTabLQYtIu+om6TGLGYaKzsKRGy6sKw0gU9qLluTQGbGXSVI" +
       "xwjb7zGJv5Q7QdJUNELX6bEUitN2horTWSCXzXBo0WhlTFZaPZSlgc1z7lDS" +
       "prKpBoKFjgfrWk1P0gHVTMH8DkSRG9SWkNAfDeEN5bLZlNmM0nCN18VOEsld" +
       "dSS3WktP4RlnxWtCRXOncKfSxGdJA5obK1Vn11nXa7fb799ubH3t5na+Hthu" +
       "6B0eSHoTW3m7oieL5H2He6Dbz6XS/vDKwfexPdBjr/IunHjHuK5ox9+LXH+O" +
       "o9jzevxGp5K2+11f+NhLL+vcF5GL+5eOX45Ll2PP/0kbhGz2sY7vBS09d+O9" +
       "vcH2UNbRi7xvfuxPHxN/avGhmzjd8a5TOE83+cuDr3yL+HHt718s3Xb4Wu+6" +
       "42InKz1/8mXe3aERJ6Ernnil9/jJvWgYXC/ux+HF03vRRyN97kb0Oe90v3lO" +
       "2beK5F/GpR+zXCveHs0z2uBB1kqNdhyHlprExu5FyxePmdkvx6XbU8/Sj+zv" +
       "Gzfzmnib8VuHKrinyCyD6+N7FXz8ZlQQl+70QytVYuN19fAH55T9YZF8Oy49" +
       "eqSHk0ooyl89Ivy7b4Hwg0XmE+D6/J7w5292zN//ulz/4zll/7lIvhuX7pkb" +
       "MeNpis3uzbV9xO97b4Hf40Xmk+D6pT2/X7r1/P7snLLXiuRPgY0CftMD3/Xk" +
       "Gb7r5BvdI/LfvxXkv7Qn/6VbT/6vzin7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("UZH85Y789u3ifz/i9b9uBa+v7nl99ZbzunD5nLK3FcntO17ySV4X7nirvJ4F" +
       "19f3vL5+63k9fE7ZI0VyZTcZh8dfVh/j98Ct4Pfre36/fuv5PXlO2dNF8s6T" +
       "/E7Z5YXHbwW/b+z5fePW8/vJc8qgInnPSX6n7fPZt8qvCBBe3fN79dbza51T" +
       "9nyRVOPSQ4CfcMZ7+GM0a2+VJgKu39vT/L1bTxM7p4wokg/EpbcXa+JZL/SP" +
       "8Wy/BZ4PFZmPges7e57fuVmerxvvXeDPKROKhAFBk2usWU83DpbHK8eXx8OC" +
       "Ld3BW6BbLBilFrj+eE/3j2893RfOKSuOYVyQQVgHhvX0ibXDU2jTI64/fVPH" +
       "HePSIzc4y16cyn30uv/P7P7zoX315fvveuRl6Q+2x7kP/5dxmSndZSa2ffwg" +
       "4LH7S35omNZWGZd3xwL9LcMFIHejc2tx6TaQFrgvzHfSK2DhZ0kDSZAel3T3" +
       "NnFcMi7dsf0+LhfEpbuP5OLSpd3NcZEYtA5EitvEPzC4s8+rHh62O3iW3D17" +
       "PnrcurahzIOvN1CHVY4fFS8eIbd/fjp43Et2f396QfvayzT74dfqX9wdVdds" +
       "ZbM9yHYXU7pzd2p+22jxyPjkDVs7aOsS+ewP7/vVy88cPN7etwN8ZOnHsL3r" +
       "7EPhmOPH22Pcm3/2yD9535de/u72AM3/A8hSz6qVNgAA");
}
