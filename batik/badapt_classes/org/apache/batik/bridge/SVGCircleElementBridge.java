package org.apache.batik.bridge;
public class SVGCircleElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGCircleElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_CIRCLE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGCircleElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMCircleElement ce =
              (org.apache.batik.dom.svg.SVGOMCircleElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getCx(
                  );
            float cx =
              _cx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cy =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getCy(
                  );
            float cy =
              _cy.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _r =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getR(
                  );
            float r =
              _r.
              getCheckedValue(
                );
            float x =
              cx -
              r;
            float y =
              cy -
              r;
            float w =
              r *
              2;
            shapeNode.
              setShape(
                new java.awt.geom.Ellipse2D.Float(
                  x,
                  y,
                  w,
                  w));
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_CX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_CY_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_R_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        java.awt.geom.Rectangle2D r2d =
          shapeNode.
          getShape(
            ).
          getBounds2D(
            );
        if (r2d.
              getWidth(
                ) ==
              0 ||
              r2d.
              getHeight(
                ) ==
              0)
            return null;
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UdU6h+rLLuzvz7i4y/yTNW//B0IbaN67GQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeezkVn337mZ3k82xmw0kaSD3BpoM/Ow5PdNQYMZje07b" +
       "M+NjPC0sPsfX2B6fM0NTAlJLWqpAS6CpBOkfBdGicPRArURp01ZcAlWiQr2k" +
       "AqoqlZYikT9Kq9KWPnt+9x4oCupIfva8933f976f7/G+fs/Pfxc6HQZQwfec" +
       "9dzxoh1tFe1YTnUnWvtauNMbVBkpCDUVc6QwZEHdZeWhT5///g/eZ1w4CZ2Z" +
       "QXdIrutFUmR6bjjWQs9JNHUAnT+oxR1tEUbQhYElJRIcR6YDD8wwenwA3Xyo" +
       "awRdGuxNAQZTgMEU4HwKcPOACnS6VXPjBZb1kNwoXEI/D50YQGd8JZteBD14" +
       "lIkvBdJilw2TSwA43Jj954FQeedVAD2wL/tW5isE/kABfubX33rh905B52fQ" +
       "edOdZNNRwCQiMMgMumWhLWQtCJuqqqkz6HZX09SJFpiSY27yec+gi6E5d6Uo" +
       "DrR9kLLK2NeCfMwD5G5RMtmCWIm8YF883dQcde/fad2R5kDWOw9k3UpIZPVA" +
       "wHMmmFigS4q21+UG23TVCLr/eI99GS/1AQHoenahRYa3P9QNrgQqoItb3TmS" +
       "O4cnUWC6c0B62ovBKBF0zzWZZlj7kmJLc+1yBN19nI7ZNgGqm3Igsi4R9Mrj" +
       "ZDknoKV7jmnpkH6+S73h6be7HfdkPmdVU5xs/jeCTvcd6zTWdC3QXEXbdrzl" +
       "scEHpTs/99RJCALErzxGvKX5w5978c2vu++FL21pXnUVGlq2NCW6rHxEvu1r" +
       "r8YebZzKpnGj74Vmpvwjkufmz+y2PL7ygefduc8xa9zZa3xh/AXxyY9r3zkJ" +
       "netCZxTPiRfAjm5XvIVvOlpAaq4WSJGmdqGbNFfF8vYudBY8D0xX29bSuh5q" +
       "URe6wcmrznj5fwCRDlhkEJ0Fz6are3vPvhQZ+fPKhyDoLLigW8D1Wmj7y+8R" +
       "JMGGt9BgSZFc0/VgJvAy+UNYcyMZYGvAMrB6Gw69OAAmCHvBHJaAHRjaboMc" +
       "mOpcgyc8iZmB4mhZhAB9W3n1TmZq/v/HIKtM0gvpiRNACa8+HgIc4D0dz1G1" +
       "4LLyTNzCX/zk5a+c3HeJXYwiaAeMu7Mddycfd2c77s7Vx4VOnMiHe0U2/lbf" +
       "QFs28HsQEW95dPKW3tueeugUMDQ/vQFAnZHC1w7M2EGk6ObxUAHmCr3wbPpO" +
       "/h3ISejk0QibzRlUncu6M1lc3I9/l4571tX4nn/3t7//qQ8+4R342JGQvev6" +
       "V/bMXPeh4+gGnqKpIBgesH/sAekzlz/3xKWT0A0gHoAYGEnAZkF4ue/4GEdc" +
       "+PG9cJjJchoIrHvBQnKypr0Ydi4yAi89qMnVflv+fDvA+ObMph8E1+t2jTy/" +
       "Z613+Fn5iq2ZZEo7JkUebn964n/4b//yX8o53HuR+fyhtW6iRY8figYZs/O5" +
       "399+YANsoGmA7h+eZd7/ge+++2dyAwAUD19twEtZiYEoAFQIYP6FLy3/7pvf" +
       "+MjXTx4YTQSWw1h2TGW1L2RWD527jpBgtNcczAdEEwc4W2Y1lzh34ammbkqy" +
       "o2VW+t/nHyl+5t+evrC1AwfU7JnR6340g4P6n2hBT37lrf9xX87mhJKtZgeY" +
       "HZBtQ+QdB5ybQSCts3ms3vlX9/7GF6UPg2ALAlxobrQ8ZkE5BlCuNDiX/7G8" +
       "3DnWVsyK+8PDxn/Uvw5lHZeV9339e7fy3/uTF/PZHk1bDut6KPmPb80rKx5Y" +
       "AfZ3Hff0jhQagK7yAvWzF5wXfgA4zgBHBcSwkA5AuFkdsYxd6tNn//7P/uLO" +
       "t33tFHSSgM45nqQSUu5k0E3AurXQAJFq5b/pzVvlpjeC4kIuKnSF8FujuDv/" +
       "dwpM8NFrxxciyzoOXPTu/6Id+V3/+J9XgJBHlqsstsf6z+DnP3QP9sbv5P0P" +
       "XDzrfd/qyhAMMrSDvqWPL/795ENnPn8SOjuDLii76R8vOXHmODOQ8oR7OSFI" +
       "EY+0H01ftmv14/sh7NXHw8uhYY8Hl4PQD54z6uz53OF48kPwOwGu/82uDO6s" +
       "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" +
       "Gf8HXgKxukAlAAA=");
}
