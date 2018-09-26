package com.czg;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

//        int a = 0;
//
//        a = 2 % 2;
//
//        System.out.println(a);

//        System.out.println(coinProblem(89798879, 123));

        char a = 1;
        System.out.println(a+"--------");
        int b = (int)a;
        System.out.println(b);
    }


    /**
     * 零钱问题
     * @param n: The guest paid
     * @param m: the price
     * @return: the sum of the number of banknotes
     */
    public static int coinProblem(int n, int m) {
        // Write your code here
        int retMoney = n - m;
        int hundred = 0;
        int fifty = 0;
        int twenty = 0;
        int ten = 0;
        int five = 0;
        int two = 0;
        int one = 0;

        if (retMoney >= 100) {
            hundred = retMoney / 100;
            retMoney = retMoney - hundred * 100;
        }

        if (retMoney >= 50) {
            fifty = retMoney / 50;
            retMoney = retMoney - fifty * 50;
            if (retMoney >= 20) {
                twenty = retMoney / 20;
                retMoney = retMoney - twenty * 20;

                if (retMoney >= 10) {
                    ten = retMoney / 10;
                    retMoney = retMoney - ten * 10;
                    if (retMoney >= 5) {
                        retMoney = retMoney - 5;
                        five++;
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    } else {
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    }


                } else {
                    if (retMoney >= 5) {
                        retMoney = retMoney - 5;
                        five++;
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    } else {
                        if (retMoney >= 2) {
                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    }
                }
            } else {
                if (retMoney >= 10) {
                    ten = retMoney / 10;
                    retMoney = retMoney - ten * 10;
                    if (retMoney >= 5) {
                        retMoney = retMoney - 5;
                        five++;
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    } else {
                        if (retMoney >= 2) {
                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    }


                } else {
                    if (retMoney >= 5) {
                        retMoney = retMoney - 5;
                        five++;
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    } else {
                        if (retMoney >= 2) {
                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    }
                }

            }
        } else {
            if (retMoney >= 20) {
                twenty = retMoney / 20;
                retMoney = retMoney - twenty * 20;

                if (retMoney >= 10) {
                    ten = retMoney / 10;
                    retMoney = retMoney - ten * 10;
                    if (retMoney >= 5) {
                        retMoney = retMoney - 5;
                        five++;
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    } else {
                        if (retMoney >= 2) {
                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    }


                } else {
                    if (retMoney >= 5) {
                        retMoney = retMoney - 5;
                        five++;
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    } else {
                        if (retMoney >= 2) {
                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    }
                }
            } else {
                if (retMoney >= 10) {
                    ten = retMoney / 10;
                    retMoney = retMoney - ten * 10;
                    if (retMoney >= 5) {
                        retMoney = retMoney - 5;
                        five++;
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    } else {
                        if (retMoney >= 2) {
                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    }


                } else {
                    if (retMoney >= 5) {
                        retMoney = retMoney - 5;
                        five++;
                        if (retMoney >= 2) {

                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    } else {
                        if (retMoney >= 2) {
                            two = retMoney / 2;
                            retMoney = retMoney - two * 2;
                            if (retMoney >= 1) {
                                one = retMoney;
                            }
                        } else {
                            if (retMoney > 0) {
                                one = retMoney;
                            }
                        }
                    }
                }

            }
        }


        return hundred + fifty + twenty + ten + five + two + one;

    }


    public static int coinProblem1(int n, int m) {


        return 0;
    }

}
