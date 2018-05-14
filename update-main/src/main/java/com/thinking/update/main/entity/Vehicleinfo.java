package com.thinking.update.main.entity;
public class Vehicleinfo {
    private Integer vehicleId;//主键ID
    private String deviceFactoryNo;//主机厂车辆自编号
    private String lightswitchsupplier;//灯光组合开关厂家
    private String purchaseDate;//购买日期
    private String wheelaxlesModel;//车桥型号/厂家
    private String brakeshoreModel;//刹车蹄片型号/厂家
    private String electricboxModel;//电器盒型号/厂家
    private String wiperSupplier;//雨刮系统厂家
    private String tirepressureSupplier;//胎压型号/厂家
    private String deviceId;//设备号
    private String tireModel;//轮胎型号/厂家
    private Integer dayRunTime;//每日行驶时间
    private String gearBoxModel;//变速箱型号/厂家
    private String lineInfo;//班线
    private String sim;//sim卡信息
    private String motorSupplier;//电机型号/厂家
    private Integer alarm;//是否报警
    private Integer gasCost;//标准气耗
    private java.util.Date expireDate;//车辆到期日期
    private Integer eleCost;//标准电耗
    private String vehicleType;//车型
    private Integer paymentStatus;//是否欠费
    private String isReparing;//是否正在维修。改信息根据“车辆维护”信息，通过触发器自动修改
    private String engineModel;//发动机型号/厂家
    private String fsbSupplier;//总线厂家
    private Integer oilBoxCap;//油箱容量
    private String seatSupplier;//座椅厂家
    private String batteryModel;//电池型号/厂家
    private Integer deptId;//所属线路编号
    private String heaterSupplier;//暖风厂家
    private Integer oilCost;//标准油耗
    private Integer lastAlarmTime;//报警最后更新时间
    private String vehicleNo;//车牌号
    private String absModel;//ABS 型号/厂家
    private java.util.Date paymentExpiredDate;//缴费到期时间
    private String dynamoModel;//发电机型号/厂家
    private String doorpumpModel;//门泵型号/厂家
    private String producer;//车辆生产厂家
    private Integer online;
    private String engineVinNo;//发动机VIN码
    private Integer batteryCap;//电池电量
    private String vehicleSN;//车辆编号
    private Integer airBottleCap;//气瓶容量
    private Object motorType;//车辆类型：1- 燃油车，2- 电车，3- 油电混合动力车，4- 燃气车，5- 气电混合动力车
    private Integer status;//汽车状态：1-正常    2-故障   3-维修
    private Integer lastDataUpTime;//数据最后更新时间
    public Vehicleinfo() {
        super();
    }
    public Vehicleinfo(Integer vehicleId,String deviceFactoryNo,String lightswitchsupplier,String purchaseDate,String wheelaxlesModel,String brakeshoreModel,String electricboxModel,String wiperSupplier,String tirepressureSupplier,String deviceId,String tireModel,Integer dayRunTime,String gearBoxModel,String lineInfo,String sim,String motorSupplier,Integer alarm,Integer gasCost,java.util.Date expireDate,Integer eleCost,String vehicleType,Integer paymentStatus,String isReparing,String engineModel,String fsbSupplier,Integer oilBoxCap,String seatSupplier,String batteryModel,Integer deptId,String heaterSupplier,Integer oilCost,Integer lastAlarmTime,String vehicleNo,String absModel,java.util.Date paymentExpiredDate,String dynamoModel,String doorpumpModel,String producer,Integer online,String engineVinNo,Integer batteryCap,String vehicleSN,Integer airBottleCap,Object motorType,Integer status,Integer lastDataUpTime) {
        super();
        this.vehicleId = vehicleId;
        this.deviceFactoryNo = deviceFactoryNo;
        this.lightswitchsupplier = lightswitchsupplier;
        this.purchaseDate = purchaseDate;
        this.wheelaxlesModel = wheelaxlesModel;
        this.brakeshoreModel = brakeshoreModel;
        this.electricboxModel = electricboxModel;
        this.wiperSupplier = wiperSupplier;
        this.tirepressureSupplier = tirepressureSupplier;
        this.deviceId = deviceId;
        this.tireModel = tireModel;
        this.dayRunTime = dayRunTime;
        this.gearBoxModel = gearBoxModel;
        this.lineInfo = lineInfo;
        this.sim = sim;
        this.motorSupplier = motorSupplier;
        this.alarm = alarm;
        this.gasCost = gasCost;
        this.expireDate = expireDate;
        this.eleCost = eleCost;
        this.vehicleType = vehicleType;
        this.paymentStatus = paymentStatus;
        this.isReparing = isReparing;
        this.engineModel = engineModel;
        this.fsbSupplier = fsbSupplier;
        this.oilBoxCap = oilBoxCap;
        this.seatSupplier = seatSupplier;
        this.batteryModel = batteryModel;
        this.deptId = deptId;
        this.heaterSupplier = heaterSupplier;
        this.oilCost = oilCost;
        this.lastAlarmTime = lastAlarmTime;
        this.vehicleNo = vehicleNo;
        this.absModel = absModel;
        this.paymentExpiredDate = paymentExpiredDate;
        this.dynamoModel = dynamoModel;
        this.doorpumpModel = doorpumpModel;
        this.producer = producer;
        this.online = online;
        this.engineVinNo = engineVinNo;
        this.batteryCap = batteryCap;
        this.vehicleSN = vehicleSN;
        this.airBottleCap = airBottleCap;
        this.motorType = motorType;
        this.status = status;
        this.lastDataUpTime = lastDataUpTime;
    }
    public Integer getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDeviceFactoryNo() {
        return this.deviceFactoryNo;
    }

    public void setDeviceFactoryNo(String deviceFactoryNo) {
        this.deviceFactoryNo = deviceFactoryNo;
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

    public String getBrakeshoreModel() {
        return this.brakeshoreModel;
    }

    public void setBrakeshoreModel(String brakeshoreModel) {
        this.brakeshoreModel = brakeshoreModel;
    }

    public String getElectricboxModel() {
        return this.electricboxModel;
    }

    public void setElectricboxModel(String electricboxModel) {
        this.electricboxModel = electricboxModel;
    }

    public String getWiperSupplier() {
        return this.wiperSupplier;
    }

    public void setWiperSupplier(String wiperSupplier) {
        this.wiperSupplier = wiperSupplier;
    }

    public String getTirepressureSupplier() {
        return this.tirepressureSupplier;
    }

    public void setTirepressureSupplier(String tirepressureSupplier) {
        this.tirepressureSupplier = tirepressureSupplier;
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

    public String getGearBoxModel() {
        return this.gearBoxModel;
    }

    public void setGearBoxModel(String gearBoxModel) {
        this.gearBoxModel = gearBoxModel;
    }

    public String getLineInfo() {
        return this.lineInfo;
    }

    public void setLineInfo(String lineInfo) {
        this.lineInfo = lineInfo;
    }

    public String getSim() {
        return this.sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getMotorSupplier() {
        return this.motorSupplier;
    }

    public void setMotorSupplier(String motorSupplier) {
        this.motorSupplier = motorSupplier;
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

    public Integer getEleCost() {
        return this.eleCost;
    }

    public void setEleCost(Integer eleCost) {
        this.eleCost = eleCost;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getIsReparing() {
        return this.isReparing;
    }

    public void setIsReparing(String isReparing) {
        this.isReparing = isReparing;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getFsbSupplier() {
        return this.fsbSupplier;
    }

    public void setFsbSupplier(String fsbSupplier) {
        this.fsbSupplier = fsbSupplier;
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

    public String getHeaterSupplier() {
        return this.heaterSupplier;
    }

    public void setHeaterSupplier(String heaterSupplier) {
        this.heaterSupplier = heaterSupplier;
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

    public String getAbsModel() {
        return this.absModel;
    }

    public void setAbsModel(String absModel) {
        this.absModel = absModel;
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

    public Integer getAirBottleCap() {
        return this.airBottleCap;
    }

    public void setAirBottleCap(Integer airBottleCap) {
        this.airBottleCap = airBottleCap;
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

}
