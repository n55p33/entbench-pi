package org.apache.batik.anim.values;
public class AnimatableTransformListValue extends org.apache.batik.anim.values.AnimatableValue {
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SKEWX =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SKEWY =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SCALE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_ROTATE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_TRANSLATE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    static { IDENTITY_SKEWX.setSkewX(0.0F);
             IDENTITY_SKEWY.setSkewY(0.0F);
             IDENTITY_SCALE.setScale(0.0F, 0.0F);
             IDENTITY_ROTATE.setRotate(0.0F, 0.0F, 0.0F);
             IDENTITY_TRANSLATE.setTranslate(0.0F, 0.0F); }
    protected java.util.Vector transforms;
    protected AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        org.apache.batik.dom.svg.AbstractSVGTransform t) {
        super(
          target);
        this.
          transforms =
          new java.util.Vector(
            );
        this.
          transforms.
          add(
            t);
    }
    public AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        java.util.List transforms) {
        super(
          target);
        this.
          transforms =
          new java.util.Vector(
            transforms);
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableTransformListValue toTransformList =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            to;
        org.apache.batik.anim.values.AnimatableTransformListValue accTransformList =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            accumulation;
        int accSize =
          accumulation ==
          null
          ? 0
          : accTransformList.
              transforms.
          size(
            );
        int newSize =
          transforms.
          size(
            ) +
          accSize *
          multiplier;
        org.apache.batik.anim.values.AnimatableTransformListValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableTransformListValue)
                result;
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accTransformList.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        for (int i =
               0;
             i <
               transforms.
               size(
                 ) -
               1;
             i++,
               index++) {
            res.
              transforms.
              setElementAt(
                transforms.
                  elementAt(
                    i),
                index);
        }
        if (to !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                toTransformList.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform ft =
              null;
            int type;
            if (transforms.
                  isEmpty(
                    )) {
                type =
                  tt.
                    getType(
                      );
                switch (type) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                        ft =
                          IDENTITY_SKEWX;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        ft =
                          IDENTITY_SKEWY;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        ft =
                          IDENTITY_SCALE;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        ft =
                          IDENTITY_ROTATE;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        ft =
                          IDENTITY_TRANSLATE;
                        break;
                }
            }
            else {
                ft =
                  (org.apache.batik.dom.svg.AbstractSVGTransform)
                    transforms.
                    lastElement(
                      );
                type =
                  ft.
                    getType(
                      );
            }
            if (type ==
                  tt.
                  getType(
                    )) {
                org.apache.batik.dom.svg.AbstractSVGTransform t;
                if (res.
                      transforms.
                      isEmpty(
                        )) {
                    t =
                      new org.apache.batik.dom.svg.SVGOMTransform(
                        );
                    res.
                      transforms.
                      add(
                        t);
                }
                else {
                    t =
                      (org.apache.batik.dom.svg.AbstractSVGTransform)
                        res.
                          transforms.
                        elementAt(
                          index);
                    if (t ==
                          null) {
                        t =
                          new org.apache.batik.dom.svg.SVGOMTransform(
                            );
                        res.
                          transforms.
                          setElementAt(
                            t,
                            index);
                    }
                }
                float x;
                float y;
                float r =
                  0;
                switch (type) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        r =
                          ft.
                            getAngle(
                              );
                        r +=
                          interpolation *
                            (tt.
                               getAngle(
                                 ) -
                               r);
                        if (type ==
                              org.w3c.dom.svg.SVGTransform.
                                SVG_TRANSFORM_SKEWX) {
                            t.
                              setSkewX(
                                r);
                        }
                        else
                            if (type ==
                                  org.w3c.dom.svg.SVGTransform.
                                    SVG_TRANSFORM_SKEWY) {
                                t.
                                  setSkewY(
                                    r);
                            }
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        {
                            org.w3c.dom.svg.SVGMatrix fm =
                              ft.
                              getMatrix(
                                );
                            org.w3c.dom.svg.SVGMatrix tm =
                              tt.
                              getMatrix(
                                );
                            x =
                              fm.
                                getA(
                                  );
                            y =
                              fm.
                                getD(
                                  );
                            x +=
                              interpolation *
                                (tm.
                                   getA(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tm.
                                   getD(
                                     ) -
                                   y);
                            t.
                              setScale(
                                x,
                                y);
                            break;
                        }
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        {
                            x =
                              ft.
                                getX(
                                  );
                            y =
                              ft.
                                getY(
                                  );
                            x +=
                              interpolation *
                                (tt.
                                   getX(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tt.
                                   getY(
                                     ) -
                                   y);
                            r =
                              ft.
                                getAngle(
                                  );
                            r +=
                              interpolation *
                                (tt.
                                   getAngle(
                                     ) -
                                   r);
                            t.
                              setRotate(
                                r,
                                x,
                                y);
                            break;
                        }
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        {
                            org.w3c.dom.svg.SVGMatrix fm =
                              ft.
                              getMatrix(
                                );
                            org.w3c.dom.svg.SVGMatrix tm =
                              tt.
                              getMatrix(
                                );
                            x =
                              fm.
                                getE(
                                  );
                            y =
                              fm.
                                getF(
                                  );
                            x +=
                              interpolation *
                                (tm.
                                   getE(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tm.
                                   getF(
                                     ) -
                                   y);
                            t.
                              setTranslate(
                                x,
                                y);
                            break;
                        }
                }
            }
        }
        else {
            org.apache.batik.dom.svg.AbstractSVGTransform ft =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform t =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                res.
                  transforms.
                elementAt(
                  index);
            if (t ==
                  null) {
                t =
                  new org.apache.batik.dom.svg.SVGOMTransform(
                    );
                res.
                  transforms.
                  setElementAt(
                    t,
                    index);
            }
            t.
              assign(
                ft);
        }
        res.
          hasChanged =
          true;
        return res;
    }
    public static org.apache.batik.anim.values.AnimatableTransformListValue interpolate(org.apache.batik.anim.values.AnimatableTransformListValue res,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to2,
                                                                                        float interpolation1,
                                                                                        float interpolation2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue accumulation,
                                                                                        int multiplier) {
        int accSize =
          accumulation ==
          null
          ? 0
          : accumulation.
              transforms.
          size(
            );
        int newSize =
          accSize *
          multiplier +
          1;
        if (res ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                to1.
                  target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accumulation.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        org.apache.batik.dom.svg.AbstractSVGTransform ft1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value1.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value2.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            res.
              transforms.
            elementAt(
              index);
        if (t ==
              null) {
            t =
              new org.apache.batik.dom.svg.SVGOMTransform(
                );
            res.
              transforms.
              setElementAt(
                t,
                index);
        }
        int type =
          ft1.
          getType(
            );
        float x;
        float y;
        if (type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SCALE) {
            x =
              ft1.
                getMatrix(
                  ).
                getA(
                  );
            y =
              ft2.
                getMatrix(
                  ).
                getD(
                  );
        }
        else {
            x =
              ft1.
                getMatrix(
                  ).
                getE(
                  );
            y =
              ft2.
                getMatrix(
                  ).
                getF(
                  );
        }
        if (to1 !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt1 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to1.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt2 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to2.
                  transforms.
                lastElement(
                  );
            if (type ==
                  org.w3c.dom.svg.SVGTransform.
                    SVG_TRANSFORM_SCALE) {
                x +=
                  interpolation1 *
                    (tt1.
                       getMatrix(
                         ).
                       getA(
                         ) -
                       x);
                y +=
                  interpolation2 *
                    (tt2.
                       getMatrix(
                         ).
                       getD(
                         ) -
                       y);
            }
            else {
                x +=
                  interpolation1 *
                    (tt1.
                       getMatrix(
                         ).
                       getE(
                         ) -
                       x);
                y +=
                  interpolation2 *
                    (tt2.
                       getMatrix(
                         ).
                       getF(
                         ) -
                       y);
            }
        }
        if (type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SCALE) {
            t.
              setScale(
                x,
                y);
        }
        else {
            t.
              setTranslate(
                x,
                y);
        }
        res.
          hasChanged =
          true;
        return res;
    }
    public static org.apache.batik.anim.values.AnimatableTransformListValue interpolate(org.apache.batik.anim.values.AnimatableTransformListValue res,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value3,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to3,
                                                                                        float interpolation1,
                                                                                        float interpolation2,
                                                                                        float interpolation3,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue accumulation,
                                                                                        int multiplier) {
        int accSize =
          accumulation ==
          null
          ? 0
          : accumulation.
              transforms.
          size(
            );
        int newSize =
          accSize *
          multiplier +
          1;
        if (res ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                to1.
                  target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accumulation.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        org.apache.batik.dom.svg.AbstractSVGTransform ft1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value1.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value2.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft3 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value3.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            res.
              transforms.
            elementAt(
              index);
        if (t ==
              null) {
            t =
              new org.apache.batik.dom.svg.SVGOMTransform(
                );
            res.
              transforms.
              setElementAt(
                t,
                index);
        }
        float x;
        float y;
        float r;
        r =
          ft1.
            getAngle(
              );
        x =
          ft2.
            getX(
              );
        y =
          ft3.
            getY(
              );
        if (to1 !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt1 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to1.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt2 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to2.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt3 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to3.
                  transforms.
                lastElement(
                  );
            r +=
              interpolation1 *
                (tt1.
                   getAngle(
                     ) -
                   r);
            x +=
              interpolation2 *
                (tt2.
                   getX(
                     ) -
                   x);
            y +=
              interpolation3 *
                (tt3.
                   getY(
                     ) -
                   y);
        }
        t.
          setRotate(
            r,
            x,
            y);
        res.
          hasChanged =
          true;
        return res;
    }
    public java.util.Iterator getTransforms() {
        return transforms.
          iterator(
            );
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getE(
                        ) -
                      m2.
                      getE(
                        )) +
                  java.lang.Math.
                  abs(
                    m1.
                      getF(
                        ) -
                      m2.
                      getF(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getA(
                        ) -
                      m2.
                      getA(
                        )) +
                  java.lang.Math.
                  abs(
                    m1.
                      getD(
                        ) -
                      m2.
                      getD(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWX:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWY:
                return java.lang.Math.
                  abs(
                    t1.
                      getAngle(
                        ) -
                      t2.
                      getAngle(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo1(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getE(
                        ) -
                      m2.
                      getE(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getA(
                        ) -
                      m2.
                      getA(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWX:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWY:
                return java.lang.Math.
                  abs(
                    t1.
                      getAngle(
                        ) -
                      t2.
                      getAngle(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo2(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getF(
                        ) -
                      m2.
                      getF(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getD(
                        ) -
                      m2.
                      getD(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
                return java.lang.Math.
                  abs(
                    t1.
                      getX(
                        ) -
                      t2.
                      getX(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo3(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        if (type1 ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_ROTATE) {
            return java.lang.Math.
              abs(
                t1.
                  getY(
                    ) -
                  t2.
                  getY(
                    ));
        }
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableTransformListValue(
          target,
          new java.util.Vector(
            5));
    }
    public java.lang.String toStringRep() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        java.util.Iterator i =
          transforms.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.dom.svg.AbstractSVGTransform t =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                i.
                next(
                  );
            if (t ==
                  null) {
                sb.
                  append(
                    "null");
            }
            else {
                org.w3c.dom.svg.SVGMatrix m =
                  t.
                  getMatrix(
                    );
                switch (t.
                          getType(
                            )) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        sb.
                          append(
                            "translate(");
                        sb.
                          append(
                            m.
                              getE(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            m.
                              getF(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        sb.
                          append(
                            "scale(");
                        sb.
                          append(
                            m.
                              getA(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            m.
                              getD(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                        sb.
                          append(
                            "skewX(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        sb.
                          append(
                            "skewY(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        sb.
                          append(
                            "rotate(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            t.
                              getX(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            t.
                              getY(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                }
            }
            if (i.
                  hasNext(
                    )) {
                sb.
                  append(
                    ' ');
            }
        }
        return sb.
          toString(
            );
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
       "38b6/GvbSby/2DQ9vIW2cBp5wc++hh20");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9FaHosXnYunUzaVjW8jHDu1K+a7gY2ddLit2BD/z4RdeNLifRw5OJv9RXLoU" +
       "+8EPOubadI6RuhtQeubs3U+muFt3dAj3pQ//90ek980/9Bpu4jxxis/TJP8h" +
       "89KXe+/Q/85e6bbDI7mbbv2dbPTsyYO4y6EZJ6EnnTiOe+xQst9/IE13X7Lu" +
       "6c35o7G79QnAc7uxP3Uee0dR4Y6DzfJ3vcobVMWJZN7mS0XLXzimLZ/NN+gd" +
       "X4vPLL7N9nZXOn7rnMPhf5UnvxmX7i4uVQJJavGxDgv1/Gev+eT/Nw7lCeWZ" +
       "7wai2du13X2/SnnuHVnVLYV6aXcqXVA4K/nyYVL8/EpB6GvnCOQ/5Mm/uVkg" +
       "x+z1994IgXxgXyAfeAMFck9R655zBXIr0ZyWz389Rz7fzJP/dK58/uB1yCc/" +
       "GCs9BeTy0r58XnpjDPA4hP91Ttn/zpNvxaV7LTOWzjrCK+6zPHgekweG/sDR" +
       "ER4Vm8WNtbzkO0fC+p+vQ1gP5pmPgP6/sM/HF95wYV3YO6fs9jzzz+LSnbrm" +
       "DQ/uY5/yQndOfd8xNe8I8Z+/DsTF7Aec9IUv7iP+4huD+MJRhS8V0O4/B/aD" +
       "eXJPXLps2Ls5RipuGH/5EOKFe18vxEcBM1/bh/i17xHEx86B+ESePAys/Agi" +
       "cgrj970RGL+zj/E73yOMT5+DsZwn105gRE9hfPsbgHHvTbu2u+/vAcbaORjz" +
       "ePMCfAJj5RRG5HVgLMKldwJsT+9jfPqNwXgcAnZOWTtP3hOX7gHeemKG/ql4" +
       "qcD33teB74E88zGAa/9y0t5Nl5NePz7mnDIuT0gwfLG/u1QhmEW/P3sEj3pN" +
       "t/ni0qPn3c/Pbxo/fNPfhXZ/cdF/+cUrd73lxdG/La6oH/4N5RJdumuWOM7x" +
       "y27H3i8GoTmzCyFc2l19CwpkMuDkvCA4Ll3cveQYLox2jdS49NAtG8Wl2/Ov" +
       "43U/EJeunq4LQubi+3i9G8CPH9UD3e5ejleZglgaVMlf9WBnd7vb1Q8f15pi" +
       "bnvglUbj2KLsbSeWUsV/uQ6WPclw/3bq517ssz/87frP767X646WZTmVu+jS" +
       "nbub/gXRfOn01JnUDmhdJJ/+7n2fv/T2g2XefTuGjzT4GG9P3PoiO+EGcXH1" +
       "PPunb/nCe37xxd8vrtr8f21V1YxkNwAA");
}
