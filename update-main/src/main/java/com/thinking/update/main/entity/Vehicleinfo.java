package com.thinking.update.main.entity;
public class Vehicleinfo {
    private String deviceFactoryNo;//主机厂车辆自编号
    private String companyName;//机构名称
    private String brakeshoreModel;//刹车蹄片型号/厂家
    private String wiperSupplier;//雨刮系统厂家
    private String deviceId;//设备号
    private String tireModel;//轮胎型号/厂家
    private Integer dayRunTime;//每日行驶时间
    private String lineInfo;//班线
    private String motorSupplier;//电机型号/厂家
    private String vehicleType;//车型
    private Integer companyDeptId;//机构主键
    private String isReparing;//是否正在维修。改信息根据“车辆维护”信息，通过触发器自动修改
    private String fsbSupplier;//总线厂家
    private Integer lineDeptId;//机构主键
    private String batteryModel;//电池型号/厂家
    private Integer deptId;//所属线路编号
    private Integer oilCost;//标准油耗
    private Integer lastAlarmTime;//报警最后更新时间
    private String vehicleNo;//车牌号
    private String groupName;//机构名称
    private java.util.Date paymentExpiredDate;//缴费到期时间
    private String dynamoModel;//发电机型号/厂家
    private String doorpumpModel;//门泵型号/厂家
    private String producer;//车辆生产厂家
    private Integer batteryCap;//电池电量
    private String vehicleSN;//车辆编号
    private Object motorType;//车辆类型：
1- 燃油车
，2- 电车
，3- 油电混合动力车
，4- 燃气车
，5- 气电混合动力车
    private Integer status;//汽车状态：1-正常    2-故障   3-维修
    private Integer lastDataUpTime;//数据最后更新时间
    private String lightswitchsupplier;//灯光组合开关厂家
    private String purchaseDate;//购买日期
    private String wheelaxlesModel;//车桥型号/厂家
    private String electricboxModel;//电器盒型号/厂家
    private String lineName;//机构名称
    private Integer groupDeptId;//机构主键
    private String tirepressureSupplier;//胎压型号/厂家
    private String gearBoxModel;//变速箱型号/厂家
    private String subCompanyName;//机构名称
    private String sim;//sim卡信息
    private Integer alarm;//是否报警
    private Integer gasCost;//标准气耗
    private java.util.Date expireDate;//车辆到期日期
    private Integer vehicleId;//主键ID
    private Integer eleCost;//标准电耗
    private Integer paymentStatus;//是否欠费
    private String engineModel;//发动机型号/厂家
    private Integer oilBoxCap;//油箱容量
    private String seatSupplier;//座椅厂家
    private Integer subCompanyDeptId;//机构主键
    private String heaterSupplier;//暖风厂家
    private String absModel;//ABS 型号/厂家
    private Integer online;
    private String engineVinNo;//发动机VIN码
    private Integer airBottleCap;//气瓶容量
    public Vehicleinfo() {
        super();
    }
    public Vehicleinfo(String deviceFactoryNo,String companyName,String brakeshoreModel,String wiperSupplier,String deviceId,String tireModel,Integer dayRunTime,String lineInfo,String motorSupplier,String vehicleType,Integer companyDeptId,String isReparing,String fsbSupplier,Integer lineDeptId,String batteryModel,Integer deptId,Integer oilCost,Integer lastAlarmTime,String vehicleNo,String groupName,java.util.Date paymentExpiredDate,String dynamoModel,String doorpumpModel,String producer,Integer batteryCap,String vehicleSN,Object motorType,Integer status,Integer lastDataUpTime,String lightswitchsupplier,String purchaseDate,String wheelaxlesModel,String electricboxModel,String lineName,Integer groupDeptId,String tirepressureSupplier,String gearBoxModel,String subCompanyName,String sim,Integer alarm,Integer gasCost,java.util.Date expireDate,Integer vehicleId,Integer eleCost,Integer paymentStatus,String engineModel,Integer oilBoxCap,String seatSupplier,Integer subCompanyDeptId,String heaterSupplier,String absModel,Integer online,String engineVinNo,Integer airBottleCap) {
        super();
        this.deviceFactoryNo = deviceFactoryNo;
        this.companyName = companyName;
        this.brakeshoreModel = brakeshoreModel;
        this.wiperSupplier = wiperSupplier;
        this.deviceId = deviceId;
        this.tireModel = tireModel;
        this.dayRunTime = dayRunTime;
        this.lineInfo = lineInfo;
        this.motorSupplier = motorSupplier;
        this.vehicleType = vehicleType;
        this.companyDeptId = companyDeptId;
        this.isReparing = isReparing;
        this.fsbSupplier = fsbSupplier;
        this.lineDeptId = lineDeptId;
        this.batteryModel = batteryModel;
        this.deptId = deptId;
        this.oilCost = oilCost;
        this.lastAlarmTime = lastAlarmTime;
        this.vehicleNo = vehicleNo;
        this.groupName = groupName;
        this.paymentExpiredDate = paymentExpiredDate;
        this.dynamoModel = dynamoModel;
        this.doorpumpModel = doorpumpModel;
        this.producer = producer;
        this.batteryCap = batteryCap;
        this.vehicleSN = vehicleSN;
        this.motorType = motorType;
        this.status = status;
        this.lastDataUpTime = lastDataUpTime;
        this.lightswitchsupplier = lightswitchsupplier;
        this.purchaseDate = purchaseDate;
        this.wheelaxlesModel = wheelaxlesModel;
        this.electricboxModel = electricboxModel;
        this.lineName = lineName;
        this.groupDeptId = groupDeptId;
        this.tirepressureSupplier = tirepressureSupplier;
        this.gearBoxModel = gearBoxModel;
        this.subCompanyName = subCompanyName;
        this.sim = sim;
        this.alarm = alarm;
        this.gasCost = gasCost;
        this.expireDate = expireDate;
        this.vehicleId = vehicleId;
        this.eleCost = eleCost;
        this.paymentStatus = paymentStatus;
        this.engineModel = engineModel;
        this.oilBoxCap = oilBoxCap;
        this.seatSupplier = seatSupplier;
        this.subCompanyDeptId = subCompanyDeptId;
        this.heaterSupplier = heaterSupplier;
        this.absModel = absModel;
        this.online = online;
        this.engineVinNo = engineVinNo;
        this.airBottleCap = airBottleCap;
    }
    public String getDeviceFactoryNo() {
        return this.deviceFactoryNo;
    }

    public void setDeviceFactoryNo(String deviceFactoryNo) {
        this.deviceFactoryNo = deviceFactoryNo;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBrakeshoreModel() {
        return this.brakeshoreModel;
    }

    public void setBrakeshoreModel(String brakeshoreModel) {
        this.brakeshoreModel = brakeshoreModel;
    }

    public String getWiperSupplier() {
        return this.wiperSupplier;
    }

    public void setWiperSupplier(String wiperSupplier) {
        this.wiperSupplier = wiperSupplier;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTireModel() {
        return this.tireModel;
    }

    public void setTireModel(String tireModel) {
        this.tireModel = tireModel;
    }

    public Integer getDayRunTime() {
        return this.dayRunTime;
    }

    public void setDayRunTime(Integer dayRunTime) {
        this.dayRunTime = dayRunTime;
    }

    public String getLineInfo() {
        return this.lineInfo;
    }

    public void setLineInfo(String lineInfo) {
        this.lineInfo = lineInfo;
    }

    public String getMotorSupplier() {
        return this.motorSupplier;
    }

    public void setMotorSupplier(String motorSupplier) {
        this.motorSupplier = motorSupplier;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getCompanyDeptId() {
        return this.companyDeptId;
    }

    public void setCompanyDeptId(Integer companyDeptId) {
        this.companyDeptId = companyDeptId;
    }

    public String getIsReparing() {
        return this.isReparing;
    }

    public void setIsReparing(String isReparing) {
        this.isReparing = isReparing;
    }

    public String getFsbSupplier() {
        return this.fsbSupplier;
    }

    public void setFsbSupplier(String fsbSupplier) {
        this.fsbSupplier = fsbSupplier;
    }

    public Integer getLineDeptId() {
        return this.lineDeptId;
    }

    public void setLineDeptId(Integer lineDeptId) {
        this.lineDeptId = lineDeptId;
    }

    public String getBatteryModel() {
        return this.batteryModel;
    }

    public void setBatteryModel(String batteryModel) {
        this.batteryModel = batteryModel;
    }

    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getOilCost() {
        return this.oilCost;
    }

    public void setOilCost(Integer oilCost) {
        this.oilCost = oilCost;
    }

    public Integer getLastAlarmTime() {
        return this.lastAlarmTime;
    }

    public void setLastAlarmTime(Integer lastAlarmTime) {
        this.lastAlarmTime = lastAlarmTime;
    }

    public String getVehicleNo() {
        return this.vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public java.util.Date getPaymentExpiredDate() {
        return this.paymentExpiredDate;
    }

    public void setPaymentExpiredDate(java.util.Date paymentExpiredDate) {
        this.paymentExpiredDate = paymentExpiredDate;
    }

    public String getDynamoModel() {
        return this.dynamoModel;
    }

    public void setDynamoModel(String dynamoModel) {
        this.dynamoModel = dynamoModel;
    }

    public String getDoorpumpModel() {
        return this.doorpumpModel;
    }

    public void setDoorpumpModel(String doorpumpModel) {
        this.doorpumpModel = doorpumpModel;
    }

    public String getProducer() {
        return this.producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getBatteryCap() {
        return this.batteryCap;
    }

    public void setBatteryCap(Integer batteryCap) {
        this.batteryCap = batteryCap;
    }

    public String getVehicleSN() {
        return this.vehicleSN;
    }

    public void setVehicleSN(String vehicleSN) {
        this.vehicleSN = vehicleSN;
    }

    public Object getMotorType() {
        return this.motorType;
    }

    public void setMotorType(Object motorType) {
        this.motorType = motorType;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLastDataUpTime() {
        return this.lastDataUpTime;
    }

    public void setLastDataUpTime(Integer lastDataUpTime) {
        this.lastDataUpTime = lastDataUpTime;
    }

    public String getLightswitchsupplier() {
        return this.lightswitchsupplier;
    }

    public void setLightswitchsupplier(String lightswitchsupplier) {
        this.lightswitchsupplier = lightswitchsupplier;
    }

    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getWheelaxlesModel() {
        return this.wheelaxlesModel;
    }

    public void setWheelaxlesModel(String wheelaxlesModel) {
        this.wheelaxlesModel = wheelaxlesModel;
    }

    public String getElectricboxModel() {
        return this.electricboxModel;
    }

    public void setElectricboxModel(String electricboxModel) {
        this.electricboxModel = electricboxModel;
    }

    public String getLineName() {
        return this.lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Integer getGroupDeptId() {
        return this.groupDeptId;
    }

    public void setGroupDeptId(Integer groupDeptId) {
        this.groupDeptId = groupDeptId;
    }

    public String getTirepressureSupplier() {
        return this.tirepressureSupplier;
    }

    public void setTirepressureSupplier(String tirepressureSupplier) {
        this.tirepressureSupplier = tirepressureSupplier;
    }

    public String getGearBoxModel() {
        return this.gearBoxModel;
    }

    public void setGearBoxModel(String gearBoxModel) {
        this.gearBoxModel = gearBoxModel;
    }

    public String getSubCompanyName() {
        return this.subCompanyName;
    }

    public void setSubCompanyName(String subCompanyName) {
        this.subCompanyName = subCompanyName;
    }

    public String getSim() {
        return this.sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public Integer getAlarm() {
        return this.alarm;
    }

    public void setAlarm(Integer alarm) {
        this.alarm = alarm;
    }

    public Integer getGasCost() {
        return this.gasCost;
    }

    public void setGasCost(Integer gasCost) {
        this.gasCost = gasCost;
    }

    public java.util.Date getExpireDate() {
        return this.expireDate;
    }

    public void setExpireDate(java.util.Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getEleCost() {
        return this.eleCost;
    }

    public void setEleCost(Integer eleCost) {
        this.eleCost = eleCost;
    }

    public Integer getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public Integer getOilBoxCap() {
        return this.oilBoxCap;
    }

    public void setOilBoxCap(Integer oilBoxCap) {
        this.oilBoxCap = oilBoxCap;
    }

    public String getSeatSupplier() {
        return this.seatSupplier;
    }

    public void setSeatSupplier(String seatSupplier) {
        this.seatSupplier = seatSupplier;
    }

    public Integer getSubCompanyDeptId() {
        return this.subCompanyDeptId;
    }

    public void setSubCompanyDeptId(Integer subCompanyDeptId) {
        this.subCompanyDeptId = subCompanyDeptId;
    }

    public String getHeaterSupplier() {
        return this.heaterSupplier;
    }

    public void setHeaterSupplier(String heaterSupplier) {
        this.heaterSupplier = heaterSupplier;
    }

    public String getAbsModel() {
        return this.absModel;
    }

    public void setAbsModel(String absModel) {
        this.absModel = absModel;
    }

    public Integer getOnline() {
        return this.online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getEngineVinNo() {
        return this.engineVinNo;
    }

    public void setEngineVinNo(String engineVinNo) {
        this.engineVinNo = engineVinNo;
    }

    public Integer getAirBottleCap() {
        return this.airBottleCap;
    }

    public void setAirBottleCap(Integer airBottleCap) {
        this.airBottleCap = airBottleCap;
    }

}
