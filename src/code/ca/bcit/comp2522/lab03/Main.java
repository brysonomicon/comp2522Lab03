package ca.bcit.comp2522.lab03;

public class Main
{
    public static void main(final String[] args)
    {
        // Declare IPads
        final IPadAir5 ipad_air1;
        final IPadAir5 ipad_air2;
        final IPadAir5 ipad_air3;

        final IPadPro6 ipad_pro1;
        final IPadPro6 ipad_pro2;
        final IPadPro6 ipad_pro3;

        // Declare IPhones
        final IPhonePro13 iphone_pro1;
        final IPhonePro13 iphone_pro2;
        final IPhonePro13 iphone_pro3;

        final IPhoneSE3 iphone_se1;
        final IPhoneSE3 iphone_se2;
        final IPhoneSE3 iphone_se3;

        // Declare IPods
        final IPodNano7 ipod_nano1;
        final IPodNano7 ipod_nano2;
        final IPodNano7 ipod_nano3;

        final IPodTouch7 ipod_touch1;
        final IPodTouch7 ipod_touch2;
        final IPodTouch7 ipod_touch3;

        // Initialize IPads
        ipad_air1 = new IPadAir5(true, 15, 256, false);
        ipad_air2 = new IPadAir5(false, 14, 128, false);
        ipad_air3 = new IPadAir5(true, 15, 512, true);

        ipad_pro1 = new IPadPro6(true, 18, 512);
        ipad_pro2 = new IPadPro6(false, 18, 256);
        ipad_pro3 = new IPadPro6(true, 18, 512);

        // Initialize IPhones iphoneSE 1 != 2, 1 == 3
        iphone_se1 = new IPhoneSE3(180.00, "Telus", 64);
        iphone_se2 = new IPhoneSE3(500.00, "Rogers", 32);
        iphone_se3 = new IPhoneSE3(1200.00, "Bell", 64);

        iphone_pro1 = new IPhonePro13(1000.00, "Rogers", 512);
        iphone_pro2 = new IPhonePro13(1000.00, "Bell", 256);
        iphone_pro3 = new IPhonePro13(1200.00, "Telus", 128);

        // Initialize IPods
        ipod_nano1 = new IPodNano7(300, 75.00, 16);
        ipod_nano2 = new IPodNano7(150, 80.00, 16);
        ipod_nano3 = new IPodNano7(300, 90.00, 8);

        ipod_touch1 = new IPodTouch7(300, 90.00, 32);
        ipod_touch2 = new IPodTouch7(150, 80.00, 16);
        ipod_touch3 = new IPodTouch7(300, 80.00, 32);

        // Test IPads ipad1 != ipad2, ipad1 == ipad3
        System.out.printf("%s equality test:\n", ipad_air1.getClass().getSimpleName());

        if(ipad_air1.equals(ipad_air2)) // 1 == 2
        {
            System.out.println("INCORRECT: Ipad 1 should not be equal to Ipad 2");
        }
        else // 1 != 2
        {
            System.out.println("CORRECT: Ipad 1 is not equal to Ipad 2");
        }

        if(ipad_air1.equals(ipad_air3)) // 1 == 3
        {
            System.out.println("CORRECT: Ipad 1 is equal to Ipad 3");
        }
        else // 1 != 3
        {
            System.out.println("INCORRECT: Ipad 1 should be equal to Ipad 3");
        }

        System.out.printf("\n%s equality test:\n", ipad_pro1.getClass().getSimpleName());

        if(ipad_pro1.equals(ipad_pro2)) // 1 == 2
        {
            System.out.println("INCORRECT: Ipad 1 should not be equal to Ipad 2");
        }
        else // 1 != 2
        {
            System.out.println("CORRECT: Ipad 1 is not equal to Ipad 2");
        }

        if(ipad_pro1.equals(ipad_pro3)) // 1 == 3
        {
            System.out.println("CORRECT: Ipad 1 is equal to Ipad 3");
        }
        else // 1 != 3
        {
            System.out.println("INCORRECT: Ipad 1 should be equal to Ipad 3");
        }


        // Test IPhones iphoneSE1 != SE2, SE1 == SE3
        System.out.printf("\n%s equality tests:\n", iphone_se1.getClass().getSimpleName());

        if(iphone_se1.equals(iphone_se2)) // 1 == 2
        {
            System.out.println("INCORRECT: Iphone 1 should not be equal to Iphone 2");
        }
        else // 1 != 2
        {
            System.out.println("CORRECT: Iphone 1 is not equal to Iphone 2");
        }

        if(iphone_se1.equals(iphone_se3)) // 1 == 3
        {
            System.out.println("CORRECT: Ipad 1 is equal to Ipad 3");
        }
        else // 1 != 3
        {
            System.out.println("INCORRECT: Iphone 1 should not be equal to Iphone 3");
        }

        // Test iphone pro, 1 == 2, 1 != 3
        System.out.printf("\n%s equality tests:\n", iphone_pro1.getClass().getSimpleName());

        if(iphone_pro1.equals(iphone_pro2))
        {
            System.out.println("CORRECT: Iphone 1 is equal to Iphone 2");
        }
        else
        {
            System.out.println("INCORRECT: Iphone 1 should not be equal to Iphone 2");
        }

        if(iphone_pro1.equals(iphone_pro3))
        {
            System.out.println("INCORRECT: Iphone 1 should not be equal to Iphone 3");
        }
        else
        {
            System.out.println("CORRECT: Iphone 1 is not equal to Iphone 3");
        }


        // Test Ipods 1 != 2, 1 == 3
        System.out.printf("\n%s equality tests:\n", ipod_nano1.getClass().getSimpleName());

        if(ipod_nano1.equals(ipod_nano2))
        {
            System.out.println("INCORRECT: Ipod 1 should not be equal to Ipod 2");
        }
        else
        {
            System.out.println("CORRECT: Ipod 1 is not equal to Ipod 2");
        }

        if(ipod_nano1.equals(ipod_nano3))
        {
            System.out.println("CORRECT: Ipod 1 is equal to Ipod 3");
        }
        else
        {
            System.out.println("INCORRECT: Ipod 1 should not be equal to Ipod 3");
        }

        System.out.printf("\n%s equality tests:\n", ipod_touch1.getClass().getSimpleName());

        if(ipod_touch1.equals(ipod_touch2))
        {
            System.out.println("INCORRECT: Ipod 1 should not be equal to Ipod 2");
        }
        else
        {
            System.out.println("CORRECT: Ipod 1 is not equal to Ipod 2");
        }

        if(ipod_touch1.equals(ipod_touch3))
        {
            System.out.println("CORRECT: Ipod 1 is equal to Ipod 3");
        }
        else
        {
            System.out.println("INCORRECT: Ipod 1 should be equal to Ipod 3");
        }
    }
}
