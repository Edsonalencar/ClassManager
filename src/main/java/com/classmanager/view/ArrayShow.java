package com.classmanager.view;

import static java.lang.System.out;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.classmanager.enums.*;
import com.classmanager.view.Telas;
import com.classmanager.model.*;

public class ArrayShow {
	private static long id;
	
	public static void Guardar(long l) {
		setid(l);	
	}
	
	public static void setid(long i) {
        if (i > 0) {
            id = i;
        }
    }
	
	public static long getid() {
		return id;
	}
	
}
