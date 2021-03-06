package org.lore.rankings.faultlocators;

import org.lore.util.Utils;

public class GeometricMean implements Naish {

	@Override
	public double getSuspiciousness(double ef, double ep, double nf, double np) {
		double susp = ((ef * np) - (nf * ep)) / Math.sqrt( (ef + ep) * (np + nf) * (ef + nf) * (ep + np) );
		if (Double.isNaN(susp))
			susp = Utils.getLowestValue(this);
		return susp;
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

}
