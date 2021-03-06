package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo(value={Scope.LIBRARY_GROUP}) public class PathParser {
    class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
            super();
        }
    }

    public class PathDataNode {
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public float[] mParams;
        @RestrictTo(value={Scope.LIBRARY_GROUP}) public char mType;

        PathDataNode(char arg1, float[] arg2) {
            super();
            this.mType = arg1;
            this.mParams = arg2;
        }

        PathDataNode(PathDataNode arg3) {
            super();
            this.mType = arg3.mType;
            this.mParams = PathParser.copyOfRange(arg3.mParams, 0, arg3.mParams.length);
        }

        private static void addCommand(Path arg27, float[] arg28, char arg29, char arg30, float[] arg31) {
            Path v10 = arg27;
            float[] v13 = arg31;
            float v0 = arg28[0];
            float v1 = arg28[1];
            int v16 = 2;
            float v2 = arg28[v16];
            int v17 = 3;
            float v3 = arg28[v17];
            int v18 = 4;
            float v4 = arg28[v18];
            int v19 = 5;
            float v5 = arg28[v19];
            switch(arg30) {
                case 65: 
                case 97: {
                    goto label_31;
                }
                case 67: 
                case 99: {
                    goto label_28;
                }
                case 81: 
                case 83: 
                case 113: 
                case 115: {
                    goto label_24;
                }
                case 72: 
                case 86: 
                case 104: 
                case 118: {
                    goto label_26;
                }
                case 90: 
                case 122: {
                    goto label_17;
                }
            }

            goto label_15;
        label_17:
            arg27.close();
            v10.moveTo(v4, v5);
            v0 = v4;
            v2 = v0;
            v1 = v5;
            v3 = v1;
        label_15:
            int v20 = 2;
            goto label_33;
        label_24:
            v20 = 4;
            goto label_33;
        label_26:
            v20 = 1;
            goto label_33;
        label_28:
            v20 = 6;
            goto label_33;
        label_31:
            v20 = 7;
        label_33:
            float v8 = v0;
            float v7 = v1;
            float v21 = v4;
            float v22 = v5;
            int v9 = 0;
            int v0_1;
            for(v0_1 = arg29; v9 < v13.length; v0_1 = arg30) {
                int v1_1 = 81;
                int v5_1 = 0x74;
                int v6 = 0x73;
                int v15 = 0x71;
                int v14 = 99;
                float v23 = 2f;
                v4 = 0f;
                switch(arg30) {
                    case 65: {
                        goto label_371;
                    }
                    case 67: {
                        goto label_348;
                    }
                    case 72: {
                        goto label_341;
                    }
                    case 76: {
                        goto label_332;
                    }
                    case 77: {
                        goto label_316;
                    }
                    case 81: {
                        goto label_299;
                    }
                    case 83: {
                        goto label_265;
                    }
                    case 84: {
                        goto label_241;
                    }
                    case 86: {
                        goto label_234;
                    }
                    case 97: {
                        goto label_192;
                    }
                    case 99: {
                        goto label_167;
                    }
                    case 104: {
                        goto label_161;
                    }
                    case 108: {
                        goto label_151;
                    }
                    case 109: {
                        goto label_134;
                    }
                    case 113: {
                        goto label_116;
                    }
                    case 115: {
                        goto label_83;
                    }
                    case 116: {
                        goto label_59;
                    }
                    case 118: {
                        goto label_53;
                    }
                }

                goto label_51;
            label_161:
                v0_1 = v9;
                v10.rLineTo(v13[v0_1], 0f);
                v8 += v13[v0_1];
                goto label_51;
            label_134:
                v0_1 = v9;
                v8 += v13[v0_1];
                v1_1 = v9 + 1;
                v7 += v13[v1_1];
                if(v9 > 0) {
                    v10.rLineTo(v13[v0_1], v13[v1_1]);
                    goto label_51;
                }

                v10.rMoveTo(v13[v0_1], v13[v1_1]);
                v22 = v7;
                v21 = v8;
                goto label_51;
            label_167:
                v14 = v9 + 2;
                v15 = v9 + 3;
                int v23_1 = v9 + 4;
                int v24 = v9 + 5;
                arg27.rCubicTo(v13[v9], v13[v9 + 1], v13[v14], v13[v15], v13[v23_1], v13[v24]);
                v0 = v13[v14] + v8;
                v1 = v13[v15] + v7;
                v8 += v13[v23_1];
                v7 += v13[v24];
                goto label_189;
            label_265:
                float v12 = v7;
                float v11 = v8;
                int v25 = v9;
                if(v0_1 == v14 || v0_1 == v6 || v0_1 == 67 || v0_1 == 83) {
                    v8 = v11 * v23 - v2;
                    v2 = v12 * v23 - v3;
                    v1 = v8;
                }
                else {
                    v1 = v11;
                    v2 = v12;
                }

                v9 = v25;
                int v7_1 = v25 + 1;
                int v8_1 = v25 + 2;
                int v11_1 = v25 + 3;
                arg27.cubicTo(v1, v2, v13[v9], v13[v7_1], v13[v8_1], v13[v11_1]);
                v0 = v13[v9];
                v1 = v13[v7_1];
                v8 = v13[v8_1];
                v7 = v13[v11_1];
                goto label_313;
            label_234:
                v25 = v9;
                v9 = v25;
                v10.lineTo(v8, v13[v9]);
                v7 = v13[v9];
                goto label_410;
            label_299:
                v25 = v9;
                v9 = v25;
                v1_1 = v25 + 1;
                int v3_1 = v25 + 2;
                v5_1 = v25 + 3;
                v10.quadTo(v13[v9], v13[v1_1], v13[v3_1], v13[v5_1]);
                v0 = v13[v9];
                v1 = v13[v1_1];
                v8 = v13[v3_1];
                v7 = v13[v5_1];
            label_313:
                v2 = v0;
                v3 = v1;
                goto label_410;
            label_332:
                v25 = v9;
                v9 = v25;
                v1_1 = v25 + 1;
                v10.lineTo(v13[v9], v13[v1_1]);
                v8 = v13[v9];
                v7 = v13[v1_1];
                goto label_410;
            label_241:
                v12 = v7;
                v11 = v8;
                v25 = v9;
                if(v0_1 == v15 || v0_1 == v5_1 || v0_1 == v1_1 || v0_1 == 84) {
                    v12 = v12 * v23 - v3;
                    v11 = v11 * v23 - v2;
                }

                v9 = v25;
                v1_1 = v25 + 1;
                v10.quadTo(v11, v12, v13[v9], v13[v1_1]);
                v8 = v13[v9];
                v7 = v13[v1_1];
                v2 = v11;
                v3 = v12;
                goto label_410;
            label_371:
                v12 = v7;
                v11 = v8;
                v25 = v9;
                v14 = v25 + 5;
                v3 = v13[v14];
                v15 = v25 + 6;
                v5 = v13[v15];
                float v6_1 = v13[v25];
                v7 = v13[v25 + 1];
                v8 = v13[v25 + 2];
                boolean v9_1 = v13[v25 + 3] != 0f ? true : false;
                boolean v23_2 = v13[v25 + 4] != 0f ? true : false;
                PathDataNode.drawArc(arg27, v11, v12, v3, v5, v6_1, v7, v8, v9_1, v23_2);
                v8 = v13[v14];
                v7 = v13[v15];
                goto label_408;
            label_83:
                if(v0_1 == v14 || v0_1 == v6 || v0_1 == 67 || v0_1 == 83) {
                    v0 = v8 - v2;
                    v2 = v7 - v3;
                    v1 = v0;
                }
                else {
                    v1 = 0f;
                    v2 = 0f;
                }

                v14 = v9;
                v15 = v9 + 1;
                v23_1 = v9 + 2;
                v24 = v9 + 3;
                arg27.rCubicTo(v1, v2, v13[v14], v13[v15], v13[v23_1], v13[v24]);
                v0 = v13[v14] + v8;
                v1 = v13[v15] + v7;
                v8 += v13[v23_1];
                v7 += v13[v24];
                goto label_189;
            label_116:
                v0_1 = v9;
                int v2_1 = v9 + 1;
                int v4_1 = v9 + 2;
                v6 = v9 + 3;
                v10.rQuadTo(v13[v0_1], v13[v2_1], v13[v4_1], v13[v6]);
                v0 = v13[v0_1] + v8;
                v1 = v13[v2_1] + v7;
                v8 += v13[v4_1];
                v7 += v13[v6];
            label_189:
                v2 = v0;
                v3 = v1;
                goto label_51;
            label_341:
                v25 = v9;
                v9 = v25;
                v10.lineTo(v13[v9], v7);
                v8 = v13[v9];
                goto label_410;
            label_53:
                v0_1 = v9;
                v10.rLineTo(0f, v13[v0_1]);
                v7 += v13[v0_1];
                goto label_51;
            label_151:
                v0_1 = v9;
                v4_1 = v9 + 1;
                v10.rLineTo(v13[v0_1], v13[v4_1]);
                v8 += v13[v0_1];
                v7 += v13[v4_1];
                goto label_51;
            label_59:
                if(v0_1 == v15 || v0_1 == v5_1 || v0_1 == v1_1 || v0_1 == 84) {
                    v4 = v8 - v2;
                    v0 = v7 - v3;
                }
                else {
                    v0 = 0f;
                }

                v1_1 = v9;
                v3_1 = v9 + 1;
                v10.rQuadTo(v4, v0, v13[v1_1], v13[v3_1]);
                v4 += v8;
                v0 += v7;
                v8 += v13[v1_1];
                v7 += v13[v3_1];
                v3 = v0;
                v2 = v4;
            label_51:
                v25 = v9;
                goto label_410;
            label_348:
                v25 = v9;
                v9 = v25 + 2;
                v7_1 = v25 + 3;
                v8_1 = v25 + 4;
                v11_1 = v25 + 5;
                arg27.cubicTo(v13[v25], v13[v25 + 1], v13[v9], v13[v7_1], v13[v8_1], v13[v11_1]);
                v8 = v13[v8_1];
                v0 = v13[v11_1];
                v1 = v13[v9];
                v2 = v13[v7_1];
                v7 = v0;
                v3 = v2;
                v2 = v1;
                goto label_410;
            label_316:
                v25 = v9;
                v9 = v25;
                v8 = v13[v9];
                v0_1 = v25 + 1;
                v7 = v13[v0_1];
                if(v25 > 0) {
                    v10.lineTo(v13[v9], v13[v0_1]);
                }
                else {
                    v10.moveTo(v13[v9], v13[v0_1]);
                    v22 = v7;
                    v21 = v8;
                    goto label_410;
                label_192:
                    v14 = v9 + 5;
                    v3 = v13[v14] + v8;
                    v15 = v9 + 6;
                    v5 = v13[v15] + v7;
                    v6_1 = v13[v9];
                    v23 = v13[v9 + 1];
                    float v24_1 = v13[v9 + 2];
                    boolean v25_1 = v13[v9 + 3] != 0f ? true : false;
                    boolean v26 = v13[v9 + 4] != 0f ? true : false;
                    v1 = v8;
                    v11 = v8;
                    boolean v8_2 = v25_1;
                    v25 = v9;
                    PathDataNode.drawArc(arg27, v1, v7, v3, v5, v6_1, v23, v24_1, v8_2, v26);
                    v8 = v11 + v13[v14];
                    v7 += v13[v15];
                label_408:
                    v3 = v7;
                    v2 = v8;
                }

            label_410:
                v9 = v25 + v20;
            }

            arg28[0] = v8;
            arg28[1] = v7;
            arg28[v16] = v2;
            arg28[v17] = v3;
            arg28[v18] = v21;
            arg28[v19] = v22;
        }

        private static void arcToBezier(Path arg55, double arg56, double arg58, double arg60, double arg62, double arg64, double arg66, double arg68, double arg70, double arg72) {
            double v0 = arg60;
            int v8 = ((int)Math.ceil(Math.abs(arg72 * 4 / 3.141593)));
            double v9 = Math.cos(arg68);
            double v11 = Math.sin(arg68);
            double v13 = Math.cos(arg70);
            double v15 = Math.sin(arg70);
            double v6 = -v0;
            double v18 = v6 * v9;
            double v22 = arg62 * v11;
            double v20 = v18 * v15 - v22 * v13;
            v6 *= v11;
            double v2 = arg62 * v9;
            v15 = v15 * v6 + v13 * v2;
            double v4 = arg72 / (((double)v8));
            int v13_1 = 0;
            double v26 = arg66;
            double v28 = v15;
            double v24 = v20;
            v20 = arg64;
            double v14 = arg70;
            while(v13_1 < v8) {
                double v30 = v14 + v4;
                double v32 = Math.sin(v30);
                double v34 = Math.cos(v30);
                double v40 = v4;
                v4 = arg56 + v0 * v9 * v34 - v22 * v32;
                v0 = arg58 + v0 * v11 * v34 + v2 * v32;
                double v36 = v18 * v32 - v22 * v34;
                v32 = v32 * v6 + v34 * v2;
                v14 = v30 - v14;
                v34 = Math.tan(v14 / 2);
                v14 = Math.sin(v14) * (Math.sqrt(v34 * 3 * v34 + 4) - 1) / 3;
                arg55.rLineTo(0f, 0f);
                arg55.cubicTo(((float)(v20 + v24 * v14)), ((float)(v26 + v28 * v14)), ((float)(v4 - v14 * v36)), ((float)(v0 - v14 * v32)), ((float)v4), ((float)v0));
                ++v13_1;
                v26 = v0;
                v20 = v4;
                v14 = v30;
                v28 = v32;
                v24 = v36;
                v4 = v40;
                v2 = v2;
                v6 = v6;
                v8 = v8;
                v9 = v9;
                v11 = v11;
                v0 = arg60;
            }
        }

        private static void drawArc(Path arg41, float arg42, float arg43, float arg44, float arg45, float arg46, float arg47, float arg48, boolean arg49, boolean arg50) {
            float v0 = arg46;
            double v19 = Math.toRadians(((double)arg48));
            double v4 = Math.cos(v19);
            double v10 = Math.sin(v19);
            double v13 = ((double)arg42);
            double v15 = v13 * v4;
            double v25 = v13;
            v13 = ((double)arg43);
            double v6 = ((double)v0);
            v15 = (v15 + v13 * v10) / v6;
            double v8 = (((double)(-arg42))) * v10 + v13 * v4;
            double v27 = v13;
            v13 = ((double)arg47);
            double v29 = v8 / v13;
            v8 = ((double)arg45);
            double v1 = ((((double)arg44)) * v4 + v8 * v10) / v6;
            double v31 = v6;
            v6 = ((((double)(-arg44))) * v10 + v8 * v4) / v13;
            v8 = v15 - v1;
            double v17 = v29 - v6;
            double v21 = (v15 + v1) / 2;
            double v33 = (v29 + v6) / 2;
            double v37 = v10;
            v10 = v8 * v8 + v17 * v17;
            double v23 = 0;
            if(v10 == v23) {
                Log.w("PathParser", " Points are coincident");
                return;
            }

            double v35 = 1 / v10 - 0.25;
            if(v35 < v23) {
                Log.w("PathParser", "Points are too far apart " + v10);
                float v1_1 = ((float)(Math.sqrt(v10) / 1.99999));
                PathDataNode.drawArc(arg41, arg42, arg43, arg44, arg45, v0 * v1_1, arg47 * v1_1, arg48, arg49, arg50);
                return;
            }

            v10 = Math.sqrt(v35);
            v8 *= v10;
            v10 *= v17;
            boolean v3 = arg50;
            if(arg49 == v3) {
                v21 -= v10;
                v33 += v8;
            }
            else {
                v21 += v10;
                v33 -= v8;
            }

            v29 = Math.atan2(v29 - v33, v15 - v21);
            double v0_1 = Math.atan2(v6 - v33, v1 - v21) - v29;
            int v2_1 = Double.compare(v0_1, v23);
            boolean v6_1 = v2_1 >= 0 ? true : false;
            if(v3 != v6_1) {
                v6 = 6.283185;
                if(v2_1 > 0) {
                    v0_1 -= v6;
                }
                else {
                    v0_1 += v6;
                }
            }

            v21 *= v31;
            v33 *= v13;
            PathDataNode.arcToBezier(arg41, v21 * v4 - v33 * v37, v21 * v37 + v33 * v4, v31, v13, v25, v27, v19, v29, v0_1);
        }

        public void interpolatePathDataNode(PathDataNode arg5, PathDataNode arg6, float arg7) {
            int v0;
            for(v0 = 0; v0 < arg5.mParams.length; ++v0) {
                this.mParams[v0] = arg5.mParams[v0] * (1f - arg7) + arg6.mParams[v0] * arg7;
            }
        }

        public static void nodesToPath(PathDataNode[] arg5, Path arg6) {
            float[] v0 = new float[6];
            char v1 = 'm';
            int v2;
            for(v2 = 0; v2 < arg5.length; ++v2) {
                PathDataNode.addCommand(arg6, v0, v1, arg5[v2].mType, arg5[v2].mParams);
                v1 = arg5[v2].mType;
            }
        }
    }

    private static final String LOGTAG = "PathParser";

    private PathParser() {
        super();
    }

    private static void addNode(ArrayList arg1, char arg2, float[] arg3) {
        arg1.add(new PathDataNode(arg2, arg3));
    }

    public static boolean canMorph(PathDataNode[] arg4, PathDataNode[] arg5) {
        if(arg4 != null) {
            if(arg5 == null) {
            }
            else if(arg4.length != arg5.length) {
                return 0;
            }
            else {
                int v1 = 0;
                while(true) {
                    if(v1 < arg4.length) {
                        if(arg4[v1].mType == arg5[v1].mType) {
                            if(arg4[v1].mParams.length != arg5[v1].mParams.length) {
                            }
                            else {
                                ++v1;
                                continue;
                            }
                        }

                        return 0;
                    }
                    else {
                        return 1;
                    }
                }

                return 0;
            }
        }

        return 0;
    }

    static float[] copyOfRange(float[] arg2, int arg3, int arg4) {
        if(arg3 <= arg4) {
            int v0 = arg2.length;
            if(arg3 >= 0 && arg3 <= v0) {
                arg4 -= arg3;
                v0 = Math.min(arg4, v0 - arg3);
                float[] v4 = new float[arg4];
                System.arraycopy(arg2, arg3, v4, 0, v0);
                return v4;
            }

            throw new ArrayIndexOutOfBoundsException();
        }

        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String arg7) {
        if(arg7 == null) {
            return null;
        }

        ArrayList v0 = new ArrayList();
        int v3 = 1;
        int v4 = 0;
        while(v3 < arg7.length()) {
            v3 = PathParser.nextStart(arg7, v3);
            String v4_1 = arg7.substring(v4, v3).trim();
            if(v4_1.length() > 0) {
                PathParser.addNode(v0, v4_1.charAt(0), PathParser.getFloats(v4_1));
            }

            v4 = v3;
            ++v3;
        }

        if(v3 - v4 == 1 && v4 < arg7.length()) {
            PathParser.addNode(v0, arg7.charAt(v4), new float[0]);
        }

        return v0.toArray(new PathDataNode[v0.size()]);
    }

    public static Path createPathFromPathData(String arg4) {
        Path v0 = new Path();
        PathDataNode[] v1 = PathParser.createNodesFromPathData(arg4);
        if(v1 != null) {
            try {
                PathDataNode.nodesToPath(v1, v0);
                return v0;
            }
            catch(RuntimeException v0_1) {
                StringBuilder v2 = new StringBuilder();
                v2.append("Error in parsing ");
                v2.append(arg4);
                throw new RuntimeException(v2.toString(), ((Throwable)v0_1));
            }
        }

        return null;
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] arg4) {
        if(arg4 == null) {
            return null;
        }

        PathDataNode[] v0 = new PathDataNode[arg4.length];
        int v1;
        for(v1 = 0; v1 < arg4.length; ++v1) {
            v0[v1] = new PathDataNode(arg4[v1]);
        }

        return v0;
    }

    private static void extract(String arg8, int arg9, ExtractFloatResult arg10) {
        arg10.mEndWithNegOrDot = false;
        int v1 = arg9;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(v1 < arg8.length()) {
            int v5 = arg8.charAt(v1);
            if(v5 != 0x20) {
                if(v5 != 69 && v5 != 101) {
                    switch(v5) {
                        case 44: {
                            goto label_32;
                        }
                        case 45: {
                            goto label_24;
                        }
                        case 46: {
                            goto label_18;
                        }
                    }

                    goto label_28;
                label_18:
                    if(v3 == 0) {
                        v2 = 0;
                        v3 = 1;
                        goto label_34;
                    }
                    else {
                        arg10.mEndWithNegOrDot = true;
                        goto label_32;
                    label_24:
                        if(v1 == arg9 || v2 != 0) {
                        label_28:
                            v2 = 0;
                            goto label_34;
                        }
                        else {
                            arg10.mEndWithNegOrDot = true;
                            goto label_32;
                        }
                    }
                }

                v2 = 1;
            }
            else {
            label_32:
                v2 = 0;
                v4 = 1;
            }

        label_34:
            if(v4 != 0) {
                break;
            }

            ++v1;
        }

        arg10.mEndPosition = v1;
    }

    private static float[] getFloats(String arg8) {
        if(arg8.charAt(0) != 0x7A) {
            if(arg8.charAt(0) == 90) {
            }
            else {
                try {
                    float[] v1 = new float[arg8.length()];
                    ExtractFloatResult v2 = new ExtractFloatResult();
                    int v3 = arg8.length();
                    int v4 = 1;
                    int v5 = 0;
                    while(v4 < v3) {
                        PathParser.extract(arg8, v4, v2);
                        int v6 = v2.mEndPosition;
                        if(v4 < v6) {
                            v1[v5] = Float.parseFloat(arg8.substring(v4, v6));
                            ++v5;
                        }

                        if(v2.mEndWithNegOrDot) {
                            v4 = v6;
                            continue;
                        }

                        v4 = v6 + 1;
                    }

                    return PathParser.copyOfRange(v1, 0, v5);
                }
                catch(NumberFormatException v0) {
                    StringBuilder v2_1 = new StringBuilder();
                    v2_1.append("error in parsing \"");
                    v2_1.append(arg8);
                    v2_1.append("\"");
                    throw new RuntimeException(v2_1.toString(), ((Throwable)v0));
                }
            }
        }

        return new float[0];
    }

    private static int nextStart(String arg3, int arg4) {
        while(arg4 < arg3.length()) {
            int v0 = arg3.charAt(arg4);
            if(((v0 - 65) * (v0 - 90) <= 0 || (v0 - 97) * (v0 - 0x7A) <= 0) && (v0 != 101 && v0 != 69)) {
                return arg4;
            }

            ++arg4;
        }

        return arg4;
    }

    public static void updateNodes(PathDataNode[] arg5, PathDataNode[] arg6) {
        int v1;
        for(v1 = 0; v1 < arg6.length; ++v1) {
            arg5[v1].mType = arg6[v1].mType;
            int v2;
            for(v2 = 0; v2 < arg6[v1].mParams.length; ++v2) {
                arg5[v1].mParams[v2] = arg6[v1].mParams[v2];
            }
        }
    }
}

