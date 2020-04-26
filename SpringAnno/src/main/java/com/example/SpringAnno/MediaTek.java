package com.example.SpringAnno;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class MediaTek implements MobileProcessor
{
    @Override
    //@Qualifier("MediaTek")
    public void process()
    {
        System.out.println("2nd best cpu");
    }
}
