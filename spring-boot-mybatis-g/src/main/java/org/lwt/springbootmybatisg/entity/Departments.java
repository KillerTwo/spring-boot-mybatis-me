package org.lwt.springbootmybatisg.entity;

public class Departments {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column departments.dept_no
     *
     * @mbg.generated Mon Aug 27 17:38:03 CST 2018
     */
    private String deptNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column departments.dept_name
     *
     * @mbg.generated Mon Aug 27 17:38:03 CST 2018
     */
    private String deptName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column departments.dept_no
     *
     * @return the value of departments.dept_no
     *
     * @mbg.generated Mon Aug 27 17:38:03 CST 2018
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column departments.dept_no
     *
     * @param deptNo the value for departments.dept_no
     *
     * @mbg.generated Mon Aug 27 17:38:03 CST 2018
     */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo == null ? null : deptNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column departments.dept_name
     *
     * @return the value of departments.dept_name
     *
     * @mbg.generated Mon Aug 27 17:38:03 CST 2018
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column departments.dept_name
     *
     * @param deptName the value for departments.dept_name
     *
     * @mbg.generated Mon Aug 27 17:38:03 CST 2018
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}