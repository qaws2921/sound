package com.mes.mesScm.Half.DTO;

import lombok.Data;

@Data
public class SCM_HIN {
    private String site_code;
    private String in_no;
    private String work_date;
    private String line_code;
    private String user_code;
    private String create_date;
    private String update_date;

    private int rec_count;
    private int rownum;
    private int rownum_page;

    private String part_code;
    private String user_name;
    private String line_name;
    private String part_name;
    private String spec;
    private String spec_all;
    private String unit_name;
    private double qty;

    private String keyword;
}
