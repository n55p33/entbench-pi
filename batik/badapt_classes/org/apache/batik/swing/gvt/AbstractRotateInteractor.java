package org.apache.batik.swing.gvt;
public class AbstractRotateInteractor extends org.apache.batik.swing.gvt.InteractorAdapter {
    protected boolean finished;
    protected double initialRotation;
    public boolean endInteraction() { return finished; }
    public void mousePressed(java.awt.event.MouseEvent e) { finished = false;
                                                            org.apache.batik.swing.gvt.JGVTComponent c =
                                                              (org.apache.batik.swing.gvt.JGVTComponent)
                                                                e.
                                                                getSource(
                                                                  );
                                                            java.awt.Dimension d =
                                                              c.
                                                              getSize(
                                                                );
                                                            double dx =
                                                              e.
                                                              getX(
                                                                ) -
                                                              d.
                                                                width /
                                                              2;
                                                            double dy =
                                                              e.
                                                              getY(
                                                                ) -
                                                              d.
                                                                height /
                                                              2;
                                                            double cos =
                                                              -dy /
                                                              java.lang.Math.
                                                              sqrt(
                                                                dx *
                                                                  dx +
                                                                  dy *
                                                                  dy);
                                                            initialRotation =
                                                              dx >
                                                                0
                                                                ? java.lang.Math.
                                                                acos(
                                                                  cos)
                                                                : -java.lang.Math.
                                                                acos(
                                                                  cos);
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        java.awt.geom.AffineTransform at =
          rotateTransform(
            c.
              getSize(
                ),
            e.
              getX(
                ),
            e.
              getY(
                ));
        at.
          concatenate(
            c.
              getRenderingTransform(
                ));
        c.
          setRenderingTransform(
            at);
    }
    public void mouseExited(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        c.
          setPaintingTransform(
            null);
    }
    public void mouseDragged(java.awt.event.MouseEvent e) {
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        c.
          setPaintingTransform(
            rotateTransform(
              c.
                getSize(
                  ),
              e.
                getX(
                  ),
              e.
                getY(
                  )));
    }
    protected java.awt.geom.AffineTransform rotateTransform(java.awt.Dimension d,
                                                            int x,
                                                            int y) {
        double dx =
          x -
          d.
            width /
          2;
        double dy =
          y -
          d.
            height /
          2;
        double cos =
          -dy /
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        double angle =
          dx >
          0
          ? java.lang.Math.
          acos(
            cos)
          : -java.lang.Math.
          acos(
            cos);
        angle -=
          initialRotation;
        return java.awt.geom.AffineTransform.
          getRotateInstance(
            angle,
            d.
              width /
              2,
            d.
              height /
              2);
    }
    public AbstractRotateInteractor() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze2wcxRkfn+NH/I7zJCRO4jhBTpw7wqMUnNI4jo0dzolr" +
       "m6g4TZy5vbm7TfZ2l905+2ya8pBQ0qpEaRqegqh/hIamQFALKn2AghAlCIoE" +
       "pA0UEfqgKi1FJapKaWlLv2929/ZxD9dS05N2bm/m+2a+1/y+b+Ye+YBUmAZp" +
       "YSoP80mdmeEelQ9Sw2TxboWa5gj0jUn3lNO/7Hpv69UhUjlKGlLUHJCoyXpl" +
       "psTNUbJUVk1OVYmZWxmLI8egwUxmjFMua+oomS+b/WldkSWZD2hxhgTbqREl" +
       "cyjnhhzLcNZvT8DJ0ihIEhGSRLqCw51RUidp+qRLvshD3u0ZQcq0u5bJSVN0" +
       "Dx2nkQyXlUhUNnln1iBrdU2ZTCoaD7MsD+9RrrRNsCV6ZZ4JWh9v/OiTQ6km" +
       "YYK5VFU1LtQzh5ipKeMsHiWNbm+PwtLmTeQrpDxKaj3EnLRFnUUjsGgEFnW0" +
       "dalA+nqmZtLdmlCHOzNV6hIKxMkK/yQ6NWjanmZQyAwzVHNbd8EM2i7PaWtp" +
       "mafiXWsjR+7Z1fS9ctI4ShpldRjFkUAIDouMgkFZOsYMsyseZ/FRMkcFZw8z" +
       "Q6aKPGV7utmUkyrlGXC/YxbszOjMEGu6tgI/gm5GRuKakVMvIQLK/lWRUGgS" +
       "dF3g6mpp2Iv9oGCNDIIZCQpxZ7PM2iurcU6WBTlyOrZdDwTAWpVmPKXllpql" +
       "UuggzVaIKFRNRoYh9NQkkFZoEIAGJ4uLToq21qm0lybZGEZkgG7QGgKq2cIQ" +
       "yMLJ/CCZmAm8tDjgJY9/Pti64eDNap8aImUgc5xJCspfC0wtAaYhlmAGg31g" +
       "Mdatid5NFzx9IEQIEM8PEFs0P/jy+Y0dLadOWzQXF6DZFtvDJD4mHYs1vLqk" +
       "u/3qchSjWtdMGZ3v01zsskF7pDOrA8IsyM2Ig2Fn8NTQT2+89QR7P0Rq+kml" +
       "pCmZNMTRHElL67LCjOuYygzKWbyfzGZqvFuM95MqeI/KKrN6tyUSJuP9ZJYi" +
       "uio18RtMlIAp0EQ18C6rCc151ylPifesTgipgofUwdNKrI/45iQRSWlpFqES" +
       "VWVViwwaGupvRgBxYmDbVCQGUb83YmoZA0IwohnJCIU4SDFnYAIiKJIc55Gu" +
       "GIQ6lfgQbnBAMwgoioEfxnjT/28rZVHnuRNlZeCOJUEwUGAf9WlKnBlj0pHM" +
       "pp7zj429ZAUabg7bWpxcDouHrcXDYvGwWDwMi4eLLU7KysSa81AIy/3gvL0A" +
       "A4DDde3DO7fsPtBaDnGnT8wCyyNpqy8fdbtY4QD8mHSyuX5qxbn1z4XIrChp" +
       "hoUyVMH00mUkAbikvfberotBpnITxnJPwsBMZ2gSiwNeFUsc9izV2jgzsJ+T" +
       "eZ4ZnHSGGzdSPJkUlJ+cunfitu23XBoiIX+OwCUrAN6QfRCRPYfgbUFsKDRv" +
       "4/73Pjp59z7NRQlf0nFyZR4n6tAajIqgecakNcvpk2NP72sTZp8NKM4p7DoA" +
       "yJbgGj4Q6nQAHXWpBoUTmpGmCg45Nq7hKUObcHtEuM7BZr4VuRhCAQFFLvjc" +
       "sP7gG6/84XJhSSdtNHry/TDjnR6owsmaBSjNcSNyxGAM6N6+d/Cbd32wf4cI" +
       "R6BYWWjBNmy7AaLAO2DBO07f9OY7546dCbkhzCFXZ2JQ8mSFLvM+hU8ZPP/G" +
       "B+EFOyyYae62sW55Dux0XHm1KxvAngKAgMHRdoMKYSgnZBpTGO6ffzauWv/k" +
       "nw42We5WoMeJlo7pJ3D7L9pEbn1p199axDRlEqZd134umYXlc92ZuwyDTqIc" +
       "2dteW3rfC/RByAqAxKY8xQS4EmEPIhx4pbDFpaK9IjB2FTarTG+M+7eRpzwa" +
       "kw6d+bB++4fPnBfS+usrr98HqN5pRZHlBVhsI7EbH9jj6AId24VZkGFhEKj6" +
       "qJmCya44tfVLTcqpT2DZUVhWAjA2txkAmVlfKNnUFVW/fPa5BbtfLSehXlKj" +
       "aDTeK+AQkhZEOjNTgLZZ/fMbLTkmqqFpEvYgeRbK60AvLCvs3560zoVHpp5a" +
       "+MSG40fPibDUrTkuFvwhTAA+hBWlvLvJT7x+1c+Pf+PuCasYaC+ObAG+Rf/Y" +
       "psRu/83HeX4RmFagUAnwj0YeeWBx97XvC34XXJC7LZuftACgXd7LTqT/Gmqt" +
       "fD5EqkZJk2SXztupksF9PQrlounU01Be+8b9pZ9V53TmwHNJENg8ywZhzU2W" +
       "8I7U+F4fiMEGdOEyeC6xY/CSYAyWEfGyRbCsFm07Nh0OuszWDY2DlCyezU0r" +
       "IqO+xLScVCdkVTZTLO5PsZjGhjOQvQcNOQ0QOW7XjZcN7pYOtA2+a4XBRQUY" +
       "LLr5D0fu3H52z8sCgKsx4Y44qnvSKSRmD7A3YRPG3VYivALyRPY1v7P3gfce" +
       "teQJxlKAmB048rVPwwePWMBonQxW5hXnXh7rdBCQbkWpVQRH7+9P7vvxw/v2" +
       "W1I1++vcHjjGPfqLf70cvvdXLxYop6pimqYwquY2eFmuBJrnN7el1OavNv7k" +
       "UHN5L2TfflKdUeWbMqw/7o+7KjMT89jfPXW4sWirh0mIk7I1gA5WgsX2s9hc" +
       "b4XVhqLotNkfzavg6bDDrqNINMesaMZmID9oi3FzPImCwaky5AWTL9gOwq8R" +
       "z/sXIfPGNUi9LGhS/LkrqKdUQs9skd2Hr+vcbSc+lSUyigd4CUbU0mInPBFN" +
       "x24/cjS+7aH1ITsx3gibnWv6OoWNM8UzVSXO5MPwAXGmdQHx7YbDv/1hW3LT" +
       "TApk7GuZpgTG38sg0tcU37dBUV64/Y+LR65N7Z5BrbssYKXglN8ZeOTF61ZL" +
       "h0PiAG8hdd7B38/U6d8nNQbjGUP174yVOb/ORX+tgGe97df1wbh2Y0kEteYP" +
       "6poSrCUKoVtKjN2GzRQnDXDodY5Xdj077Mb0zdPt3dKVBXZs0kX/eE6jWhxb" +
       "A881tkbXzNwYxVgDCjsIiL8XcXKRqHLoBETZOIb7gJYxWQ++iiW/XsJch7DZ" +
       "zzGagQfvJE0WL4QYs8Y1Oe4a8MCFMuBaePpsK/TN3IDFWAsbEH/eKWY9WsJG" +
       "38LmPk7qhY2GGCQjMBJ2HnYNcv+FMkg7PCO2ViMzN0gx1ukM8t0SBnkUm29z" +
       "UisM0pOVeZ45jl/IDSbZOkkzN0cx1unM8VQJc/wIm+87e2izQZPJPHs8cQHs" +
       "0YJj6+BRbKWUaexRoKQoxhpQt1wIUu4ATnMOcDbLaaaa/0XFUS7bd/QFy43T" +
       "on2+hJFfweYUVDqGuDkbMaAgxPsRR6SlOZGSTEuHuxJQxgeohCOe/V84IsvJ" +
       "omI3eXjsXJT3N4J19S09drSxeuHRG86KeiN3PV0HlUMioyjeg5HnvVI3WEIW" +
       "VqizjklWLfoGJ4uLXzWCyaEVGpy16N/iZEFhek4qxLeX+hwnTUFqoBPfXrpf" +
       "c1Lj0kFpab14Sd4FWYAEX3+nOw7rKHFL6lqzK051eM+W+SvEnDvnT+dOT1G5" +
       "0leMiT+EnMIpY/0lNCadPLpl683nP/OQdU8mKXRqCmephSODdRuXK75WFJ3N" +
       "mauyr/2Thsdnr3LKVN89nVc2EVSwH8Sd1uLAxZHZlrs/evPYhmd+dqDyNTgk" +
       "7SBllJO5O/LP5Fk9A1Xvjmj+0QgKVXGj1dl+/+S1HYk/vyVuPYh1lFpSnH5M" +
       "OnN85+uHFx1rCZHaflIBFTjLisuCzZPqEJPGjVFSL5uQB0wOs8AxxHfuasAw" +
       "p/hXkbCLbc76XC9eoHLSmn/szL92rlG0CWZs0jKqwFc4udW6PU4R7qtfM7oe" +
       "YHB7PCftnRZYoTcgVseiA7ru3D7WpnSx63cVR6+PxSs2f/8PxjJXRyweAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
