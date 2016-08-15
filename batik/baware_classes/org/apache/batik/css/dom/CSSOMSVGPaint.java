package org.apache.batik.css.dom;
public class CSSOMSVGPaint extends org.apache.batik.css.dom.CSSOMSVGColor implements org.w3c.dom.svg.SVGPaint {
    public CSSOMSVGPaint(org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider vp) {
        super(
          vp);
    }
    public void setModificationHandler(org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler h) {
        if (!(h instanceof org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        super.
          setModificationHandler(
            h);
    }
    public short getColorType() { throw new org.w3c.dom.DOMException(
                                    org.w3c.dom.DOMException.
                                      INVALID_ACCESS_ERR,
                                    ""); }
    public short getPaintType() { org.apache.batik.css.engine.value.Value value =
                                    valueProvider.
                                    getValue(
                                      );
                                  switch (value.
                                            getCssValueType(
                                              )) {
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_PRIMITIVE_VALUE:
                                          switch (value.
                                                    getPrimitiveType(
                                                      )) {
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_IDENT:
                                                  {
                                                      java.lang.String str =
                                                        value.
                                                        getStringValue(
                                                          );
                                                      if (str.
                                                            equalsIgnoreCase(
                                                              org.apache.batik.util.CSSConstants.
                                                                CSS_NONE_VALUE)) {
                                                          return SVG_PAINTTYPE_NONE;
                                                      }
                                                      else
                                                          if (str.
                                                                equalsIgnoreCase(
                                                                  org.apache.batik.util.CSSConstants.
                                                                    CSS_CURRENTCOLOR_VALUE)) {
                                                              return SVG_PAINTTYPE_CURRENTCOLOR;
                                                          }
                                                      return SVG_PAINTTYPE_RGBCOLOR;
                                                  }
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_RGBCOLOR:
                                                  return SVG_PAINTTYPE_RGBCOLOR;
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_URI:
                                                  return SVG_PAINTTYPE_URI;
                                          }
                                          break;
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_VALUE_LIST:
                                          org.apache.batik.css.engine.value.Value v0 =
                                            value.
                                            item(
                                              0);
                                          org.apache.batik.css.engine.value.Value v1 =
                                            value.
                                            item(
                                              1);
                                          switch (v0.
                                                    getPrimitiveType(
                                                      )) {
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_IDENT:
                                                  return SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR;
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_URI:
                                                  if (v1.
                                                        getCssValueType(
                                                          ) ==
                                                        org.w3c.dom.css.CSSValue.
                                                          CSS_VALUE_LIST)
                                                      return SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR;
                                                  switch (v1.
                                                            getPrimitiveType(
                                                              )) {
                                                      case org.w3c.dom.css.CSSPrimitiveValue.
                                                             CSS_IDENT:
                                                          {
                                                              java.lang.String str =
                                                                v1.
                                                                getStringValue(
                                                                  );
                                                              if (str.
                                                                    equalsIgnoreCase(
                                                                      org.apache.batik.util.CSSConstants.
                                                                        CSS_NONE_VALUE)) {
                                                                  return SVG_PAINTTYPE_URI_NONE;
                                                              }
                                                              else
                                                                  if (str.
                                                                        equalsIgnoreCase(
                                                                          org.apache.batik.util.CSSConstants.
                                                                            CSS_CURRENTCOLOR_VALUE)) {
                                                                      return SVG_PAINTTYPE_URI_CURRENTCOLOR;
                                                                  }
                                                              return SVG_PAINTTYPE_URI_RGBCOLOR;
                                                          }
                                                      case org.w3c.dom.css.CSSPrimitiveValue.
                                                             CSS_RGBCOLOR:
                                                          return SVG_PAINTTYPE_URI_RGBCOLOR;
                                                  }
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_RGBCOLOR:
                                                  return SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR;
                                          }
                                  }
                                  return SVG_PAINTTYPE_UNKNOWN;
    }
    public java.lang.String getUri() { switch (getPaintType(
                                                 )) {
                                           case SVG_PAINTTYPE_URI:
                                               return valueProvider.
                                                 getValue(
                                                   ).
                                                 getStringValue(
                                                   );
                                           case SVG_PAINTTYPE_URI_NONE:
                                           case SVG_PAINTTYPE_URI_CURRENTCOLOR:
                                           case SVG_PAINTTYPE_URI_RGBCOLOR:
                                           case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                                               return valueProvider.
                                                 getValue(
                                                   ).
                                                 item(
                                                   0).
                                                 getStringValue(
                                                   );
                                       }
                                       throw new java.lang.InternalError(
                                         );
    }
    public void setUri(java.lang.String uri) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            ((org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)
               handler).
              uriChanged(
                uri);
        }
    }
    public void setPaint(short paintType,
                         java.lang.String uri,
                         java.lang.String rgbColor,
                         java.lang.String iccColor) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            ((org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)
               handler).
              paintChanged(
                paintType,
                uri,
                rgbColor,
                iccColor);
        }
    }
    public static interface PaintModificationHandler extends org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler {
        void uriChanged(java.lang.String uri);
        void paintChanged(short type, java.lang.String uri,
                          java.lang.String rgb,
                          java.lang.String icc);
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "gBsfAAA=");
    }
    public abstract class AbstractModificationHandler implements org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler {
        protected abstract org.apache.batik.css.engine.value.Value getValue();
        public void redTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void redFloatValueChanged(short unit,
                                         float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void greenTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void greenFloatValueChanged(short unit,
                                           float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void blueTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ")";
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void blueFloatValueChanged(short unit,
                                          float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void rgbColorChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text +=
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
                      text;
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
                      text +
                      ' ' +
                      getValue(
                        ).
                        item(
                          2).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void rgbColorICCColorChanged(java.lang.String rgb,
                                            java.lang.String icc)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
                      rgb +
                      ' ' +
                      icc);
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorChanged(short type,
                                 java.lang.String rgb,
                                 java.lang.String icc)
              throws org.w3c.dom.DOMException {
            switch (type) {
                case SVG_PAINTTYPE_CURRENTCOLOR:
                    textChanged(
                      "currentcolor");
                    break;
                case SVG_PAINTTYPE_RGBCOLOR:
                    textChanged(
                      rgb);
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NOT_SUPPORTED_ERR,
                      "");
            }
        }
        public void colorProfileChanged(java.lang.String cp)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    sb.
                      append(
                        cp);
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    for (int i =
                           0;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    sb.
                      append(
                        cp);
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    for (int i =
                           0;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorsCleared() throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorsInitialized(float f)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorInsertedBefore(float f,
                                        int idx)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    for (int i =
                           idx;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    for (int i =
                           idx;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorReplaced(float f,
                                  int idx)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    for (int i =
                           idx +
                           1;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    for (int i =
                           idx +
                           1;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorRemoved(int idx)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    for (int i =
                           idx +
                           1;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    for (int i =
                           idx +
                           1;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorAppend(float f) throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void uriChanged(java.lang.String uri) {
            textChanged(
              "url(" +
              uri +
              ") none");
        }
        public void paintChanged(short type,
                                 java.lang.String uri,
                                 java.lang.String rgb,
                                 java.lang.String icc) {
            switch (type) {
                case SVG_PAINTTYPE_NONE:
                    textChanged(
                      "none");
                    break;
                case SVG_PAINTTYPE_CURRENTCOLOR:
                    textChanged(
                      "currentcolor");
                    break;
                case SVG_PAINTTYPE_RGBCOLOR:
                    textChanged(
                      rgb);
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                case SVG_PAINTTYPE_URI:
                    textChanged(
                      "url(" +
                      uri +
                      ')');
                    break;
                case SVG_PAINTTYPE_URI_NONE:
                    textChanged(
                      "url(" +
                      uri +
                      ") none");
                    break;
                case SVG_PAINTTYPE_URI_CURRENTCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") currentcolor");
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") " +
                      rgb);
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") " +
                      rgb +
                      ' ' +
                      icc);
            }
        }
        public AbstractModificationHandler() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVaDWwcxRWeO//EduKfOHESQuz8mRSH9I4Q0oKcAvbFJqbn" +
           "2IoTSziAs7c3d954b3fZnbPPhvDXH9yWRgjMT2lJVSn8tAKCKlCL+FFSpACC" +
           "UgFpKaX8qK3U0DYioSqVCi19b3b3dm/v9o6reifdu73Z9968982b92Z29pFT" +
           "pMbQSQdVWIjNaNQI9SlsWNANGo/IgmHshrZx8Z4q4e/XnNx5cZDUjpGmCcEY" +
           "FAWD9ktUjhtjpF1SDCYoIjV2UhpHiWGdGlSfEpikKmOkTTIGUposiRIbVOMU" +
           "GUYFPUoWC4zpUizN6IClgJH2KFgS5paEe7y3u6NkkahqMw77Chd7xHUHOVNO" +
           "XwYjLdH9wpQQTjNJDkclg3VndHKepsozSVllIZphof3yVguCK6Jb8yBY93jz" +
           "x5/cPtHCIVgiKIrKuHvGLmqo8hSNR0mz09on05RxLbmBVEXJQhczI51Ru9Mw" +
           "dBqGTm1vHS6wvpEq6VRE5e4wW1OtJqJBjKzNVaIJupCy1Axzm0FDHbN858Lg" +
           "7Zqst6aXeS7edV54/p5rWn5aRZrHSLOkjKA5IhjBoJMxAJSmYlQ3euJxGh8j" +
           "ixUY7BGqS4IszVoj3WpISUVgaRh+GxZsTGtU5306WME4gm96WmSqnnUvwQPK" +
           "+leTkIUk+LrM8dX0sB/bwcEGCQzTEwLEnSVSPSkpcUZWeyWyPnZ+FRhAdEGK" +
           "sgk121W1IkADaTVDRBaUZHgEQk9JAmuNCgGoM7LSVylirQnipJCk4xiRHr5h" +
           "8xZw1XMgUISRNi8b1wSjtNIzSq7xObVz28HrlB1KkATA5jgVZbR/IQh1eIR2" +
           "0QTVKcwDU3DRxujdwrJn54KEAHObh9nk+dn1Zy7b1HH0RZPn7AI8Q7H9VGTj" +
           "4uFY02urIl0XV6EZdZpqSDj4OZ7zWTZs3enOaJBhlmU14s2QffPoruNX3vQT" +
           "+tcgaRggtaIqp1MQR4tFNaVJMtUvpwrVBUbjA6SeKvEIvz9AFsB1VFKo2TqU" +
           "SBiUDZBqmTfVqvw/QJQAFQhRA1xLSkK1rzWBTfDrjEYIWQpfch58nyHm52kk" +
           "jFwZnlBTNCyIgiIpanhYV9F/IwwZJwbYToRjEPWTYUNN6xCCYVVPhgWIgwlq" +
           "3RANIxxXU+HIyMjQ4Mjo5cMCBGwIQ0yrpPIMerZkOhAA0Fd5p7wMs2WHKsep" +
           "Pi7Op3v7zjw2/rIZTjgFLEwY6YX+QmZ/Id5fCPoLQX+hnP46e2IwhwUR07qU" +
           "kESeBXYIShxGjgQC3ISlaJM55jBikzD3Ifku6hq5+op9c+uqINi06WqAG1nX" +
           "5RShiJMg7Kw+Lh5pbZxd++7m54OkOkpaoee0IGNN6dGTkK3ESWtCL4pBeXKq" +
           "xBpXlcDypqsijUOS8qsWlpY6dYrq2M7IUpcGu4bhbA37V5CC9pOj907fPHrj" +
           "+UESzC0M2GUN5DQUH8Z0nk3bnd6EUEhv860nPz5y9wHVSQ05lcYukHmS6MM6" +
           "b5B44RkXN64Rnhx/9kAnh70eUjeD4ces2OHtIyfzdNtZHH2pA4cTqp4SZLxl" +
           "Y9zAJnR12mnh0bsYSZsZyBhCHgN5AfjKiHb/b1/9YAtH0q4Vza4iP0JZtys/" +
           "obJWnokWOxG5W6cU+N65d/jOu07dupeHI3CsL9RhJ9II5CUYHUDwGy9e+9Z7" +
           "7x4+EXRCmEGBTsdgnZPhviz9DD4B+P4Hv5hTsMHMLa0RK8GtyWY4DXve4NgG" +
           "uU6GlIDB0blHSfEZJsRkivPn0+ZzNj/5t4Mt5nDL0GJHy6bSCpz2s3rJTS9f" +
           "888OriYgYq118HPYzAS+xNHco+vCDNqRufn19u+9INwPpQDSryHNUp5RCceD" +
           "8AHcyrE4n9MLPfe+jOQcwx3judPItSYaF28/cbpx9PRzZ7i1uYsq97gPClq3" +
           "GUXmKEBnm4hF7AzPf/HuMg3p8gzYsNybqHYIxgQou/Dozqta5KOfQLdj0K0I" +
           "6dgY0iGDZnJCyeKuWfC7Y88v2/daFQn2kwZZFeL9Ap9wpB4inRoTkHwz2qWX" +
           "mXZM1wFp4XiQPITyGnAUVhce376UxviIzP58+RPbHjr0Lg9LzdRxtlvhBk67" +
           "kGzi7UG8/CIjdYKVzDNZ3LjYErsi2r8u3FzqA/x6BSOXfs7awWmBwoFj0e63" +
           "COILuMO3zB+KDz2w2VyqtOYuLPpg3fzob/79Suje918qUNlqrUWsYzhmmPac" +
           "yjPIF4dO9nun6Y4/PtWZ7C2n6GBbR4mygv9Xgwcb/YuI15QXbvnLyt2XTOwr" +
           "o36s9mDpVfnjwUdeunyDeEeQr4TN0pG3gs4V6najCp3qFJb8CrqJLY189q3P" +
           "RtFaDJou+B6zouiYd/aZib5wdDJSr+kqg0CncWzud8ITJw9ZWURxkdSzt8i9" +
           "q5HshhmRpGxUkNPUDu0vFAxtqiShGIamkDPk8F+EZI9p7bb/ccJjQ6/G24ez" +
           "bjfjvTB8j1tuHy8DzwCf7R4Mm4oo8+AUyJ3sLTwd4Y4pZO6YeN+TxYVWIIzT" +
           "W0SeFLYPDfZlRKphFHNhvkqHJVeTTuO7YUJEJkA7jcMs7SqyXdelFJT5KWvD" +
           "Ez7Q+t7kD04+amYI7+7Iw0zn5r/9WejgvJktzC3k+rxdnFvG3EZya1uQhDBn" +
           "rS3WC5fo//ORA08/fODWoBVnUUaqp1Qp7oRLolLh0gPfj6wR/qhIuCCZyA8O" +
           "P1HPOAfNKZu7lMdMOZKG2uKB/YLhfeJc5/CfzDE6q4CAydf2cPi7o2/uf4Wn" +
           "vDrMsdlE48qvkItdC0h7VPDHcF1PM1IDJVhneaEJq8xcC8zOt3+r+ZnbW6v6" +
           "IfUPkLq0Il2bpgPx3PS3wEjHXCY5u3wnGVr24PqPkcBGuzB/vYiZCVg75JmJ" +
           "f2/LcJVfKzzH8K/GGeaR3ABbF5hH/aiMpyZrNuG9KSfubqxU3G0Gk9aYOs3f" +
           "suLOV9Tfd5lr/WEpcH6E5D7IX0nYASiuNOMB5vuVAiZCMNuY3kXLB8ZPtPCE" +
           "xL/fRHKQq36kFDqPIXkItgMcnVLB83ClMDofjJq1HJ0tHyM/0VLB81QpeJ5G" +
           "8gTsOmKAiX/sPFkpXHrBmgct5x4sHxc/0c8VO8dLgfMikmOMtCE4pULnF5UM" +
           "nROWnyfKh8hPtFTovFEKnV8jeRVCR0/GYP+m6oVx+VUl085py7nT5ePiJ+of" +
           "OrIDzvulwPkDkrcZWW6DMxCJFAHp95UCaTvYXmPqNH/LAslX1ON+FTekKju/" +
           "XEidKoXUh0hOMjxF8YXng0rBcwH4tsrycVX58PiJlppb/yoFyqdI/sHIEg7K" +
           "sK7i4//C2HxcKWzWg2PbLQe3l4+Nn6jHdddmNbCgBCyBeiSwjW7ksBgRmQq6" +
           "F5BAVaUACYE3ccurePmA+In6O83LVGBpKVSWIWlmeNKEqAwosDPBg8w8ZFoq" +
           "hczF4Nac5d5c+cj4ifqn4oO8scieo0pSiuw4AmtLYXouklX2BBxQDKozGu+l" +
           "CVWnHlTbK4XqFnDWesobzHvKWxpVP9EiqKI767j/W0oBtBVJyJ6Ku6iGx3He" +
           "gAtXCpousNgq4MHya7+vqK/TFiqXlUKlF0m3Xcx20ZQ6lQfKtkqBci6U4DWm" +
           "TvO3LFB8RUvlp8FSoAwh2cHIQg5Kj6ZRxYvJQKUw2UjwUbDpWPl7U1/REgU+" +
           "MFakyl2FZA8jDWldKljSA6OVQuMicGW35dJI+WiM+Ih6nK3mhlTjX9dq0AEn" +
           "WQQcCUkMJpCGRyqF4RH/H/BkGDm7yJE/F1vByIbPdwJk6GRF3itJ5ms04mOH" +
           "muuWH9rzJj9yyb7qsihK6hJpWXY9fHM/iKvVdJqQ+JgsMk8AzblkWI+cC5kE" +
           "VQ8oWh7QTe4pRpYW4gZOoG7OGUZavJyM1PBfN9/1ELcOHyO15oWb5UbQDix4" +
           "eZNm4+h6uG6+e5MxH6HnnOfx9WxbqdHNirgPt/EpOn91zH7smTZfHhsXjxy6" +
           "Yud1Z770gHm4LsrC7CxqWRglC8wjfK4UT5fW+mqzddXu6Pqk6fH6c+yn3jmH" +
           "+27beIxBRuAH4Ss9p81GZ/bQ+a3D25775Vzt60ES2EsCAqw39rpe3DKR6s5o" +
           "aZ20743mP9QdFXR+DN7ddd/MJZsSH77Nj0qJ+RB4lT//uHjioavfuGPF4Y4g" +
           "WThAaiQlTjNjpEEyts8ou6g4pY+RRsnoy4CJoAVWkzlPjJswiAU8IuG4WHA2" +
           "ZlvxrQtG1uWfO+S/q9Igq9NU71XTZklojJKFTos5Mp4DujTUj1wBp8UaSqTf" +
           "QRLK4GhAPI5HBzXNfmWh9jmNJ4HbCi8QMXDv5Jd4Nf9femylB1YqAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Lxz5+VTx83Ompw1fulu84Kl1/3Cx2r9H");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("i9UxkkOo18+Dmm/D7NWPAvVUcbz1LUixu0X6w2AZeXbXdvf7Fszo3nlIqZy0" +
           "YuhtBVLc9xX3NFDiboG+AOX7HDug9+hR4vSKtMfeIYJzORnF0OUkNM5cg/bG" +
           "dwuxAaDNDiGy9wbixYLhYn57ItE4RvziHRCLORGA//r5VtrZmH/izWBOY+hd" +
           "dzgHXvA/HkMf+Nvt8EUh9OQt/1PZ/bdC+o1Xrzzwzle5/1wcnL7x/4cHB9AD" +
           "amLbJ08pnri+zw8V1SjU+ODuzKJf6ME83G85SyQQ8AHNJd8zdtyg6LGzuAEn" +
           "oCc5ffAAfpozhi4Vvyf5QNPLx3wxdN/u4iTLGvQOWPLLjX+kxxOnEneHOtPd" +
           "/tGTJ12wyJ4eOc+KN5qcPH+db3oW/yc62qBMdv8oelH60qv06Ke/V/+V3flv" +
           "yRazLO/lgQF0/+4oetFpvsn53G17O+rrPvL5Hzz05Qfff7Qb+9BO4OPpcEK2" +
           "95x9wLrj+HFxJDr71+/8zR/5Z6/+cXEs8/8DGzANteg1AAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rVs+XxfhfTQfIx8Vsz8Ur9h89B+4AjSH/RoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
