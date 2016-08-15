package org.apache.batik.gvt;
public class FillShapePainter implements org.apache.batik.gvt.ShapePainter {
    protected java.awt.Shape shape;
    protected java.awt.Paint paint;
    public FillShapePainter(java.awt.Shape shape) { super();
                                                    if (shape == null) throw new java.lang.IllegalArgumentException(
                                                                         "Shape can not be null!");
                                                    this.shape = shape;
    }
    public void setPaint(java.awt.Paint newPaint) { this.paint = newPaint;
    }
    public java.awt.Paint getPaint() { return paint; }
    public void paint(java.awt.Graphics2D g2d) { if (paint != null) {
                                                     g2d.
                                                       setPaint(
                                                         paint);
                                                     g2d.
                                                       fill(
                                                         shape);
                                                 } }
    public java.awt.Shape getPaintedArea() { if (paint == null) return null;
                                             return shape; }
    public java.awt.geom.Rectangle2D getPaintedBounds2D() { if (paint ==
                                                                  null ||
                                                                  shape ==
                                                                  null)
                                                                return null;
                                                            return shape.
                                                              getBounds2D(
                                                                );
    }
    public boolean inPaintedArea(java.awt.geom.Point2D pt) { if (paint ==
                                                                   null ||
                                                                   shape ==
                                                                   null)
                                                                 return false;
                                                             return shape.
                                                               contains(
                                                                 pt);
    }
    public java.awt.Shape getSensitiveArea() { return shape; }
    public java.awt.geom.Rectangle2D getSensitiveBounds2D() { if (shape ==
                                                                    null)
                                                                  return null;
                                                              return shape.
                                                                getBounds2D(
                                                                  );
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) { if (shape ==
                                                                     null)
                                                                   return false;
                                                               return shape.
                                                                 contains(
                                                                   pt);
    }
    public void setShape(java.awt.Shape shape) { if (shape == null) {
                                                     throw new java.lang.IllegalArgumentException(
                                                       );
                                                 }
                                                 this.shape =
                                                   shape;
    }
    public java.awt.Shape getShape() { return shape; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZDWwcxRWeOzv+jX8T5z9OYpy0SeAOAklFDZTE2Inhkpzi" +
       "EJVLwZnbmztvvLe77M7ZF9O0IRIlVGpKIT+0gkhUQdAUCP1BLW2haVH5EWkl" +
       "flpKK37UopYWohKh0hYo9L2Z3du9vZ/IUm1px3sz772Z9+a9772ZffAMmWFb" +
       "pJvpPML3mMyODOg8Ti2bpfo1atvboW9EOVpD37vhrS2XhkldgrSOUnuzQm02" +
       "qDItZSfIYlW3OdUVZm9hLIUccYvZzBqnXDX0BOlS7aGsqamKyjcbKYYEO6gV" +
       "Ix2Uc0tN5jgbcgRwsjgGK4mKlUTXB4f7YmSmYph7PPJ5PvJ+3whSZr25bE7a" +
       "Y7vpOI3muKpFY6rN+/IWWW0a2p6MZvAIy/PIbm2tY4KrY2tLTNDzSNv7H94+" +
       "2i5MMIvqusGFevY2ZhvaOEvFSJvXO6CxrH0j+RKpiZFmHzEnvTF30ihMGoVJ" +
       "XW09Klh9C9Nz2X5DqMNdSXWmggviZFmxEJNaNOuIiYs1g4QG7ugumEHbpQVt" +
       "pZYlKh5eHT109Ib279eQtgRpU/VhXI4Ci+AwSQIMyrJJZtnrUymWSpAOHTZ7" +
       "mFkq1dRJZ6c7bTWjU56D7XfNgp05k1liTs9WsI+gm5VTuGEV1EsLh3J+zUhr" +
       "NAO6zvF0lRoOYj8o2KTCwqw0Bb9zWGrHVD3FyZIgR0HH3muAAFjrs4yPGoWp" +
       "anUKHaRTuohG9Ux0GFxPzwDpDAMc0OJkQUWhaGuTKmM0w0bQIwN0cTkEVI3C" +
       "EMjCSVeQTEiCXVoQ2CXf/pzZctnBm/RNepiEYM0ppmi4/mZg6g4wbWNpZjGI" +
       "A8k4c1XsCJ3z+IEwIUDcFSCWND/64tkrz+8+9YykWViGZmtyN1P4iHI82fr8" +
       "ov6Vl9bgMhpMw1Zx84s0F1EWd0b68iYgzJyCRByMuIOntj113b4T7O0waRoi" +
       "dYqh5bLgRx2KkTVVjVkbmc4syllqiDQyPdUvxodIPbzHVJ3J3q3ptM34EKnV" +
       "RFedIX6DidIgAk3UBO+qnjbcd5PyUfGeNwkh9fCQtfAsI/JP/Ofk89FRI8ui" +
       "VKG6qhvRuGWg/nYUECcJth2NJsHrx6K2kbPABaOGlYlS8INR5gxkxnl0UNW0" +
       "4VEKiEiFt0bQw8xplJ1HvWZNhEJg8kXBgNcgVjYZWopZI8qh3IaBsw+PPCed" +
       "CQPAsQgny2G6iJwuIqaLwHSR4HQkFBKzzMZp5abCloxBcAO6zlw5fP3Vuw70" +
       "1IA3mRO1YE8k7SnKMv0eAriwPaKc7GyZXPbaRU+GSW2MdFKF56iGSWO9lQE4" +
       "UsaciJ2ZhPzjpYGlvjSA+csyFJYCFKqUDhwpDcY4s7Cfk9k+CW6SwnCMVk4R" +
       "ZddPTt01cfOOL18YJuFi5McpZwBoIXsc8bqAy73BiC8nt+3Wt94/eWSv4cV+" +
       "USpxM2AJJ+rQE/SDoHlGlFVL6aMjj+/tFWZvBGzmsMkIe93BOYqgpc+FadSl" +
       "ARROG1aWajjk2riJj1rGhNcjHLRDvM8Gt2jGWFsIzyVO8In/ODrHxHaudGj0" +
       "s4AWIg1cPmze8/vf/O1iYW43Y7T5Uv0w430+lEJhnQKPOjy33W4xBnSv3hW/" +
       "8/CZW3cKnwWK88pN2IttP6ATbCGY+ZZnbnzl9deOvxT2/JxDms4lodrJF5TE" +
       "ftJURUmYbYW3HkA5DdAAvab3Wh38U02rNKkxDKyP2pZf9Og7B9ulH2jQ47rR" +
       "+ecW4PXP30D2PXfDv7qFmJCCWdazmUcmoXuWJ3m9ZdE9uI78zS8s/ubT9B5I" +
       "AgC8tjrJBJaGnFjHRc3jpFVw0gkeEcgh9nKtGLxQtMIOgoWIsUuxWW77Y6I4" +
       "7HxF0ohy+0vvtux494mzQoniKsvvApup2Se9DpsVeRA/N4hZm6g9CnSXnNry" +
       "hXbt1IcgMQESFcBee6sFeJkvchiHekb9H37x5Jxdz9eQ8CBp0gyaGqQi9kgj" +
       "OD2zRwFq8+bnrpR7PtEATbtQlZQoX9KBdl9SfkcHsiYXezD547k/vOz+Y68J" +
       "5zOljIWCP4zoXwS2olb34v3Ei5/57f3fODIhs/3KyiAX4Jv3wVYtuf9P/y4x" +
       "uYC3MpVIgD8RffDuBf1XvC34PZxB7t58acYCrPZ415zI/jPcU/erMKlPkHbF" +
       "qY13UC2H0ZuAetB2C2aon4vGi2s7Wcj0FXB0URDjfNMGEc7LlPCO1PjeEgC1" +
       "VtzCBfCscOJ9RRDUQkS8XCNYPiXaVdhc4GJIo2kZHFbJUgEYaakilsNZDuMM" +
       "f6yTuIntZ7GJSTmXV3THgdLlr3bmWV1h+dvl8rHZUrrKStywShNLiFKQEJVF" +
       "YN3XVll33pt/dWF+8VcXLOf8YOvFSQGolpUtefzlDsLG4kq1uThXHN9/6Fhq" +
       "630XyZjqLK53B+A499Dv/ns6ctcbz5YpuRq5YV6gsXGm+VbXjFMWRfFmcWzx" +
       "QuLV1jv+/FhvZsNUqiXs6z5HPYS/l4ASqyoDQ3ApT+//+4LtV4zumkLhsyRg" +
       "zqDI72x+8NmNK5Q7wuKMJmO15GxXzNRXHKFNFoPDqL69KE7PKy4+Pg2P41vy" +
       "f2nxUcbLCim9EmsgyzmJEX9eJ6SaVdKgwMMxThrgGCPcz66K0XFLzUJ1M+6c" +
       "9qJ7O18fu/uth6QfBgE5QMwOHPrqJ5GDh6RPyvPzeSVHWD+PPEOLdbZLc3wC" +
       "fyF4PsYHlcAO/A+w2+8c5JYWTnKYqSyyrNqyxBSDfz2596cP7L017BgFipTa" +
       "cUNNedCgnQvSqmdY7OiX25Ap7GsHjs2HZ6Ozrxun7hKVWKvs+FeqjB3A5mbw" +
       "hozjDcKJPDPsnwYziMhYDk/c0SU+dTNUYi0fGS4Szypkg40WNUdVxV5zlZjs" +
       "ziomOorNQTex4I8Jzz5fny43WQJPwlEyMXX7VGKtoue3q4wdx+YeSKeum7DU" +
       "eotR7F3nGePYNBhjLo6thEdxNFKmboxKrFUUPlll7HvYnAD88YyxwcjpKXAm" +
       "19HmFxwtw4xsZBsUW1AcasyhENb67jRYaxaOLYUn66icnbq1KrFWD62uYo3j" +
       "BtjFCa4nqtjyl9g8xkmLqvv8qvg6B4uO4VzS5oH0sia+SznQG39T5qL5ZRgk" +
       "XdcD0a/teHn3aVE9NGC5UsjZvlIFyhrfJUI7Nnlpdu57n+SkPmkYGqN6iSUs" +
       "Mrt4DXL6q25r+9ntnTWDUEcNkYacrt6YY0Op4lqi3s4lfYvyLnNFh39FmP44" +
       "Ca1yz2TClX4yXSi0TIiQf/mpu1Il1ioO8XKVsVeweYGTdgi8YabbwhfK4NCL" +
       "04VDeNrY5+i0b+rmqMRaReU3q4z9BZvXOZntN4eLRDj2A88kb0wX2PTAc5uj" +
       "121TN0kl1soV7s+F1LNV7PIeNu9w8ZUp6CVPeSY5M52lzWFHr8NTN0kl1som" +
       "WSekflzZJCEh5z+y6B92T/G+MuaD6ax273UUunfqtqjEWkXV5ipjLdjUyWq3" +
       "YAYPOEL1/w8z5AGggt8z8MZtXsknUvlZT3n4WFvD3GPXviwO2oVPbzMhV6Vz" +
       "mua/E/K915kWS6vChDPlDZEpVOwCPCh338BJDbS45tBsSQlJuz1ICVWu+O+n" +
       "W8hJk0fHSZ188ZN0g3QgwdclplsRtIuKAC/FIvJSLC+LhYV++wnv6zqX2Qss" +
       "/otzPKqKj9Nuxs3Jz9MjysljV2+56ey6++TFvaLRyUmU0gx5Vn5DcBK9/6QY" +
       "lObKqtu08sPWRxqXuyfFDrlgz3UX+pCnHwLSxL1eELjVtnsLl9uvHL/siV8f" +
       "qHsBDsU7SYjCoWRn6fVh3sxZZPHOWGk9sYNa4rq9b+W39lxxfvoffxQXtETW" +
       "H4sq048oL91//Yt3zDveHSbNQ2QGHIJZXtxrXrVHh/p03EpAEWYP5GGJIEWl" +
       "WlGx0opuSfGztbCLY86WQi9+9uGkp/RwX/qxrEkzJpgl8hSKgXKn2euROxO4" +
       "aMmZZoDB6/HVbM9hkxe1BvjjSGyzabqXBbUfmSI6T5eDz9PCh9eIV3y7+H89" +
       "Jd0yuCIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
