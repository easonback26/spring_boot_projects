package com.example.SpringAnno;

import org.springframework.stereotype.Component;

@Component("Snap")
public class SnapDragon implements MobileProcessor
{

    public void process()
    {
        System.out.println("World best CPU");
    }
}
