# Software_Engineering_2024

This is software engineering. We love coding!

### Computation: Riemann Summmation
We intend to compute the integral f(x) = an artbitray function, over an arbitrary domanin, with n rectrangles, where n is a positive integer provided by the user.

![System Diagram 1](images/gh_API_diagram.png)


### Performance Diagnostics
Prior to any performance optimization, we observed the following execution time when calculating 70,000,000 inputs ranging from 1 to 99 averaged over 5 iterations. Each input is done 700,000 times. Cumulative number of calculations is 3,465,000,000 per iteration, so total is 17,325,000,000 individual CPU calculations.  
I noticed that a cache would likely drastically improve the performance, epecially when computing the same values multiple times for multiple runs. To do this, I used an in memory concurrent hash map that the compute engine checks on dispatch, and inserts into after computation if a value was not found.  
The cache, as shown below significantly decreases the amount of time it takes for the entire system to run on the same amount of inputs.  
**Daniel's Computer - Pre-Optimization:** ~20256 ms.  
**Daniel's Computer - Post-Cache-Optimization:** ~8513 ms - 57.97% improvement.

Following cache optimization, I implemented some memory and thread optimizations that decreased the number of threads and heap usage, but likely sacrafices some quantity of time.
