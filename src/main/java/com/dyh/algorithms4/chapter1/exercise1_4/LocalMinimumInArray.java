package com.dyh.algorithms4.chapter1.exercise1_4;

/**
 * 1.4.18 数组局部最小元素
 * <p>
 * 找到一个局部最小元素满足： a[i] < a[i-1]  a[i] < a[i+1]
 */
public class LocalMinimumInArray {


    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        localMinimum(a, true);
        localMinimum2(a, true);
        System.out.println("-----------------");

        int a2[] = new int[]{3, 2, 1, 0, -1, 6, 7};
        localMinimum(a2, true);
        localMinimum2(a2, true);
        System.out.println("-----------------");

        int a3[] = new int[]{3, 2, 1, 0, -1, 6, 7};
        localMinimum(a3, true);
        localMinimum2(a3, true);
        System.out.println("-----------------");

        int a4[] = new int[]{3, 2, 1, 0, 1, -4, -5};
        localMinimum(a4, false);
        localMinimum2(a4, false);


    }

    /**
     * @param a
     * @param withBound 是否包含边界的 0 和 N - 1
     * @return
     */
    public static int localMinimum(int[] a, boolean withBound) {
        if (withBound) {
            return localMinimumWithBound(a);
        } else {
            return localMinimumWithoutBound(a);
        }
    }


    /**
     * @param a
     * @param low
     * @param high
     * @param withBound 是否包含边界
     * @return
     */
    private static int find(int[] a, int low, int high, boolean withBound) {
        if (high >= low) {
            int middle = low + (high - low) / 2;

            int left = withBound ? 0 : 1;
            if (middle - 1 < left) {
                if (a[middle] < a[middle + 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }

            int right = withBound ? a.length : a.length - 1;
            if (middle + 1 > right) {
                if (a[middle] < a[middle - 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }

            if (high == low) {
                if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }


            if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                /**  n-1       n+1
                 *    \      /
                 *     \    /
                 *      \  /
                 *       n
                 */
                return middle;
            } else if (a[middle] < a[middle - 1] && a[middle] > a[middle + 1]) {
                /**
                 * n-1
                 *  \
                 *   \
                 *    \
                 *     n
                 *      \
                 *       \
                 *        n+1
                 */
                int i = find(a, middle, high, withBound);
                if (i > -1) {
                    return i;
                } else {
                    return find(a, low, middle - 1, withBound);
                }
            } else if (a[middle] > a[middle - 1] && a[middle] < a[middle + 1]) {
                /**
                 *        n+1
                 *       /
                 *      /
                 *     n
                 *    /
                 *   /
                 *  n-1
                 */
                int i = find(a, low, middle, withBound);
                if (i > -1) {
                    return i;
                } else {
                    return find(a, middle + 1, high, withBound);
                }
            } else {
                /**
                 *       n
                 *      / \
                 *     /   \
                 *   n-1      n+1
                 */
                int i = find(a, low, middle - 1, withBound);
                if (i > -1) {
                    return i;
                } else {
                    return find(a, middle + 1, high, withBound);
                }
            }
        }

        return -1;
    }

    /**
     * @param a
     * @param withBound 是否包含边界的 0 和 N - 1. false 不包含 true 包含
     * @return
     */
    public static int localMinimum2(int[] a, boolean withBound) {
        if (withBound) {
            return localMinimumWithBound2(a);
        } else {
            return localMinimumWithoutBound2(a);
        }
    }

    public static int localMinimumWithBound2(int[] a) {
        int high = a.length - 1;
        int low = 0;

        int i = findWithBound2(a, low, high);
        System.out.println("index:" + i);
        return i;
    }

    public static int localMinimumWithoutBound2(int[] a) {
        int high = a.length - 2;
        int low = 1;

        int i = findWithoutBound2(a, low, high);
        System.out.println("index:" + i);
        return i;
    }

    /**
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int findWithBound2(int[] a, int low, int high) {
        if (high >= low) {
            int middle = low + (high - low) / 2;

            if (middle - 1 < 0) {
                if (a[middle] < a[middle + 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }

            if (middle + 1 > a.length) {
                if (a[middle] < a[middle - 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }

            if (high == low) {
                if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }


            if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                /**  n-1       n+1
                 *    \      /
                 *     \    /
                 *      \  /
                 *       n
                 */
                return middle;
            } else if (a[middle - 1] >= a[middle + 1]) {
                /**
                 * n-1                    n
                 *  \                    / \
                 *   \                  /   \
                 *    \         或     n-1   \
                 *     n                     \
                 *      \                    n+1
                 *       \
                 *        n+1
                 */
                int i = findWithBound2(a, middle, high);
                if (i > -1) {
                    return i;
                } else {
                    return findWithBound2(a, low, middle);
                }
            } else if (a[middle - 1] < a[middle + 1]) {
                /**
                 *        n+1
                 *       /
                 *      /
                 *     n
                 *    /
                 *   /
                 *  n-1
                 */
                int i = findWithBound2(a, low, middle);
                if (i > -1) {
                    return i;
                } else {
                    return findWithBound2(a, middle, high);
                }
            }
        }

        return -1;
    }

    /**
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int findWithoutBound2(int[] a, int low, int high) {
        if (high >= low) {
            int middle = low + (high - low) / 2;

            if (middle - 1 < 1 || middle + 1 > a.length - 1 || high == low) {
                if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }

            if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                /**  n-1       n+1
                 *    \      /
                 *     \    /
                 *      \  /
                 *       n
                 */
                return middle;
            } else if (a[middle - 1] >= a[middle + 1]) {
                /**
                 * n-1                    n
                 *  \                    / \
                 *   \                  /   \
                 *    \         或     n-1   \
                 *     n                     \
                 *      \                    n+1
                 *       \
                 *        n+1
                 */
                int i = findWithoutBound2(a, middle, high);
                if (i > -1) {
                    return i;
                } else {
                    return findWithoutBound2(a, low, middle);
                }
            } else if (a[middle - 1] < a[middle + 1]) {
                /**
                 *        n+1
                 *       /
                 *      /
                 *     n
                 *    /
                 *   /
                 *  n-1
                 */
                int i = findWithoutBound2(a, low, middle);
                if (i > -1) {
                    return i;
                } else {
                    return findWithoutBound2(a, middle, high);
                }
            }
        }

        return -1;
    }

    private static int localMinimumWithoutBound(int[] a) {
        int high = a.length - 2;
        int low = 1;

        int i = findWithoutBound(a, low, high);
        System.out.println("index:" + i);
        return i;
    }

    /**
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int findWithoutBound(int[] a, int low, int high) {
        if (high >= low) {
            int middle = low + (high - low) / 2;

            if (middle - 1 < 1 || middle + 1 > a.length - 2 || high == low) {
                if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }

            if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                /**  n-1       n+1
                 *    \      /
                 *     \    /
                 *      \  /
                 *       n
                 */
                return middle;
            } else if (a[middle - 1] >= a[middle + 1]) {
                /**
                 * n-1                    n
                 *  \                    / \
                 *   \                  /   \
                 *    \         或     n-1   \
                 *     n                     \
                 *      \                    n+1
                 *       \
                 *        n+1
                 */
                int i = findWithBound(a, middle, high);
                if (i > -1) {
                    return i;
                } else {
                    return findWithBound(a, low, middle);
                }
            } else if (a[middle - 1] < a[middle + 1]) {
                /**
                 *        n+1
                 *       /
                 *      /
                 *     n
                 *    /
                 *   /
                 *  n-1
                 */
                int i = findWithBound(a, low, middle);
                if (i > -1) {
                    return i;
                } else {
                    return findWithBound(a, middle, high);
                }
            }
        }

        return -1;
    }

    private static int localMinimumWithBound(int[] a) {
        int high = a.length - 1;
        int low = 0;

        int i = findWithBound(a, low, high);
        System.out.println("index:" + i);
        return i;
    }

    /**
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int findWithBound(int[] a, int low, int high) {
        if (high >= low) {
            int middle = low + (high - low) / 2;

            if (middle - 1 < 0) {
                if (a[middle] < a[middle + 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }

            if (middle + 1 > a.length) {
                if (a[middle] < a[middle - 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }

            if (high == low) {
                if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                    return middle;
                } else {
                    return -1;
                }
            }


            if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
                /**  n-1       n+1
                 *    \      /
                 *     \    /
                 *      \  /
                 *       n
                 */
                return middle;
            } else if (a[middle - 1] >= a[middle + 1]) {
                /**
                 * n-1                    n
                 *  \                    / \
                 *   \                  /   \
                 *    \         或     n-1   \
                 *     n                     \
                 *      \                    n+1
                 *       \
                 *        n+1
                 */
                int i = findWithBound(a, middle, high);
                if (i > -1) {
                    return i;
                } else {
                    return findWithBound(a, low, middle);
                }
            } else if (a[middle - 1] < a[middle + 1]) {
                /**
                 *        n+1
                 *       /
                 *      /
                 *     n
                 *    /
                 *   /
                 *  n-1
                 */
                int i = findWithBound(a, low, middle);
                if (i > -1) {
                    return i;
                } else {
                    return findWithBound(a, middle, high);
                }
            }
        }

        return -1;
    }

}
