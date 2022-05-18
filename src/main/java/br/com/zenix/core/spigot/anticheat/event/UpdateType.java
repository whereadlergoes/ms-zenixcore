package br.com.zenix.core.spigot.anticheat.event;

import br.com.zenix.core.spigot.anticheat.util.UtilTime;

public enum UpdateType {
	
	MIN_64(3840000L), 
	MIN_32(1920000L), 
	MIN_16(960000L), 
	MIN_08(480000L), 
	MIN_05(300000L), 
	MIN_04(240000L), 
	MIN_02(120000L), 
	MIN_01(60000L), 
	SLOWEST(32000L), 
	SLOWER(16000L), 
	SLOW(4000L), 
	SEC_05(5000L), 
	SEC_04(4000L), 
	SEC_03(3000L), 
	SEC_02(2000L), 
	SEC(1000L), 
	FAST(500L), 
	FASTER(250L), 
	FASTEST(125L), 
	TICK(49L);

	private long time, last, timeSpend, timeCount;

	private UpdateType(long time) {
		this.time = time;
		this.last = System.currentTimeMillis();
	}

	public boolean Elapsed() {
		if (UtilTime.elapsed(this.last, this.time)) {
			this.last = System.currentTimeMillis();
			return true;
		}
		return false;
	}

	public void StartTime() {
		this.timeCount = System.currentTimeMillis();
	}

	public void StopTime() {
		this.timeSpend += System.currentTimeMillis() - this.timeCount;
	}

	public void PrintAndResetTime() {
		System.out.println(name() + " in a second: " + this.timeSpend);
		this.timeSpend = 0L;
	}
}