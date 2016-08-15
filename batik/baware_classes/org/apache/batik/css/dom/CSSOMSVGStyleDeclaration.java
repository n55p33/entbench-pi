package org.apache.batik.css.dom;
public class CSSOMSVGStyleDeclaration extends org.apache.batik.css.dom.CSSOMStyleDeclaration {
    protected org.apache.batik.css.engine.CSSEngine cssEngine;
    public CSSOMSVGStyleDeclaration(org.apache.batik.css.dom.CSSOMStyleDeclaration.ValueProvider vp,
                                    org.w3c.dom.css.CSSRule parent,
                                    org.apache.batik.css.engine.CSSEngine eng) {
        super(
          vp,
          parent);
        cssEngine =
          eng;
    }
    protected org.w3c.dom.css.CSSValue createCSSValue(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        if (idx >
              org.apache.batik.css.engine.SVGCSSEngine.
                FINAL_INDEX) {
            if (cssEngine.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGPaintManager) {
                return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationPaintValue(
                  name);
            }
            if (cssEngine.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGColorManager) {
                return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationColorValue(
                  name);
            }
        }
        else {
            switch (idx) {
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FILL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STROKE_INDEX:
                    return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationPaintValue(
                      name);
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FLOOD_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       LIGHTING_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STOP_COLOR_INDEX:
                    return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationColorValue(
                      name);
            }
        }
        return super.
          createCSSValue(
            name);
    }
    public class StyleDeclarationColorValue extends org.apache.batik.css.dom.CSSOMSVGColor implements org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected java.lang.String property;
        public StyleDeclarationColorValue(java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGColor.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return StyleDeclarationColorValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      if (handler ==
                            null) {
                          throw new org.w3c.dom.DOMException(
                            org.w3c.dom.DOMException.
                              NO_MODIFICATION_ALLOWED_ERR,
                            "");
                      }
                      java.lang.String prio =
                        getPropertyPriority(
                          property);
                      CSSOMSVGStyleDeclaration.this.
                        handler.
                        propertyChanged(
                          property,
                          text,
                          prio);
                  }
              });
            property =
              prop;
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            return CSSOMSVGStyleDeclaration.this.
                     valueProvider.
              getValue(
                property);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "s8t+9vdpvv9l3mXNN/8HOTcgnaEWAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "3cWQ2dh02OkQDUkfU3BZCBMugNfSgKeJjW6aPdfosMLWc8DGiR+MBkSGEkkz" +
           "lRqEz4IVZ1iqrLlKt02xw5RTZZyFs8YK0TvYPAoHVA939Ok2qa3XW0UmjTqq" +
           "hzSAXo7aNjhkTeHipiPq22DKUI1gsGHLbiPg7T5ckgla01GlOxLn3nLaRx0s" +
           "VpakrvbKrkgufbZJLubbrp7gKdxYGeFq1XAr3pjnEbwjDHXL11ojsHN5S76l" +
           "MX+yXeVdxWb56ELnp9gm77oeyZvXHx1JFAc/lw4P/w9/Tx4LHh8JHR2pVV/2" +
           "QLw4775anLGIcbBy8sMrsL184GaXPMXW8lPveeZZQ/g0undwDvdkCl04uHs7" +
           "qUQMPX7zPXSvuOA6Phz68nv+9f7hW+0nf4Kz8IfOKHlW5O/1nvtq+w36b+1B" +
           "txwdFV139Xaa6YnTB0SXYjNdxv7w1DHRA0c+uSd3wQPg2Rz4ZHPj8+gbnxEV" +
           "8bOLmpc443zqJfremTdZCl20zN0x2aHf33hDv5u+5fjmfnGusn9MX8Tj5uV2" +
           "96eOH1Po/ptfnBwqgf7EtzEgYu677g54d2+pf+7Zyxdf86z8N8Wlw9Hd4u0c" +
           "dHG2dN2Th3on3i+EsTlzirm6fXfEFxY/H0ih+26mXQrdAtrCiF/fUf9GCr36" +
           "RtSAErQnKZ9OoStnKVPofPF7ku7DKXTpmA5kz+7lJMlHgXRAkr9+LDyc0jf8" +
           "ePmcnTuRhwdwUnj57pfz8hHLyRuNPHeLG/zDPFvu7vCv6Z9/tsu/44Xap3c3" +
           "KsCP220u5SIH3ba73DnK1UduKu1Q1oXOYy/e+YXbX38IKnfuFD7OoBO6PXTj" +
           "64uWF6bFhcP2j17zB2/+nWe/VZwQ/h+QH917WiEAAA==");
    }
    public class StyleDeclarationPaintValue extends org.apache.batik.css.dom.CSSOMSVGPaint implements org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected java.lang.String property;
        public StyleDeclarationPaintValue(java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGPaint.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return StyleDeclarationPaintValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      if (handler ==
                            null) {
                          throw new org.w3c.dom.DOMException(
                            org.w3c.dom.DOMException.
                              NO_MODIFICATION_ALLOWED_ERR,
                            "");
                      }
                      java.lang.String prio =
                        getPropertyPriority(
                          property);
                      CSSOMSVGStyleDeclaration.this.
                        handler.
                        propertyChanged(
                          property,
                          text,
                          prio);
                  }
              });
            property =
              prop;
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            return CSSOMSVGStyleDeclaration.this.
                     valueProvider.
              getValue(
                property);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "7Y4irrllP/59Rux/VnSx+dp/AYQ/BPqhFgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
      ("H4sIAAAAAAAAAL1Ze8zk1lX3fvveprubtE1CaN6bQjLl84znaW1bOvZ4ZuyZ" +
       "sT3jGc8D6NZve8bvx9jjNtAH0IqiNCpJSaU2f7UCqvQhRAUSKgpC0FatkIoq" +
       "XhJthZAolErNHxREgHLt+d67mxAhMZLvXN97zrnnnHvOz/fxwg+gs4EPFVzH" +
       "3GimE+4qSbi7NKu74cZVgl2qX2UFP1Bk3BSCYAzabkiPfPHKj15+Wr+6A51b" +
       "QG8QbNsJhdBw7GCkBI65VuQ+dOWwlTAVKwihq/2lsBbgKDRMuG8E4fU+9Loj" +
       "rCF0rb+vAgxUgIEKcK4C3DykAkyvV+zIwjMOwQ4DD/pF6FQfOudKmXoh9PBx" +
       "Ia7gC9aeGDa3AEi4kL3zwKicOfGhhw5s39p8k8HPFuBnfvNdV3/3NHRlAV0x" +
       "bC5TRwJKhGCQBXSHpVii4gdNWVbkBXSnrSgyp/iGYBpprvcCuiswNFsII185" +
       "cFLWGLmKn4956Lk7pMw2P5JCxz8wTzUUU95/O6uaggZsvfvQ1q2F7awdGHjJ" +
       "AIr5qiAp+yxnVoYth9CDJzkObLzWAwSA9bylhLpzMNQZWwAN0F3buTMFW4O5" +
       "0DdsDZCedSIwSgjdd1uhma9dQVoJmnIjhO49ScduuwDVxdwRGUsIvekkWS4J" +
       "zNJ9J2bpyPz8gH7bU++xu/ZOrrOsSGam/wXA9MAJppGiKr5iS8qW8Y4n+h8X" +
       "7v7yh3cgCBC/6QTxlub33/vSO9/6wItf3dL85C1oGHGpSOEN6dPi5W++GX8c" +
       "PZ2pccF1AiOb/GOW5+HP7vVcT1yQeXcfSMw6d/c7Xxz92fx9n1W+vwNdIqFz" +
       "kmNGFoijOyXHcg1T8TuKrfhCqMgkdFGxZTzvJ6HzoN43bGXbyqhqoIQkdMbM" +
       "m845+TtwkQpEZC46D+qGrTr7dVcI9byeuBAEnQcPdAd4rkHbX/4fQjKsO5YC" +
       "C5JgG7YDs76T2R/Aih2KwLc6LIKoX8GBE/kgBGHH12ABxIGu7HVIQQDLjgXj" +
       "HMcMOL7DhRtTaYFZA9mamb6bRZv7/zROktl7NT51CkzFm08CgQlyqOuYsuLf" +
       "kJ6JMOKlz9/4+s5BYux5KoRKYOjd7dC7+dC7YOhdMPTu7YaGTp3KR3xjpsJ2" +
       "4sG0rQAAAGi843HuF6h3f/iR0yDi3PgM8HlGCt8eofFDyCBzYJRA3EIvPhe/" +
       "n/+l4g60cxxqM7VB06WMnc0A8gAIr51MsVvJvfKh7/3oCx9/0jlMtmPYvYcB" +
       "N3NmOfzISQf7jqTIABUPxT/xkPClG19+8toOdAYAAwDDUADBC3DmgZNjHMvl" +
       "6/u4mNlyFhisOr4lmFnXPphdCnXfiQ9b8pm/nNfvBD5+XRbcj4Jndy/a8/+s" +
       "9w1uVr5xGynZpJ2wIsfdt3Pup/76z/+pnLt7H6KvHPnocUp4/QgsZMKu5ABw" +
       "52EMjH1FAXR/9xz7G8/+4EM/lwcAoHj0VgNey0ocwEEWUo7/K1/1/uY73/70" +
       "t3YOgyYE38VINA0pOTAya4cuvYKRYLS3HOoDYMUEKZdFzbWJbTmyoRqCaCpZ" +
       "lP7nlcdKX/qXp65u48AELfth9NZXF3DY/hMY9L6vv+vfHsjFnJKyz9qhzw7J" +
       "tlj5hkPJTd8XNpkeyfv/4v5PfEX4FEBdgHSBkSo5eJ3OfXA6t/xNIfS2V0nR" +
       "E/l5jRfMSAHhuTZA8u8LuScTEpelnC/jB7yjyFT2+x+75SCKrYEIzmiJvJbH" +
       "EZzzPJGX+Rzk6kJ5Xz0rHgyO5uPxlD+yIrohPf2tH76e/+EfvZQ78PiS6mj4" +
       "DQT3+jbis+KhBIi/5yT4dIVAB3SVF+mfv2q++DKQuAASJQCuAeMDPyTHgnWP" +
       "+uz5v/3jP7n73d88De20oUumI8htIc976CJIOCXQAX4m7s++cxtv8QVQXM1N" +
       "hW4yfhun9+ZvZ4CCj98e8trZiugQNe79D8YUP/D3/36TE3Kwu8VC4AT/An7h" +
       "k/fh7/h+zn+IOhn3A8nNHwawejzkRT5r/evOI+f+dAc6v4CuSntL0zyAQC4v" +
       "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" +
       "SP/gnt972289/+38IO9/AGN9YfF1IQAA");
}
